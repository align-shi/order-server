package com.xiaoshi.mapper;

import com.xiaoshi.domain.ProductImage;

import org.apache.ibatis.annotations.*;
import org.springframework.stereotype.Repository;

@Repository
public interface ProductImageMapper {

    @Insert("insert into of_product_image(name,image,product_id) values(#{name},#{image,jdbcType=BLOB},#{productId})")
    public int insertImage(ProductImage productImage);

    @Select("select * from of_product_image where id=#{id}")
    public ProductImage queryImageById(int id);

}