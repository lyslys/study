package com.mapper;

import com.model.Farm;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import java.math.BigDecimal;

public interface FarmMapper {

    @Select("SELECT * FROM farm WHERE name = #{name}")
    Farm findByName(@Param("name") String name);

    @Insert("INSERT INTO USERS(name,minute,price,store_name) VALUES(#{name}, #{minute},#{price}, #{store_name})")
    int insert(@Param("name") String name, @Param("minute") Long minute, @Param("price") BigDecimal price, @Param("store_name") String storeName);

}
