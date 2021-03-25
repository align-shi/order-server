package com.xiaoshi.service.iface;

import com.github.pagehelper.PageInfo;
import com.xiaoshi.config.UnifyResponse;
import com.xiaoshi.domain.Type;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;

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

    /**
     * 修改分类的名字
     * @param type 参数
     * @return 成功标识
     */
    UnifyResponse<Object> updateTypeName(Type type);

    /**
     * 新增一条分类
     * @param type 数据
     * @return 成功标识
     */
    UnifyResponse<Object> addNewType(Type type);

    /**
     * 删除某些类型数据
     * @param ids id
     * @return 成功标志
     */
    UnifyResponse<Object> delete(List<Integer> ids);

    public boolean addType(Type type);
    public boolean deleteTypes(String ids);
    public boolean updateType(Type type);
}
