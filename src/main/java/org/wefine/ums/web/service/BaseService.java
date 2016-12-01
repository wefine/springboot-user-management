package org.wefine.ums.web.service;

import org.wefine.ums.model.SysUsers;

import java.io.Serializable;
import java.util.List;


public interface BaseService<M extends Serializable, K extends Serializable> {
    K save(M model);

    void saveOrUpdate(M model);

    void update(M model);

    void delete(K id);

    void deleteObject(M model);

    M get(K id);

    List<String> getMsg();

    void setMsg(String msg);

    SysUsers getUser();
}
