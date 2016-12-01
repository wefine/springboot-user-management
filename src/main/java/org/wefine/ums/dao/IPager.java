package org.wefine.ums.dao;

import java.util.Map;

public interface IPager {
    abstract Integer getLimit();

    Integer getPage();

    String getSort();

    String getOrder();

    Map getParams();

    Integer getStart();
}
