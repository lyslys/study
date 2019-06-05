package com.learn.design.proxy.jdk;

/**
 * 一个生产者
 */
public class Producer implements IProducer{
    /**
     * 销售
     * @param monney
     */
    public void saleProduct(float monney){
        System.out.println("销售产品，并拿到钱："+monney);
    }

    /**
     * 售后
     * @param monney
     */
    public void afterService(float monney){
        System.out.println("提供售后服务，并拿到钱："+monney);
    }

}
