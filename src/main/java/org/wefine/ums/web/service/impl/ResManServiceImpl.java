package org.wefine.ums.web.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import org.wefine.ums.dao.BaseDao;
import org.wefine.ums.dao.IPager;
import org.wefine.ums.dao.ResManDao;
import org.wefine.ums.model.SysResources;
import org.wefine.ums.utils.ListResult;
import org.wefine.ums.web.service.ResManService;

@Service("resouceService")
public class ResManServiceImpl extends BaseSerivceImpl<SysResources, String> implements ResManService {
    private ResManDao resManDao;

    @Override
    public ListResult getGroupList(IPager pager) {
        return resManDao.getGroupList(pager);
    }

    @Override
    public Boolean addGroup(SysResources group) {
        return resManDao.addGroup(group);
    }

    @Override
    public Boolean addRes(SysResources resources) {
        return resManDao.addRes(resources);
    }

    @Override
    public Boolean delGroup(String groupid) {
        return resManDao.delGroup(groupid);
    }

    @Override
    public Boolean delRes(String resid) {
        return resManDao.delRes(resid);
    }

    public ResManDao getResManDao() {
        return resManDao;
    }

    public void setResManDao(ResManDao resManDao) {
        this.resManDao = resManDao;
    }

    @Autowired(required = true)
    @Qualifier("resoucesDao")
    @Override
    public void setBaseDao(BaseDao<SysResources, String> baseDao) {
        this.baseDao = baseDao;
        this.resManDao = (ResManDao) baseDao;
    }
}
