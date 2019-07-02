package com.service;

import com.mapper.OrderMapper;
import com.model.vo.GoodsVo;
import com.model.miaosha.MiaoshaOrder;
import com.model.miaosha.MiaoshaUser;
import com.model.miaosha.OrderInfo;
import com.utils.redis.RedisService;
import com.utils.redis.OrderKey;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;

@Service
public class OrderService {
	
	@Autowired
	OrderMapper orderDao;

	@Autowired
	RedisService redisService;
	
	public MiaoshaOrder getMiaoshaOrderByUserIdGoodsId(long userId, long goodsId) {
		return redisService.get(OrderKey.getMiaoshaOrderByUidGid, userId+"_"+goodsId, MiaoshaOrder.class);
//		return orderDao.getMiaoshaOrderByUserIdGoodsId(userId, goodsId);
	}

	public OrderInfo getOrderById(long orderId) {
		return orderDao.getOrderById(orderId);
	}

	@Transactional
	public OrderInfo createOrder(MiaoshaUser user, GoodsVo goods) {
		OrderInfo orderInfo = new OrderInfo();
		orderInfo.setCreateDate(new Date());
		orderInfo.setDeliveryAddrId(0L);
		orderInfo.setGoodsCount(1);
		orderInfo.setGoodsId(goods.getId());
		orderInfo.setGoodsName(goods.getGoodsName());
		orderInfo.setGoodsPrice(goods.getMiaoshaPrice());
		orderInfo.setOrderChannel(1);
		orderInfo.setStatus(0);
		orderInfo.setUserId(user.getId());
		orderDao.insert(orderInfo);
		MiaoshaOrder miaoshaOrder = new MiaoshaOrder();
		miaoshaOrder.setGoodsId(goods.getId());
		miaoshaOrder.setOrderId(orderInfo.getId());
		miaoshaOrder.setUserId(user.getId());
		orderDao.insertMiaoshaOrder(miaoshaOrder);

		redisService.set(OrderKey.getMiaoshaOrderByUidGid, user.getId()+"_"+goods.getId(),miaoshaOrder);

		System.out.println(user.getId()+"下单成功了！");

		return orderInfo;
	}

	@Transactional(	propagation = Propagation.REQUIRED)
	public int updateGoods() {
		return orderDao.updateGoods();
	}

}
