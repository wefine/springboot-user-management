package org.wefine.ums.web.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import org.wefine.ums.dao.BaseDao;
import org.wefine.ums.dao.RoleMenuDao;
import org.wefine.ums.model.SysRoleMenus;
import org.wefine.ums.utils.ListResult;
import org.wefine.ums.utils.StringUtil;
import org.wefine.ums.web.service.RoleMenuService;

@Service("roleMenuService")
public class RoleMenuServiceImpl extends BaseSerivceImpl<SysRoleMenus, String> implements RoleMenuService {
    private RoleMenuDao menuDao;

    @Override
    public Boolean createRoleMenu(String roleId) {
        return menuDao.createRoleMenu(roleId);
    }

    @Override
    public ListResult loadRoleMenu(String roleId, String parentId) {
        if (StringUtil.isNotEmpty(parentId)) {
            return menuDao.loadRoleMenu(roleId, parentId);
        } else {
            return menuDao.loadRoleRootMenu(roleId);
        }
    }

    @Override
    public ListResult loadRoleMenu(String id) {
        if (StringUtil.isNotEmpty(id)) {
            return menuDao.loadRoleMenu(id);
        } else {
            return menuDao.loadRoleRootMenu();
        }
    }

    @Override
    public Boolean moveUp(String roleid, String menuid) {
        return menuDao.moveUp(roleid, menuid);
    }

    @Override
    public Boolean moveDown(String roleid, String menuid) {
        return menuDao.moveDown(roleid, menuid);
    }

    @Override
    @Autowired(required = true)
    @Qualifier("roleMenuDao")
    public void setBaseDao(BaseDao<SysRoleMenus, String> baseDao) {
        this.baseDao = baseDao;
        this.menuDao = (RoleMenuDao) baseDao;
    }


}
