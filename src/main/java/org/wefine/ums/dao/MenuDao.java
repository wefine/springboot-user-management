package org.wefine.ums.dao;


import org.wefine.ums.model.SysMenus;
import org.wefine.ums.utils.ListResult;

public interface MenuDao extends BaseDao<SysMenus, String> {
    ListResult<SysMenus> list(IPager pager);

    ListResult<SysMenus> listSon(IPager pager);

    Boolean add(SysMenus menus);

    Boolean edit(SysMenus menus);
}
