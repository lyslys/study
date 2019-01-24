package com.service;

import com.mapper.LdUserMapper;
import com.model.LdUser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;

@Service
public class LdUserService {

    @Autowired
    private LdUserMapper ldUserMapper;

    public LdUser getById(int id){
        return ldUserMapper.getById(id);
    }

}
