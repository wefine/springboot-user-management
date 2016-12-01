package org.wefine.ums.web.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import org.wefine.ums.dao.BaseDao;
import org.wefine.ums.dao.IPager;
import org.wefine.ums.dao.LoginLogDao;
import org.wefine.ums.model.UserLoginLog;
import org.wefine.ums.utils.ListResult;
import org.wefine.ums.web.service.LoginLogService;

@Service("loginLogService")
public class LoginLogServiceImpl extends BaseSerivceImpl<UserLoginLog, String> implements LoginLogService {
    private LoginLogDao loginLogDao;


    @Autowired(required = true)
    @Qualifier("loginLogDao")
    @Override
    public void setBaseDao(BaseDao<UserLoginLog, String> baseDao) {
        this.baseDao = baseDao;
        this.loginLogDao = (LoginLogDao) baseDao;
    }

    @Override
    public ListResult<UserLoginLog> list(IPager pager) {
        return loginLogDao.list(pager);
    }
}
