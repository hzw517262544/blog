package blog.elasticsearch.repository;

import blog.elasticsearch.entity.EsBlog;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;

public interface EsBlogRepository extends ElasticsearchRepository<EsBlog,String> {
//    Page<EsBlog> findDistincEsBlogByTitleContainOrSummaryContainOrContentContain(String title, String summary, String content, Pageable pageable);
}
