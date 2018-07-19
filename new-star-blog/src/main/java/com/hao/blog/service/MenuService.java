package com.hao.blog.service;

import com.hao.blog.domain.SysMenu;
import com.hao.blog.domain.User;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

/**
 * @author haozw
 * @since
 */
public interface MenuService {
    /**
     *
     * @return
     * @throws Exception
     */
    List<SysMenu> getMenuList(User user);

    /**
     *
     * @param type
     * @return
     */
    List<SysMenu> getMenuListByType(String type);

    /**
     *
     * @param name
     * @return
     */
    Page<SysMenu> findByNameLike(String name,Pageable pageable);

    /**
     * 保存菜单
     * @param sysMenu
     */
    void saveMenu(SysMenu sysMenu);

    /**
     * 删除菜单
     * @param id
     */
    void deleteMenu(Long id);

    /**
     * 根据id查询菜单
     * @param id
     * @return
     */
    SysMenu findSysMenusById(Long id);
}
