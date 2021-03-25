package com.xiaoshi.mapper;

import com.xiaoshi.domain.Type;

import java.util.List;

import org.apache.ibatis.annotations.*;

/**
 * @author yuhf
 */
public interface TypeMapper {

    @Select("select id,type_name,remark,sort from of_type where deleted = 0 order by sort")
    public List<Type> queryType();

    @Insert("insert into of_type(type_name,remark,sort) values(#{typeName},#{remark},#{sort})")
    public int insertType(Type type);

    @DeleteProvider(type=TypesDynamicSqlProvider.class,method="deleteTypsByIds")
    public Integer deleteTypes(@Param("ids") int[] ids);

    @Select("select * from of_type where id=#{id}")
    public Type selectTypeById(int id);

    @Update("update of_type set type_name=#{typeName},remark=#{remark},sort=#{sort} where id=#{id}")
    public int updateType(Type type);
}