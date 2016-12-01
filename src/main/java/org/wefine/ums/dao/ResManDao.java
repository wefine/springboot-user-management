package org.wefine.ums.dao;


import org.wefine.ums.model.SysResources;
import org.wefine.ums.utils.ListResult;

public interface ResManDao extends BaseDao<SysResources, String> {
    ListResult<SysResources> getGroupList(IPager pager);

    Boolean addGroup(SysResources group);

    Boolean addRes(SysResources resources);

    Boolean delGroup(String groupid);

    Boolean delRes(String resid);
}
