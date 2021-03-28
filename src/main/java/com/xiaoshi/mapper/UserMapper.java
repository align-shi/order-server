package com.xiaoshi.mapper;

import com.xiaoshi.domain.FeedbackDTO;
import com.xiaoshi.domain.User;
import com.xiaoshi.domain.WeChatUser;
import com.xiaoshi.domain.WeChatUserEntity;
import org.apache.ibatis.annotations.*;
import org.apache.ibatis.type.JdbcType;

import java.util.List;

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

    @Insert("INSERT INTO ofs_user_wx( username, gender, vip) VALUES ( #{nickName}, #{gender}, #{vip});")
    int saveWechatUser(WeChatUser user);

    @Select("select * from ofs_user_wx where username = #{username}")
    WeChatUserEntity getUserInfo(String username);

    @Insert("INSERT INTO of_feedback( content, contract, create_time,create_user,device_model,device_system,app_version) " +
            "VALUES ( #{content}, #{contract}, now(),#{username},#{deviceModel},#{deviceSystem},#{appVersion})")
    int saveFeedback(FeedbackDTO feedbackDTO);
}