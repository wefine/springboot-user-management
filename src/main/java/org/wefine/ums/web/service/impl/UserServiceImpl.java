package org.wefine.ums.web.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import org.wefine.ums.dao.BaseDao;
import org.wefine.ums.dao.IPager;
import org.wefine.ums.dao.UserDao;
import org.wefine.ums.model.SysUsers;
import org.wefine.ums.utils.ListResult;
import org.wefine.ums.utils.StringUtil;
import org.wefine.ums.web.service.UserService;

import java.util.Date;
import java.util.List;

@Service("userService")
public class UserServiceImpl extends BaseSerivceImpl<SysUsers, String> implements UserService {
    private UserDao userManagerDao;

    @Override
    public ListResult getUserData(IPager pager) {
        return userManagerDao.getUserDataList(pager);
    }

    @Override
    public Boolean addUser(SysUsers users) {
        if (!StringUtil.isNotEmpty(users.getId())) {
            users.setCreateDate(new Date());
            users.setCreatorId(getUser().getId());
        }
        return userManagerDao.addUser(users);
    }

    @Override
    public Boolean delUserById(String userid) {
        return userManagerDao.delUserById(userid);
    }

    @Override
    public Boolean addUserRole(String roleIds, String userid) {
        String[] roleids = roleIds.split(",");
        if (StringUtil.isNotEmpty(roleids)) {
            return userManagerDao.addUserRole(roleids, userid);
        }
        return false;
    }

    @Override
    public Boolean delUserRole(String roleIds, String userid) {
        String[] roleids = roleIds.split(",");
        if (StringUtil.isNotEmpty(roleids)) {
            return userManagerDao.delUserRole(roleids, userid);
        }
        return false;
    }

    @Override
    public ListResult getUserRole(IPager pager) {
        return userManagerDao.getUserRole(pager);
    }

    @Override
    public Boolean saveUserPassword(String oldpassword, String newpassword) {
        return userManagerDao.changePassworld(oldpassword, newpassword);
    }

    @Override
    public Boolean updateEnableUser(String userid) {
        return userManagerDao.updateEnableUser(userid);
    }

    @Override
    public Boolean updateLockUser(String userid) {
        return userManagerDao.updateLockUser(userid);
    }

    @Override
    public List getUserByType(String type) {
        return userManagerDao.getUserByType(type);
    }

    @Override
    public boolean accountUniqueValidate(String userid, String account) {
        return userManagerDao.accountUniqueValidate(userid, account);
    }

    @Autowired
    @Qualifier("userDao")
    @Override
    public void setBaseDao(BaseDao<SysUsers, String> baseDao) {
        this.baseDao = baseDao;
        this.userManagerDao = (UserDao) baseDao;
    }
}
