package com.service;

import com.mapper.LdUserMapper;
import com.model.LdUser;
import com.model.dto.LoginDto;
import com.model.result.CodeMsg;
import com.utils.MD5Util;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.math.BigDecimal;

@Service
public class LdUserService {

    @Autowired
    private LdUserMapper ldUserMapper;

    public LdUser getById(int id) {
        return ldUserMapper.getById(id);
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

    public CodeMsg login(LoginDto loginDto) {
        if (loginDto == null) {
            return CodeMsg.SERVER_ERROR;
        }
        String mobile = loginDto.getMobile();
        String fromPass = loginDto.getPassword();
        //判断手机号是否存在
        LdUser ldUser = ldUserMapper.getByMobile(mobile);
        if (ldUser == null) {
            return CodeMsg.MOBILE_NOT_EXIST;
        }
        //验证密码
        String dbPass = ldUser.getPassword();
        String slatDB = ldUser.getSalt();
        String calcPass = MD5Util.fromPassToDBpass(fromPass, slatDB);

        if (!calcPass.equals(dbPass)) {
            return CodeMsg.PASSWORD_ERROR;
        }

        return CodeMsg.SUCCESS;

    }

}
