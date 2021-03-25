package com.xiaoshi.mapper;

import com.xiaoshi.domain.Type;
import org.springframework.stereotype.Repository;

@Repository
public interface TypeNewMapper {

    void updateOne(Type type);

    void saveOne(Type type);

    void delete(Integer id);
}
