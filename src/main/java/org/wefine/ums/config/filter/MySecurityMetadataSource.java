package org.wefine.ums.config.filter;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.security.access.ConfigAttribute;
import org.springframework.security.web.FilterInvocation;
import org.springframework.security.web.access.intercept.FilterInvocationSecurityMetadataSource;
import org.wefine.ums.dao.SecurityMetadataDao;

import java.util.Collection;
import java.util.Map;


/**
 * 资源源数据定义，将所有的资源和权限对应关系建立起来，即定义某一资源可以被哪些角色访问。
 */
public class MySecurityMetadataSource implements
        FilterInvocationSecurityMetadataSource {

    @Autowired
    @Qualifier("securityMetadataDao")
    private SecurityMetadataDao securitMetadataSourceDao;

    @Override
    public Collection<ConfigAttribute> getAllConfigAttributes() {
        return null;
    }

    @Override
    public Collection<ConfigAttribute> getAttributes(Object o)
            throws IllegalArgumentException {
        System.out.println("MySecurityMetadataSource.loadResourcesDefine()--------------��ʼ������Դ�б�����--------");
        String url = ((FilterInvocation) o).getRequest().getServletPath();
        Map<String, Collection<ConfigAttribute>> map = securitMetadataSourceDao.getMetadata();

        return map.get(url.trim());
    }

    @Override
    public boolean supports(Class<?> arg0) {
        return true;
    }

}
