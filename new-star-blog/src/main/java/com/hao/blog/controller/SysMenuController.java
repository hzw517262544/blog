package com.hao.blog.controller;

import com.hao.blog.domain.SysMenu;
import com.hao.blog.service.AuthorityService;
import com.hao.blog.service.MenuService;
import com.hao.blog.util.ConstraintViolationExceptionHandler;
import com.hao.blog.vo.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.validation.ConstraintViolationException;
import java.util.List;

/**
 * @author haozw
 * @describe:
 * @modified by:
 * @modified date:
 * @since
 */
@Controller
@RequestMapping("/sysMenu")
public class SysMenuController {
    @Autowired
    private MenuService menuService;
    @Autowired
    private AuthorityService authorityService;
    /**
     *
     * @param async
     * @param pageIndex
     * @param pageSize
     * @param name
     * @param model
     * @return
     */
    @GetMapping
    public ModelAndView list(@RequestParam(value="async",required=false) boolean async,
                             @RequestParam(value="pageIndex",required=false,defaultValue="0") int pageIndex,
                             @RequestParam(value="pageSize",required=false,defaultValue="10") int pageSize,
                             @RequestParam(value="name",required=false,defaultValue="") String name,
                             Model model, HttpServletRequest request, HttpServletResponse response) {

        String menuName = request.getParameter("name");
        Pageable pageable = new PageRequest(pageIndex, pageSize);
        Page<SysMenu> page = menuService.findByNameLike(name, pageable);
        List<SysMenu> list = page.getContent();	// 当前所在页面数据列表

        model.addAttribute("page", page);
        model.addAttribute("menuList", list);
        return new ModelAndView(async==true?"menus/list :: #mainContainerRepleace":"menus/list", "menuModel", model);
    }
    @GetMapping("/add")
    public ModelAndView createMenu(Model model){
        model.addAttribute("menu",new SysMenu());
        return new ModelAndView("menus/add","menuModel",model);
    }

    @PostMapping
    public ResponseEntity<Response> create(SysMenu menu) {
        try {
            menuService.saveMenu(menu);
        }  catch (ConstraintViolationException e)  {
            return ResponseEntity.ok().body(new Response(false, ConstraintViolationExceptionHandler.getMessage(e)));
        }
        return ResponseEntity.ok().body(new Response(true, "保存成功！", menu));
    }
    @DeleteMapping("/{id}")
    public ResponseEntity<Response> deleteMenu(@PathVariable("id")Long id,Model model){
        menuService.deleteMenu(id);
        return ResponseEntity.ok().body(new Response(true,"删除成功！"));
    }
    @GetMapping("/edit/{id}")
    public ModelAndView editMenu(@PathVariable("id")Long id, Model model){
        SysMenu sysMenu = menuService.findSysMenusById(id);
        model.addAttribute("menu",sysMenu);
        return new ModelAndView("menus/edit","menuModel",model);
    }
    @GetMapping("/detail/{id}")
    public ModelAndView detailMenu(@PathVariable("id")Long id,Model model){
        SysMenu sysMenu = menuService.findSysMenusById(id);
        model.addAttribute("menu",sysMenu);
        return new ModelAndView("menus/detail","menuModel",model);
    }
}
