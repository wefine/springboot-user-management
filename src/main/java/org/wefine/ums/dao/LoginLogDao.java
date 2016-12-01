package org.wefine.ums.dao;


import org.wefine.ums.model.UserLoginLog;
import org.wefine.ums.utils.ListResult;

public interface LoginLogDao extends BaseDao<UserLoginLog, String> {

    ListResult<UserLoginLog> list(IPager pager);
}
