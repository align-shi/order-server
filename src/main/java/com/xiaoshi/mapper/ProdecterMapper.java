package com.xiaoshi.mapper;

import com.xiaoshi.domain.Product;
import org.springframework.stereotype.Repository;

@Repository
public interface ProdecterMapper {

    void update(Product product);
}
