package org.wefine.ums.web.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import org.wefine.ums.dao.BaseDao;
import org.wefine.ums.dao.IPager;
import org.wefine.ums.dao.RoleDao;
import org.wefine.ums.dao.impl.Pager;
import org.wefine.ums.model.SysRoles;
import org.wefine.ums.utils.ListResult;
import org.wefine.ums.utils.StringUtil;
import org.wefine.ums.web.service.RoleService;

import java.util.Date;

@Service("roleSerivce")
public class RoleServiceImpl extends BaseSerivceImpl<SysRoles, String> implements RoleService {

    private RoleDao roleDao;

    @Override
    public ListResult<SysRoles> getSysRoleList(IPager pager) {
        return roleDao.getSysRoleList(pager);
    }

    @Override
    public Boolean addRole(SysRoles roles) {
        if (!StringUtil.isNotEmpty(roles.getId())) {
            roles.setCreateDate(new Date());
        }
        return roleDao.addRole(roles);
    }

    @Override
    public Boolean delRole(String roleId) {
        return roleDao.delRole(roleId);
    }

    @Override
    public ListResult<SysRoles> getRoleAuthorities(Pager pager) {
        return roleDao.getRoleAuthorities(pager);
    }

    @Override
    public Boolean addRoleAuthority(String authIds, String roldId) {
        String[] authids = authIds.split(",");
        if (StringUtil.isNotEmpty(authids)) {
            return roleDao.addRoleAuthority(authids, roldId);
        }
        return false;
    }

    @Override
    public Boolean delRoleAuthority(String authIds, String roleId) {
        String[] authids = authIds.split(",");
        if (StringUtil.isNotEmpty(authids)) {
            return roleDao.delRoleAuthority(authids, roleId);
        }
        return false;
    }

    @Override
    public ListResult<SysRoles> getSimpleRoleList() {
        return roleDao.getSimpleRoleList();
    }

    public RoleDao getRoleDao() {
        return roleDao;
    }

    public void setRoleDao(RoleDao roleDao) {
        this.roleDao = roleDao;
    }

    @Autowired(required = true)
    @Qualifier("roleDao")
    @Override
    public void setBaseDao(BaseDao<SysRoles, String> baseDao) {
        this.baseDao = baseDao;
        this.roleDao = (RoleDao) baseDao;
    }
}
