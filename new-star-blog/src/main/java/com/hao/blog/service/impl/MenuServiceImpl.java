package com.hao.blog.service.impl;

import com.hao.blog.domain.User;
import com.hao.blog.repository.MenuRepository;
import com.hao.blog.service.MenuService;
import com.hao.blog.domain.SysMenu;
import com.hao.blog.util.DateUtils;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

/**
 * @author
 * @since
 */
@Service
public class MenuServiceImpl implements MenuService {
    @Autowired
    private MenuRepository menuRepository;
    @Override
    public List<SysMenu> getMenuList(User user){
        return null;
    }

    @Override
    public List<SysMenu> getMenuListByType(String type) {
        return menuRepository.findSysMenusByType(type);
    }

    @Override
    public Page<SysMenu> findByNameLike(String name, Pageable pageable) {
        name = "%" + name + "%";
        return menuRepository.findByNameLike(name,pageable);
    }
    @Transactional
    @Override
    public void saveMenu(SysMenu sysMenu) {
        if(sysMenu.getId()==null){
            sysMenu.setCrtTime(DateUtils.getSysDateTimeString());
        }else{
            sysMenu.setUpdateTime(DateUtils.getSysDateTimeString());
        }
        menuRepository.save(sysMenu);
    }
    @Transactional
    @Override
    public void deleteMenu(Long id) {
        menuRepository.delete(id);
    }

    @Override
    public SysMenu findSysMenusById(Long id) {
        return menuRepository.findSysMenusById(id);
    }
}
