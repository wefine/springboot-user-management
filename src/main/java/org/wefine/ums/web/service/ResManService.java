package org.wefine.ums.web.service;


import org.wefine.ums.dao.IPager;
import org.wefine.ums.model.SysResources;
import org.wefine.ums.utils.ListResult;

public interface ResManService extends BaseService<SysResources, String> {
    ListResult<SysResources> getGroupList(IPager pager);

    Boolean addGroup(SysResources group);

    Boolean addRes(SysResources resources);

    Boolean delGroup(String groupid);

    Boolean delRes(String resid);
}
