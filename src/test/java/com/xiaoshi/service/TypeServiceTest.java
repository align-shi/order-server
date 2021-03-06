package com.xiaoshi.service;

import com.xiaoshi.Application;
import com.xiaoshi.domain.Type;
import com.xiaoshi.service.iface.TypeService;
import lombok.Data;
import lombok.extern.log4j.Log4j2;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import javax.annotation.Resource;

@RunWith(SpringRunner.class )
@SpringBootTest(classes = {Application.class},webEnvironment = SpringBootTest.WebEnvironment.NONE)
@Data
@Log4j2
public class TypeServiceTest {

    @Resource
    TypeService typeService;

    @Test
    public void testDeleteTypes(){
        typeService.deleteTypes("18");
    }

    @Test
    public void testGetTypeById(){
        Type type=typeService.getTypeById(2);
        log.debug(type.getTypeName()+","+type.getId());
    }
}
