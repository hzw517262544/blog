package com.hao.alpha;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/alpha/tables")
public class TableController {
    @GetMapping("/simple")
    public String simpleTable(){
        return "alpha/pages/tables/simple";
    }
    @GetMapping("/data")
    public String dataTable(){
        return "alpha/pages/tables/data";
    }
}
