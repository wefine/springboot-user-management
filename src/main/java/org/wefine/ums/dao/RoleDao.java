package org.wefine.ums.dao;

import org.wefine.ums.dao.impl.Pager;
import org.wefine.ums.model.SysRoles;
import org.wefine.ums.utils.ListResult;

public interface RoleDao extends BaseDao<SysRoles, String> {
    ListResult<SysRoles> getSysRoleList(IPager pager);

    Boolean addRole(SysRoles roles);

    Boolean delRole(String roleId);

    ListResult<SysRoles> getRoleAuthorities(Pager pager);

    Boolean addRoleAuthority(String[] authIds, String roleId);

    Boolean delRoleAuthority(String[] authIds, String roleId);

    ListResult<SysRoles> getSimpleRoleList();
}
