package org.wefine.ums.web.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import org.wefine.ums.dao.AuthorityDao;
import org.wefine.ums.dao.BaseDao;
import org.wefine.ums.dao.IPager;
import org.wefine.ums.model.SysAuthorities;
import org.wefine.ums.utils.ListResult;
import org.wefine.ums.utils.StringUtil;
import org.wefine.ums.web.service.AuthorityService;

import java.util.Date;


@Service("authorityService")
public class AuthorityServiceImpl extends BaseSerivceImpl<SysAuthorities, String> implements AuthorityService {

    private AuthorityDao authorityDao;


    @Override
    public ListResult<SysAuthorities> getAuthorityList(IPager pager) {
        return authorityDao.getAuthorityList(pager);
    }

    @Override
    public Boolean addAuthority(SysAuthorities authorities) {
        if (!StringUtil.isNotEmpty(authorities.getId())) {
            authorities.setCreateDate(new Date());
        }
        return authorityDao.addAuthority(authorities);
    }

    @Override
    public Boolean delAuthority(String authorityId) {
        return authorityDao.delAuthority(authorityId);
    }

    @Override
    public ListResult<SysAuthorities> getAuthorityRes(IPager pager) {
        if (pager != null) {
            return authorityDao.getAuthorityRes(pager);
        }
        return null;
    }

    @Override
    public Boolean addAuthorityRes(String resIds, String authorityId) {
        String[] resids = resIds.split(",");
        if (resids.length == 0) {
            return false;
        }
        return authorityDao.addAuthorityRes(resids, authorityId);
    }

    @Override
    public Boolean delAuthorityRes(String resIds, String authorityId) {
        String[] resids = resIds.split(",");
        if (StringUtil.isNotEmpty(resids)) {
            return authorityDao.delAuthorityRes(resids, authorityId);
        }
        return false;
    }

    @Override
    public Integer countAuthRole(String authId) {
        return authorityDao.countAuthRole(authId);
    }

    @Autowired(required = true)
    @Qualifier("authorityDao")
    @Override
    public void setBaseDao(BaseDao<SysAuthorities, String> baseDao) {
        this.baseDao = baseDao;
        authorityDao = (AuthorityDao) baseDao;
    }
}
