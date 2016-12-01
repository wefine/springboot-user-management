package org.wefine.ums.dao;

import org.wefine.ums.model.SysUsers;
import org.wefine.ums.model.UserLoginLog;

public interface UserInfoDao {

    SysUsers getUserByName(String username);

    String addLoginLog(UserLoginLog log);

    void addLogoutLog(String logid);
}
