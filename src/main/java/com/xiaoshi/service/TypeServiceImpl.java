package com.xiaoshi.service;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.xiaoshi.config.UnifyResponse;
import com.xiaoshi.domain.Type;
import com.xiaoshi.mapper.TypeMapper;
import com.xiaoshi.service.iface.TypeService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.Arrays;
import java.util.List;

@Service
public class TypeServiceImpl implements TypeService {

    @Resource
    TypeMapper typeMapper;
    @Override
    public List<Type> getTypesAll() {
        return typeMapper.queryType();
    }

    @Override
    public Type getTypeById(int id) {
        return typeMapper.selectTypeById(id);
    }

    @Override
    public PageInfo<Type> getTypesByPage(int PageNumber, int size) {
        PageHelper.startPage(PageNumber,size);
        List<Type> list=typeMapper.queryType();
        PageInfo<Type> page=new PageInfo<>(list);
        return page;
    }

    @Override
    public UnifyResponse<Object> getTypeList() {
        List<Type> list=typeMapper.queryType();
        return UnifyResponse.success(list);
    }

    @Override
    public boolean addType(Type type) {
        boolean flag=false;
        int number=typeMapper.insertType(type);
        if(number==1){
            flag=true;
        }
        return flag;
    }

    @Override
    public boolean deleteTypes(String ids) {
        boolean flag=false;
        String[] strArrays=ids.split(",");
        if(null!=strArrays&&strArrays.length!=0){
            int[] intArrays=Arrays.asList(strArrays).stream().mapToInt(Integer::parseInt).toArray();
            int count=typeMapper.deleteTypes(intArrays);
            if(count>0){
                flag=true;
            }
        }
        return flag;
    }

    @Override
    public boolean updateType(Type type) {
        boolean flag=false;
        if(typeMapper.updateType(type)==1){
            flag=true;
        }
        return flag;
    }
}
