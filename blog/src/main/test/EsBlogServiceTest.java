import blog.service.es.EsBlogService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import javax.annotation.Resource;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = EsBlogService.class)
public class EsBlogServiceTest {
    @Resource
    private EsBlogService esBlogService;
    @Test
    public void testfind(){
        esBlogService.find();
    }
}
