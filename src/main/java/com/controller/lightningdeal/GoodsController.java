package com.controller.lightningdeal;

import com.model.dto.GoodsVo;
import com.model.miaosha.LdUser;
import com.model.miaosha.MiaoshaUser;
import com.service.GoodsService;
import com.service.LdUserService;
import com.utils.redis.RedisService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
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

    /**
     * QPS  79.7
     * 500 * 10
     */
    @RequestMapping("/to_list")
    public String list(Model model,LdUser ldUser ) {
    	model.addAttribute("user", ldUser);
        //查询商品列表
        List<GoodsVo> goodsList = goodsService.listGoodsVo();
        model.addAttribute("goodsList", goodsList);
        return "lightningdeal/goods_list";
    }

    @RequestMapping("/to_detail/{goodsId}")
    public String detail(Model model,LdUser user,
                         @PathVariable("goodsId")long goodsId) {
        model.addAttribute("user", user);

        GoodsVo goods = goodsService.getGoodsVoByGoodsId(goodsId);
        model.addAttribute("goods", goods);

        long startAt = goods.getStartDate().getTime();
        long endAt = goods.getEndDate().getTime();
        long now = System.currentTimeMillis();

        int miaoshaStatus = 0;
        int remainSeconds = 0;
        if(now < startAt ) {//秒杀还没开始，倒计时
            miaoshaStatus = 0;
            remainSeconds = (int)((startAt - now )/1000);
        }else  if(now > endAt){//秒杀已经结束
            miaoshaStatus = 2;
            remainSeconds = -1;
        }else {//秒杀进行中
            miaoshaStatus = 1;
            remainSeconds = 0;
        }
        model.addAttribute("miaoshaStatus", miaoshaStatus);
        model.addAttribute("remainSeconds", remainSeconds);
        return "lightningdeal/goods_detail";
    }

}
