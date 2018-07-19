package com.hao.blog.controller;

import com.hao.blog.domain.User;
import com.hao.blog.service.MenuService;
import com.hao.blog.domain.SysMenu;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import java.util.ArrayList;
import java.util.List;

/**
 * 用户控制器.
 * 
 * @author <a href="https://waylau.com">Way Lau</a>
 * @date 2017年2月26日
 */
@Controller
@RequestMapping("/admins")
public class AdminController {

	@Autowired
	private MenuService menuService;
	/**
	 * 获取后台管理主页面
	 * @return
	 */
	@GetMapping
	public ModelAndView listMenus(Model model) {
		List<SysMenu> list = menuService.getMenuListByType("1");
//		list.add(new SysMenu("用户管理", "/users"));
		if(null ==list||!(list.size()>0)){
			list = new ArrayList<SysMenu>();
		}
		model.addAttribute("list", list);
		return new ModelAndView("/admins/index", "model", model);
	}
 
	 
}
