package com.xiaoshi.springBoot2;

import lombok.extern.log4j.Log4j;
import lombok.extern.log4j.Log4j2;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.test.context.junit4.SpringRunner;

import javax.annotation.Resource;

import static junit.framework.TestCase.assertEquals;


@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@Log4j2
public class MyControllerTest {

	@Resource
	private TestRestTemplate testRestTemplate;

	@Test
	public void testHello() {
		String result=testRestTemplate.getForObject("/hello",String.class);	//get请求测试
		log.debug("yuhf:"+result);
	}
}
