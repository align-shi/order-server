package com.xiaoshi.dao.mysql;

import com.xiaoshi.mapper.UserMapper;
import com.xiaoshi.Application;
import com.xiaoshi.domain.User;
import lombok.Data;
import lombok.extern.log4j.Log4j2;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;


import javax.annotation.Resource;
import java.util.List;

@RunWith(SpringRunner. class )
@SpringBootTest(classes = {Application.class},webEnvironment = SpringBootTest.WebEnvironment.NONE)
@Data
@Log4j2
public class UserMapperTest {

	@Resource
	private UserMapper userMapper;

	@Test
	public void testShowAllUser(){
		List<User> list=userMapper.queryUser();
		list.forEach(log::debug);
	}

	@Test
    public void testQueryUserByNameAndPassword(){
	    User user=userMapper.queryUserByNameAndPassword("admin","admin");
	    log.debug(user);
    }
}
