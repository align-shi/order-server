package com.xiaoshi.mapper;

import com.xiaoshi.domain.User;

import java.util.List;
import org.apache.ibatis.annotations.Arg;
import org.apache.ibatis.annotations.ConstructorArgs;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;
import org.apache.ibatis.type.JdbcType;

public interface UserMapper {

    @Delete({
        "delete from of_user",
        "where id = #{id,jdbcType=INTEGER}"
    })
    int deleteByPrimaryKey(Integer id);

    @Insert({
        "insert into of_user (name, password)",
        "values (#{name,jdbcType=VARCHAR}, #{password,jdbcType=VARCHAR})"
    })
    int insert(User record);

    @Select({
        "select",
        "id, name, password",
        "from of_user",
        "where id = #{id,jdbcType=INTEGER}"
    })
    @ConstructorArgs({
        @Arg(column="id", javaType=Integer.class, jdbcType=JdbcType.INTEGER, id=true),
        @Arg(column="name", javaType=String.class, jdbcType=JdbcType.VARCHAR),
        @Arg(column="password", javaType=String.class, jdbcType=JdbcType.VARCHAR)
    })
    User selectByPrimaryKey(Integer id);

    @Select("select * from of_user where name=#{userName} and password=#{password}")
    User queryUserByNameAndPassword(String userName,String password);

    @Select("select * from of_user")
    List<User> queryUser();

    @Update({
        "update of_user",
        "set name = #{name,jdbcType=VARCHAR},",
          "password = #{password,jdbcType=VARCHAR}",
        "where id = #{id,jdbcType=INTEGER}"
    })
    int updateByPrimaryKey(User record);
}