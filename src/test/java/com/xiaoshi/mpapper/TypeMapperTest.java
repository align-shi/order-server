package com.xiaoshi.mpapper;

import com.xiaoshi.mapper.TypeMapper;
import com.xiaoshi.Application;
import com.xiaoshi.domain.Type;
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
public class TypeMapperTest {

    @Resource
    private TypeMapper typeMapper;
    @Test
    public void testQueryType(){
        List<Type> list=typeMapper.queryType();
        list.forEach(log::debug);
    }

    @Test
    public void testInsertType(){
        Type type=new Type(0,"测试类型","",100);
        int count=typeMapper.insertType(type);
        log.debug(count);
    }

    @Test
    public void testSelectTypeById(){
        Type type=typeMapper.selectTypeById(1);
        log.debug(type.getTypeName()+","+type.getId());
    }

    @Test
    public void testDeleteTypes(){
        Integer count=typeMapper.deleteTypes(new int[]{14});
        log.debug("......................."+count);
    }

    @Test
    public void testUpdateType(){
        Type type=new Type(19,"测试9","测试——9",100);
        log.debug(typeMapper.updateType(type));
    }
}
