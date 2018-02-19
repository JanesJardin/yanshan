package com.wangdakeji.wongder.modular.system.service;

/**
 * 菜单服务
 *
 * @author cj
 * @date 2017-05-05 22:19
 */
public interface IMenuService {

    /**
     * 删除菜单
     *
     */
    void delMenu(Integer menuId);

    /**
     * 删除菜单包含所有子菜单
     *
     */
    void delMenuContainSubMenus(Integer menuId);
}
