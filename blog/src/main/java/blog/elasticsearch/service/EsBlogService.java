package blog.elasticsearch.service;

import blog.elasticsearch.entity.EsBlog;
import blog.elasticsearch.repository.EsBlogRepository;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;

import javax.annotation.Resource;

public class EsBlogService {
    /*@Resource
    private EsBlogRepository esBlogRepository;
    public void find(){
        initEsBlogRepository();
        Pageable pageable = new PageRequest(0,20);
        String title = "1";
        String summary = "2";
        String content = "3";
        Page<EsBlog> page = esBlogRepository.findDistincEsBlogByTitleContainOrSummaryContainOrContentContain(title,summary,content,pageable);
        if(page.getSize()>0){
            for(EsBlog esBlog : page.getContent()){
                System.out.println(esBlog.toString());
            }
        }
    }

    public void initEsBlogRepository(){
        esBlogRepository.deleteAll();
        esBlogRepository.save(new EsBlog("1","2","3"));
        esBlogRepository.save(new EsBlog("4","5","6"));
        esBlogRepository.save(new EsBlog("7","8","9"));
    }*/
}
