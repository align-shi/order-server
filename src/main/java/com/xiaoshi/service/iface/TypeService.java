package com.xiaoshi.service.iface;

import com.github.pagehelper.PageInfo;
import com.xiaoshi.config.UnifyResponse;
import com.xiaoshi.domain.Type;

import java.util.List;

public interface TypeService {
    public List<Type> getTypesAll();
    public Type getTypeById(int id);
    public PageInfo<Type> getTypesByPage(int PageNumber,int size);

    /**
     * 获取分类列表
     * @return 列表
     */
    UnifyResponse<Object> getTypeList();

    public boolean addType(Type type);
    public boolean deleteTypes(String ids);
    public boolean updateType(Type type);
}
