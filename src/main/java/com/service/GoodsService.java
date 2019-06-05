package com.service;

import com.mapper.GoodsMapper;
import com.model.dto.GoodsVo;
import com.model.miaosha.MiaoshaGoods;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class GoodsService {
	
	@Autowired
	GoodsMapper goodsDao;

	@Autowired
	OrderService orderService;

	public List<GoodsVo> listGoodsVo(){
		return goodsDao.listGoodsVo();
	}

	public GoodsVo getGoodsVoByGoodsId(long goodsId) {
		return goodsDao.getGoodsVoByGoodsId(goodsId);
	}

	@Transactional(propagation = Propagation.NEVER)
	public void reduceStock(GoodsVo goods) {
		MiaoshaGoods g = new MiaoshaGoods();
		g.setGoodsId(goods.getId());
		goodsDao.reduceStock(g);
	}
	
	@Transactional(
			readOnly = false, //读写事务
			timeout = -1, //默认为-1  永不超时 ，单位秒
//			noRollbackFor = ArithmeticException.class,  //指名遇到哪些异常不回滚
//			rollbackFor = ArithmeticException.class, //指名遇到哪些异常回滚
			isolation = Isolation.DEFAULT, //事务的隔离级别 默认数据库的隔离级别
			propagation = Propagation.REQUIRED //事务传播行为
	)
	public void updateStock() {
		MiaoshaGoods miaoshaGoods = new MiaoshaGoods();
		miaoshaGoods.setGoodsId(1L);
		orderService.updateGoods();
		System.out.println(goodsDao.reduceStock(miaoshaGoods));
		System.out.println(goodsDao.reduceStock(miaoshaGoods));
		int i=1/0;
		System.out.println(goodsDao.reduceStock(miaoshaGoods));


	}


	
}
