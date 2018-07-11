package com.hao.fxghw.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/fxghw")
public class FxMainController {
    @GetMapping
    public String index(){
        return "fxghw/index";
    }
}
