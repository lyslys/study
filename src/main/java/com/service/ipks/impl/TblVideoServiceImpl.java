package com.service.ipks.impl;

import com.service.ipks.ITblVideoService;
import org.springframework.stereotype.Service;

@Service("tblVideoService")
public class TblVideoServiceImpl implements ITblVideoService {

    @Override
    public void aac() {

    }

    public static void main(String[] args) {
        TblVideoServiceImpl tblVideoService = new TblVideoServiceImpl();
        tblVideoService.aacc();
        System.out.println(ITblVideoService.tt);
    }

}
