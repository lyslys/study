package com.utils.redis;

public class MiaoshaUserKey extends BasePrefix {

    private static final int TOKEM_EXPIRE = 3600*24*2;

    private MiaoshaUserKey(String prefix) {
        super(prefix);
    }

    private MiaoshaUserKey(int expireSeconds, String prefix) {
        super(expireSeconds,prefix);
    }

    public static MiaoshaUserKey getById = new MiaoshaUserKey("id");

    public static MiaoshaUserKey getByName = new MiaoshaUserKey("name");

    public static MiaoshaUserKey token = new MiaoshaUserKey(TOKEM_EXPIRE,"tk");

}
