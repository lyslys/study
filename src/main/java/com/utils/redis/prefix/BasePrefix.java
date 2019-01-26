package com.utils.redis.prefix;

/**
 * key 加上前缀 例如： 用户前缀 或者 订单前缀
 */
public abstract class BasePrefix implements KsyPrefix {

    private int expireSeconds;

    private String prefix;

    public BasePrefix(String prefix) {//默认0代表永不过期
        this(0,prefix);
    }

    public BasePrefix(int expireSeconds, String prefix) {
        this.expireSeconds = expireSeconds;
        this.prefix = prefix;
    }

    @Override
    public int expireSeconds() {//默认0代表永不过期
        return 0;
    }

    @Override
    public String getPrefix() {
        String className = getClass().getSimpleName();
        return className + ":" + prefix;
    }

}
