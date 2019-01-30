package com.controller.lightningdeal;

import com.model.dto.GoodsVo;
import com.model.miaosha.LdUser;
import com.service.GoodsService;
import com.service.LdUserService;
import com.utils.redis.RedisService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping("/goods")
public class GoodsController {

	@Autowired
	LdUserService ldUserService;

    @Autowired
    RedisService redisService;

    @Autowired
    GoodsService goodsService;

    @RequestMapping("/to_list")
    public String list(Model model,LdUser ldUser ) {
    	model.addAttribute("user", ldUser);
        //查询商品列表
        List<GoodsVo> goodsList = goodsService.listGoodsVo();
        model.addAttribute("goodsList", goodsList);
        return "lightningdeal/goods_list";
    }
    
}
