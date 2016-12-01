package org.wefine.ums.dao;

import java.io.Serializable;
import java.util.List;

public interface BaseDao<M extends Serializable, K extends Serializable> {
    K save(M model);

    void saveOrUpdate(M model);

    void update(M model);

    void deleteObject(M model);

    void delete(K id);

    M get(K id);

    List<String> getMsg();

    void setMsg(String msg);
}
