package com.service;

import com.mapper.LdUserMapper;
import com.model.LdUser;
import com.model.dto.LoginDto;
import com.model.result.CodeMsg;
import com.utils.MD5Util;
import com.utils.UUIDUtil;
import com.utils.exception.GlobalException;
import com.utils.redis.RedisService;
import com.utils.redis.prefix.LdUserKey;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletResponse;

@Service
public class LdUserService {

    public static final String COOK1_NAME_TOKEN = "token";

    @Autowired
    private LdUserMapper ldUserMapper;

    @Autowired
    private RedisService redisService;

    public LdUser getById(int id) {
        return ldUserMapper.getById(id);
    }


    public LdUser getByToken(HttpServletResponse response,String token) {
        if (StringUtils.isEmpty(token)) {
            return null;
        }
        LdUser ldUser = redisService.get(LdUserKey.token, token, LdUser.class);
        //延长有效期
        if(ldUser != null){
            addCookie(response,ldUser);
        }
        return ldUser;
    }

    private void addCookie(HttpServletResponse response,LdUser ldUser){
        String token = UUIDUtil.uuid();
        redisService.set(LdUserKey.token, token, ldUser);
        Cookie cookie = new Cookie(COOK1_NAME_TOKEN, token);
        cookie.setMaxAge(LdUserKey.token.expireSeconds());
        cookie.setPath("/");
        response.addCookie(cookie);
    }

    // @Transactional
    public boolean tx() {

        LdUser u = new LdUser();
        u.setId(2L);
        u.setName("李嘉莹");

        ldUserMapper.insert(u);

        LdUser u1 = new LdUser();
        u1.setId(1L);
        u1.setName("u1");

        ldUserMapper.insert(u1);

        return true;
    }

    public boolean login(HttpServletResponse response, LoginDto loginDto) {
        if (loginDto == null) {
            throw new GlobalException(CodeMsg.SERVER_ERROR);
        }
        String mobile = loginDto.getMobile();
        String fromPass = loginDto.getPassword();
        //判断手机号是否存在
        LdUser ldUser = ldUserMapper.getByMobile(mobile);
        if (ldUser == null) {
            throw new GlobalException(CodeMsg.MOBILE_NOT_EXIST);
        }
        //验证密码
        String dbPass = ldUser.getPassword();
        String slatDB = ldUser.getSalt();
        String calcPass = MD5Util.fromPassToDBpass(fromPass, slatDB);

        if (!calcPass.equals(dbPass)) {
            throw new GlobalException(CodeMsg.PASSWORD_ERROR);
        }
        //生成cookie
        addCookie(response,ldUser);
        return true;

    }

}
