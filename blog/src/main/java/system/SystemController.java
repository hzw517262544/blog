package system;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class SystemController {
    @RequestMapping("/error")
    public String error(){
        return "error.....";
    }
}
