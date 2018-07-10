package blog.controller.hello;

import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

@RestController
public class HelloController {
    @RequestMapping("/hello")
    public ModelAndView list(Model model){
        model.addAttribute("userList","");
        model.addAttribute("title","用户管理");
        return new ModelAndView("hello/hello","userModel",model);
    }

}
