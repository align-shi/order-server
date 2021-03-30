package com.xiaoshi.mapper;

import com.xiaoshi.dto.EditUserDTO;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;

/**
 * @ClassName UserNewMapper
 * @Author xiaoshi
 * @Date 2021/3/29 22:55
 * @Description
 **/
@Repository
public interface UserNewMapper {

    List<Map<String, Object>> queryFeedback(String username);

    List<Map<String, Object>> queryAllUser(String username);

    int update(EditUserDTO editUserDTO);
}
