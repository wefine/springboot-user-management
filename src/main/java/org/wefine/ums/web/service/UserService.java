package org.wefine.ums.web.service;

import org.wefine.ums.dao.BaseDao;
import org.wefine.ums.dao.IPager;
import org.wefine.ums.model.SysUsers;
import org.wefine.ums.utils.ListResult;

import java.util.List;

public interface UserService extends BaseDao<SysUsers, String> {
    ListResult getUserData(IPager pager);

    Boolean addUser(SysUsers users);

    Boolean delUserById(String userid);

    Boolean addUserRole(String roleIds, String userid);

    Boolean delUserRole(String roleIds, String userid);

    ListResult getUserRole(IPager pager);

    Boolean saveUserPassword(String oldpassword, String newpassword);

    Boolean updateEnableUser(String userid);

    Boolean updateLockUser(String userid);

    List getUserByType(String type);

    boolean accountUniqueValidate(String userid, String account);
}