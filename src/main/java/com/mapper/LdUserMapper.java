package com.mapper;

import com.model.LdUser;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

@Mapper
public interface LdUserMapper {

    @Select("select * from ld_user where id = #{id}")
    LdUser getById(@Param("id")int id);

}