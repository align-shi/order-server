package com.xiaoshi.mapper;

import com.xiaoshi.domain.Product;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.*;
import org.apache.ibatis.type.JdbcType;
import org.springframework.stereotype.Repository;

/**
 * @author yuhf
 */
@Repository
public interface ProductMapper {

    @Insert("insert into of_product" +
            "(name,price,real_price,product_type," +
            "trait,sales_volume,stauts,detail) " +
            "values(#{name},#{price},#{realPrice},#{productType}," +
            "#{trait},#{salesVolume},#{stauts},#{detail})")
    @Options(useGeneratedKeys = true,keyProperty = "id")
    public int insertProduct(Product product);
    /*
    @Select("<script>" +
            "select * from of_product where id in"+
            "<foreach collection='array' item='id' open='(' separator=',' close=')'>#{id}</foreach>"+
            "</script>")
     */
    @SelectProvider(type=ProductDynamicSqlProvider.class,method="selectByIds")
    public List<Product> getProductsByIds(@Param("ids") Integer[] ids);

    @DeleteProvider(type=ProductDynamicSqlProvider.class,method="deleteProductByIds")
    public int deleteProducts(@Param("ids") int[] ids);

    @Select("select * from of_product")
    public List<Product> queryProducts();

    @Select ("select * from of_product op left outer join of_type ot on op.product_type=ot.id")
    @ResultMap(value="productMap")
    public List<Map<String,Object>> queryProductsMap();

    @Select("select * from of_product where product_type=#{typeId}")
    @ResultMap(value="productMap")
    public List<Map<String,Object>> queryProductsByTypeId(int typeId);

    @Select("select * from of_product op left outer join of_type ot on op.product_type=ot.id where op.id=#{id}")
    @Results(id="productMap",value={
            @Result(property = "realPrice",column = "real_price"),
            @Result(property = "imageUrl",column = "image_url"),
            @Result(property = "productType",column = "product_type"),
            @Result(property = "salesVolume",column = "sales_volume"),
            @Result(property = "typeName",column = "type_name"),
            @Result(property = "image",column = "image",jdbcType = JdbcType.BLOB)
    })
    public Map<String,Object> queryProductsById(int id);

    @Update("update of_product set image=#{image,jdbcType=BLOB} where id=#{id}")
    public Integer updateImage(Product product);

    @Update("update of_product set name=#{name},price=#{price},real_price=#{realPrice}," +
            "product_type=#{productType},trait=#{trait},sales_volume=#{salesVolume}," +
            "detail=#{detail},stauts= #{stauts}" +
            " where id=#{id}")
    public int updateProduct(Product product);
}