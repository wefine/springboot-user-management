package org.wefine.ums.web.service;


import org.wefine.ums.model.SysRoleMenus;
import org.wefine.ums.utils.ListResult;

public interface RoleMenuService extends BaseService<SysRoleMenus, String> {

    Boolean createRoleMenu(String roleId);

    ListResult<SysRoleMenus> loadRoleMenu(String roleId, String parentId);

    ListResult<SysRoleMenus> loadRoleMenu(String id);

    Boolean moveUp(String roleid, String menuid);

    Boolean moveDown(String roleid, String menuid);
}
