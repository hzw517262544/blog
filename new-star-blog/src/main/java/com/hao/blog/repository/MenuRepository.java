package com.hao.blog.repository;

import com.hao.blog.domain.SysMenu;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

/**
 * @author haozw
 *
 */
public interface MenuRepository extends JpaRepository<SysMenu,Long> {
    /**
     * 获取菜单
     * @return
     */
    public SysMenu findSysMenusById(Long id);

    /**
     *
     * @param type
     * @return
     */
    public List<SysMenu> findSysMenusByType(String type);

    /**
     *
     * @param name
     * @param pageable
     * @return
     */
    public Page<SysMenu> findByNameLike(String name,Pageable pageable);

}
