package com.learn.design.proxy.jdk;

public interface IProducer {

    /**
     * 销售
     * @param monney
     */
    void saleProduct(float monney);

    /**
     * 售后
     * @param monney
     */
    void afterService(float monney);
}
