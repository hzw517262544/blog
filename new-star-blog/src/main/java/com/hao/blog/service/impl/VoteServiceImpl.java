package com.hao.blog.service.impl;

import javax.transaction.Transactional;

import com.hao.blog.service.VoteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hao.blog.domain.Vote;
import com.hao.blog.repository.VoteRepository;

/**
 * Vote 服务.
 * 
 * @since 1.0.0 2017年4月9日
 * @author <a href="https://waylau.com">Way Lau</a>
 */
@Service
public class VoteServiceImpl implements VoteService {

	@Autowired
	private VoteRepository voteRepository;
	/* (non-Javadoc)
	 * @see VoteService#removeVote(java.lang.Long)
	 */
	@Override
	@Transactional
	public void removeVote(Long id) {
		voteRepository.delete(id);
	}
	@Override
	public Vote getVoteById(Long id) {
		return voteRepository.findOne(id);
	}

}
