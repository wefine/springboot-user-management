package org.wefine.ums.dao;

import org.springframework.security.access.ConfigAttribute;

import java.util.Collection;
import java.util.Map;

public interface SecurityMetadataDao {

    Map<String, Collection<ConfigAttribute>> getMetadata();
}
