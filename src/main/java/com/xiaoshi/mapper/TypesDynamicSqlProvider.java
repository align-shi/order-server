package com.xiaoshi.mapper;

import lombok.extern.log4j.Log4j2;
import org.apache.ibatis.jdbc.SQL;

@Log4j2
public class TypesDynamicSqlProvider {
    public String deleteTypsByIds(int[] ids){
        String sql="delete from of_type where id in (";
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
    }
}
