package com.utils.redis.prefix;

public class LdUserKey extends BasePrefix {

    private LdUserKey(String prefix) {
        super(prefix);
    }

    public static LdUserKey getById = new LdUserKey("id");

    public static LdUserKey getByName = new LdUserKey("name");

}
