package org.wefine.ums.dao;


import org.wefine.ums.model.SysAuthorities;
import org.wefine.ums.utils.ListResult;

public interface AuthorityDao extends BaseDao<SysAuthorities, String> {

    ListResult<SysAuthorities> getAuthorityList(IPager pager);

    Boolean addAuthority(SysAuthorities authorities);

    Boolean delAuthority(String authorityId);

    ListResult<SysAuthorities> getAuthorityRes(IPager pager);

    Boolean addAuthorityRes(String[] resIds, String authorityId);

    Boolean delAuthorityRes(String[] resIds, String authorityId);

    Integer countAuthRole(String authId);
}