package blog.controller.user;

import blog.entity.user.User;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

@RestController
@RequestMapping("/user")
public class UserController {
    @GetMapping("/list")
    public ModelAndView list(Model model){
        model.addAttribute("userList","");
        model.addAttribute("title","用户管理");
        return new ModelAndView("user/list.html","userModel",model);
    }
    @GetMapping("{id}")
    public ModelAndView view(@PathVariable("id")Long id, Model model){
        model.addAttribute("user","");
        model.addAttribute("title","查看用户");
        return new ModelAndView("user/view","userModel",model);
    }
    @GetMapping("/form")
    public ModelAndView from(Model model){
        model.addAttribute("user",new User());
        model.addAttribute("title","新建用户");
        return new ModelAndView("user/form","userModel",model);
    }
    @PostMapping("/save")
    public ModelAndView saveOrUpdate(User user){

        return new ModelAndView("user/list","","");
    }
}
