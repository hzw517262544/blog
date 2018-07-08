package blog.service.es;

import blog.entity.es.EsBlog;
import blog.repository.es.EsBlogRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;

public class EsBlogService {
    @Autowired(required=true)
    private EsBlogRepository esBlogRepository;
    public void find(){
        initEsBlogRepository();
        Pageable pageable = new PageRequest(0,20);
        String title = "1";
        String summary = "2";
        String content = "3";
        Page<EsBlog> page = esBlogRepository.findDistincEsBlogByTitleContainingOrSummaryContainingOrContentContaining(title,summary,content,pageable);
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
    }
}
