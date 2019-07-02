package com.utils.redis;

public interface KeyPrefix {

     //过期时间
     int expireSeconds();

     //缓存key的前缀
     String getPrefix();

}
