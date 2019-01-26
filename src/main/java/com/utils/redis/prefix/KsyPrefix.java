package com.utils.redis.prefix;

public interface KsyPrefix {

     //过期时间
     int expireSeconds();

     //缓存key的前缀
     String getPrefix();

}
