package com.xiaoshi.mapper;

import com.xiaoshi.domain.Product;
import com.xiaoshi.dto.ProductListDTO;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;

@Repository
public interface ProdecterMapper {

    void update(Product product);

    int addOne(Product product);

    List<Map<String, Object>> selectAll(ProductListDTO productListDTO);
}
