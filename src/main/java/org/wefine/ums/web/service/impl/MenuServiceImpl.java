package org.wefine.ums.web.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import org.wefine.ums.dao.BaseDao;
import org.wefine.ums.dao.IPager;
import org.wefine.ums.dao.MenuDao;
import org.wefine.ums.model.SysMenus;
import org.wefine.ums.utils.ListResult;
import org.wefine.ums.utils.StringUtil;
import org.wefine.ums.web.service.MenuService;

@Service("menuService")
public class MenuServiceImpl extends BaseSerivceImpl<SysMenus, String> implements MenuService {

    private MenuDao menuDao;

    @Override
    public ListResult<SysMenus> list(IPager pager) {
        if (pager != null && pager.getParams() != null && StringUtil.isNotEmpty(pager.getParams().get("parentid"))) {
            return menuDao.listSon(pager);
        }
        return menuDao.list(pager);
    }

    @Override
    public Boolean add(SysMenus menus) {
        return menuDao.add(menus);
    }

    @Override
    public Boolean edit(SysMenus menus) {
        return menuDao.add(menus);
    }


    @Autowired(required = true)
    @Qualifier("menuDao")
    @Override
    public void setBaseDao(BaseDao<SysMenus, String> baseDao) {
        this.baseDao = baseDao;
        this.menuDao = (MenuDao) baseDao;
    }

    public MenuDao getMenuDao() {
        return menuDao;
    }

}
