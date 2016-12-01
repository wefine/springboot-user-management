package org.wefine.ums.web.service;

import org.wefine.ums.dao.IPager;
import org.wefine.ums.model.UserLoginLog;
import org.wefine.ums.utils.ListResult;

public interface LoginLogService extends BaseService<UserLoginLog, String> {

    ListResult<UserLoginLog> list(IPager pager);
}
