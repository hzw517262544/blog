package com.hao.blog.service.impl;

import javax.transaction.Transactional;

import com.hao.blog.service.BlogService;
import com.hao.blog.service.EsBlogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

import com.hao.blog.domain.Blog;
import com.hao.blog.domain.Catalog;
import com.hao.blog.domain.Comment;
import com.hao.blog.domain.User;
import com.hao.blog.domain.Vote;
import com.hao.blog.domain.es.EsBlog;
import com.hao.blog.repository.BlogRepository;

/**
 * Blog 服务.
 * 
 * @since 1.0.0 2017年4月7日
 * @author <a href="https://waylau.com">Way Lau</a>
 */
@Service
public class BlogServiceImpl implements BlogService {

	@Autowired
	private BlogRepository blogRepository;
	@Autowired
	private EsBlogService esBlogService;
 
	/* (non-Javadoc)
	 * @see BlogService#saveBlog(Blog)
	 */
	@Transactional
	@Override
	public Blog saveBlog(Blog blog) {
		boolean isNew = (blog.getId() == null);
		EsBlog esBlog = null;
		
		Blog returnBlog = blogRepository.save(blog);
		
		if (isNew) {
			esBlog = new EsBlog(returnBlog);
		} else {
			esBlog = esBlogService.getEsBlogByBlogId(blog.getId());
			esBlog.update(returnBlog);
		}
		
		esBlogService.updateEsBlog(esBlog);
		return returnBlog;
	}

	/* (non-Javadoc)
	 * @see BlogService#removeBlog(java.lang.Long)
	 */
	@Transactional
	@Override
	public void removeBlog(Long id) {
		blogRepository.delete(id);
		EsBlog esblog = esBlogService.getEsBlogByBlogId(id);
		esBlogService.removeEsBlog(esblog.getId());
	}

	/* (non-Javadoc)
	 * @see BlogService#getBlogById(java.lang.Long)
	 */
	@Override
	public Blog getBlogById(Long id) {
		return blogRepository.findOne(id);
	}

	@Override
	public Page<Blog> listBlogsByTitleVote(User user, String title, Pageable pageable) {
		// 模糊查询
		title = "%" + title + "%";
		//Page<Blog> blogs = blogRepository.findByUserAndTitleLikeOrderByCreateTimeDesc(user, title, pageable);
		String tags = title;
		Page<Blog> blogs = blogRepository.findByTitleLikeAndUserOrTagsLikeAndUserOrderByCreateTimeDesc(title,user, tags,user, pageable);
		return blogs;
	}

	@Override
	public Page<Blog> listBlogsByTitleVoteAndSort(User user, String title, Pageable pageable) {
		// 模糊查询
		title = "%" + title + "%";
		Page<Blog> blogs = blogRepository.findByUserAndTitleLike(user, title, pageable);
		return blogs;
	}
	
	@Override
	public Page<Blog> listBlogsByCatalog(Catalog catalog, Pageable pageable) {
		Page<Blog> blogs = blogRepository.findByCatalog(catalog, pageable);
		return blogs;
	}

	@Override
	public void readingIncrease(Long id) {
		Blog blog = blogRepository.findOne(id);
		blog.setReadSize(blog.getCommentSize()+1);
		this.saveBlog(blog);
	}

	@Override
	public Blog createComment(Long blogId, String commentContent) {
		Blog originalBlog = blogRepository.findOne(blogId);
		User user = (User)SecurityContextHolder.getContext().getAuthentication().getPrincipal(); 
		Comment comment = new Comment(user, commentContent);
		originalBlog.addComment(comment);
		return this.saveBlog(originalBlog);
	}

	@Override
	public void removeComment(Long blogId, Long commentId) {
		Blog originalBlog = blogRepository.findOne(blogId);
		originalBlog.removeComment(commentId);
		this.saveBlog(originalBlog);
	}

	@Override
	public Blog createVote(Long blogId) {
		Blog originalBlog = blogRepository.findOne(blogId);
		User user = (User)SecurityContextHolder.getContext().getAuthentication().getPrincipal(); 
		Vote vote = new Vote(user);
		boolean isExist = originalBlog.addVote(vote);
		if (isExist) {
			throw new IllegalArgumentException("该用户已经点过赞了");
		}
		return this.saveBlog(originalBlog);
	}

	@Override
	public void removeVote(Long blogId, Long voteId) {
		Blog originalBlog = blogRepository.findOne(blogId);
		originalBlog.removeVote(voteId);
		this.saveBlog(originalBlog);
	}
}
