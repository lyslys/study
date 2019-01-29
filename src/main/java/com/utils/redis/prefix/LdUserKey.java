package com.utils.redis.prefix;

public class LdUserKey extends BasePrefix {

    private static final int TOKEM_EXPIRE = 3600*24*2;

    private LdUserKey(String prefix) {
        super(prefix);
    }

    private LdUserKey(int expireSeconds,String prefix) {
        super(expireSeconds,prefix);
    }

    public static LdUserKey getById = new LdUserKey("id");

    public static LdUserKey getByName = new LdUserKey("name");

    public static LdUserKey token = new LdUserKey(TOKEM_EXPIRE,"tk");

}
