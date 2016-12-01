package org.wefine.ums.dao;


import org.wefine.ums.model.SysRoleMenus;
import org.wefine.ums.utils.ListResult;

public interface RoleMenuDao extends BaseDao<SysRoleMenus, String> {

    Boolean createRoleMenu(String roleId);

    ListResult<SysRoleMenus> loadRoleMenu(String roleId, String parentId);

    ListResult<SysRoleMenus> loadRoleRootMenu(String roleId);

    ListResult<SysRoleMenus> loadRoleRootMenu();

    ListResult<SysRoleMenus> loadRoleMenu(String parentId);

    Boolean moveUp(String roleid, String menuid);

    Boolean moveDown(String roleid, String menuid);
}
    
    
    
