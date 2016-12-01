package org.wefine.ums.web.service;

import org.springframework.security.core.userdetails.UserDetailsService;
import org.wefine.ums.model.UserLoginLog;


public interface UserInfoService extends UserDetailsService {

    String addLoginLog(UserLoginLog log);

    void addLogoutLog(String logid);
}
