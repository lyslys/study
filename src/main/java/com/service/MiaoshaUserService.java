package com.service;

import com.mapper.MiaoshaUserMapper;
import com.model.vo.LoginVo;
import com.model.miaosha.MiaoshaUser;
import com.model.result.CodeMsg;
import com.utils.MD5Util;
import com.utils.UUIDUtil;
import com.utils.exception.GlobalException;
import com.utils.redis.RedisService;
import com.utils.redis.MiaoshaUserKey;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletResponse;

@Service
public class  MiaoshaUserService {

    public static final String COOK1_NAME_TOKEN = "token";

    @Autowired
    private MiaoshaUserMapper miaoshaUserMapper;

    @Autowired
    private RedisService redisService;

    public MiaoshaUser getById(long id) {

        //取缓存
        MiaoshaUser user = redisService.get(MiaoshaUserKey.getById, ""+id, MiaoshaUser.class);
        if(user != null){
            return user;
        }

        //取数据库
        user = miaoshaUserMapper.getById(id);
        if(user != null){
            redisService.set(MiaoshaUserKey.getById,"+id" ,user );
        }

        return user;
    }

    public boolean updatePassword(String token,long id,String formPass) {
        //取user
        MiaoshaUser user = getById(id);
        if(user == null){
            throw new GlobalException(CodeMsg.MOBILE_NOT_EXIST);
        }
        //更新数据库
        MiaoshaUser toBeUpdate = new MiaoshaUser();
        toBeUpdate.setId(id);
        toBeUpdate.setPassword(MD5Util.fromPassToDBpass(formPass, user.getSalt()));
        miaoshaUserMapper.update(toBeUpdate);
        //处理缓存
        redisService.delete(MiaoshaUserKey.getById, ""+id);
        user.setPassword(toBeUpdate.getPassword());
        redisService.set(MiaoshaUserKey.token, token,user);

        return true;
    }


    public MiaoshaUser getByToken(HttpServletResponse response,String token) {
        if (StringUtils.isEmpty(token)) {
            return null;
        }
        MiaoshaUser MiaoshaUser = redisService.get(MiaoshaUserKey.token, token, MiaoshaUser.class);
        //延长有效期
        if(MiaoshaUser != null){
            addCookie(response,token,MiaoshaUser);
        }
        return MiaoshaUser;
    }

    private void addCookie(HttpServletResponse response,String token,MiaoshaUser MiaoshaUser){
        redisService.set(MiaoshaUserKey.token, token, MiaoshaUser);
        Cookie cookie = new Cookie(COOK1_NAME_TOKEN, token);
        cookie.setMaxAge(MiaoshaUserKey.token.expireSeconds());
        cookie.setPath("/");
        response.addCookie(cookie);
    }

    // @Transactional
    public boolean tx() {

        MiaoshaUser u = new MiaoshaUser();
        u.setId(2L);
        u.setNickname("李嘉莹");

        miaoshaUserMapper.insert(u);

        MiaoshaUser u1 = new MiaoshaUser();
        u1.setId(1L);
        u1.setNickname("u1");

        miaoshaUserMapper.insert(u1);

        return true;
    }

    public String login(HttpServletResponse response, LoginVo LoginVo) {
        if (LoginVo == null) {
            throw new GlobalException(CodeMsg.SERVER_ERROR);
        }
        String mobile = LoginVo.getMobile();
        String fromPass = LoginVo.getPassword();
        //判断手机号是否存在
        MiaoshaUser MiaoshaUser = miaoshaUserMapper.getByMobile(mobile);
        if (MiaoshaUser == null) {
            throw new GlobalException(CodeMsg.MOBILE_NOT_EXIST);
        }
        //验证密码
        String dbPass = MiaoshaUser.getPassword();
        String slatDB = MiaoshaUser.getSalt();
        String calcPass = MD5Util.fromPassToDBpass(fromPass, slatDB);

        if (!calcPass.equals(dbPass)) {
            throw new GlobalException(CodeMsg.PASSWORD_ERROR);
        }
        //生成cookie
        String token = UUIDUtil.uuid();
        addCookie(response,token,MiaoshaUser);
        return token;

    }

}
