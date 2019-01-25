package com.service;

import com.mapper.LdUserMapper;
import com.model.LdUser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.math.BigDecimal;

@Service
public class LdUserService {

    @Autowired
    private LdUserMapper ldUserMapper;

    public LdUser getById(int id){
        return ldUserMapper.getById(id);
    }

   // @Transactional
    public boolean tx() {

        LdUser u = new LdUser();
        u.setId(2);
        u.setName("李嘉莹");

        ldUserMapper.insert(u);

        LdUser u1 = new LdUser();
        u1.setId(1);
        u1.setName("u1");

        ldUserMapper.insert(u1);

        return true;
    }

}
