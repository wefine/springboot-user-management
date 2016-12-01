package org.wefine.ums.web.service;

import org.wefine.ums.dao.IPager;
import org.wefine.ums.model.SysMenus;
import org.wefine.ums.utils.ListResult;

public interface MenuService extends BaseService<SysMenus, String> {
    ListResult<SysMenus> list(IPager pager);

    Boolean add(SysMenus menus);

    Boolean edit(SysMenus menus);
}
