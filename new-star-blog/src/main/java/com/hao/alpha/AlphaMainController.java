package com.hao.alpha;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/alpha")
public class AlphaMainController {
    @GetMapping
    public String alpha(){
        return "/alpha/index";
    }
}
