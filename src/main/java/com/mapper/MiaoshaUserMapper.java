package com.mapper;

import com.model.miaosha.MiaoshaUser;
import org.apache.ibatis.annotations.*;

@Mapper
public interface MiaoshaUserMapper {

    @Select("select * from miaosha_user where id = #{id}")
    MiaoshaUser getById(@Param("id")long id);

    @Select("select * from miaosha_user where id = #{mobile}")
    MiaoshaUser getByMobile(@Param("mobile")String mobile);

    @Insert("insert into miaosha_user (id,name) values (#{id},#{name})")
    int insert(MiaoshaUser MiaoshaUser);

    @Update("update miaosha_user set password = #{password} where id = #{id}")
    void update(MiaoshaUser toBeUpdate);

}
