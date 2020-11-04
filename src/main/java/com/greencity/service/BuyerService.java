package com.greencity.service;

import com.greencity.dto.OrderDTO;

/**
 * @author AndyFung
 * @version 1.0
 * @date 2020/7/10/010 15:56
 */
public interface BuyerService {

    //查询一个订单
    OrderDTO findOrderOne(String openid ,String orderId);

    //取消订单
    OrderDTO cancelOrder(String openid, String orderId);
}
