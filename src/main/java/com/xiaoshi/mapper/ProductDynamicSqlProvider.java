package com.xiaoshi.mapper;

import org.apache.ibatis.jdbc.SQL;

import java.util.Arrays;

public class ProductDynamicSqlProvider {

    public String deleteProductByIds(int[] ids){
        SQL sql=new SQL()
                .DELETE_FROM("of_product")
                .WHERE("id in <foreach collection='ids' item='id' open='(' separator=',' close=')'>#{id}</foreach>");
        return "<script>"+sql.toString()+"</script>";
    }

    public String selectByIds(Integer[] ids){
        SQL sql=new SQL();
        sql.SELECT("*");
        sql.FROM("of_product");
        sql.WHERE("id in <foreach collection='ids' item='id' open='(' separator=',' close=')'>#{id}</foreach>");
        return "<script>"+sql.toString()+"</script>";
        /*
        String sql="select * from of_product where id in (";
        for(int i=0,len=ids.length;i<len;i++){
            if(i==0){
                sql+=ids[i];
            }else{
                sql+=",";
                sql+=ids[i];
            }
        }
        sql+=")";
        return sql;
         */
    }
}
