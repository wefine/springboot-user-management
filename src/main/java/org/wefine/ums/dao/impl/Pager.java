package org.wefine.ums.dao.impl;

import org.wefine.ums.dao.IPager;

import java.util.HashMap;
import java.util.Map;


public class Pager implements IPager {

    private Integer page;
    private String sort;
    private String order;
    private Integer rows;
    private Map params = new HashMap();

    @Override
    public Integer getLimit() {
        return rows;
    }

    @Override
    public Integer getPage() {
        return page;
    }

    public void setPage(Integer page) {
        this.page = page;
    }

    @Override
    public String getSort() {
        return sort;
    }

    public void setSort(String sort) {
        this.sort = sort;
    }

    @Override
    public String getOrder() {
        return order;
    }

    public void setOrder(String order) {
        this.order = order;
    }

    @Override
    public Map getParams() {
        return params;
    }

    public void setParams(Map params) {
        this.params = params;
    }

    @Override
    public Integer getStart() {
        if (getLimit() != null && getPage() != null) {
            return (getPage() - 1) * getLimit();
        }
        return 0;
    }

    public Integer getRows() {
        return rows;
    }

    public void setRows(Integer rows) {
        this.rows = rows;
    }

}
