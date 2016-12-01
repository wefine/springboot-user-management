package org.wefine.ums.web.service;

import org.wefine.ums.dao.IPager;
import org.wefine.ums.dao.impl.Pager;
import org.wefine.ums.model.SysRoles;
import org.wefine.ums.utils.ListResult;

public interface RoleService extends BaseService<SysRoles, String> {

    ListResult<SysRoles> getSysRoleList(IPager pager);

    Boolean addRole(SysRoles roles);

    Boolean delRole(String roleId);

    ListResult<SysRoles> getRoleAuthorities(Pager pager);

    Boolean addRoleAuthority(String authIds, String roldId);

    Boolean delRoleAuthority(String authIds, String roleId);

    ListResult<SysRoles> getSimpleRoleList();
}
