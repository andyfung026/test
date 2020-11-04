package com.greencity.service;

import com.greencity.dto.OrderDTO;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

/**
 * @author AndyFung
 * @version 1.0
 * @date 2020/7/8/008 11:34
 */
public interface OrderService {

    //创建订单
    OrderDTO createOrder(OrderDTO orderDto);

    //查询一个订单
    OrderDTO findOne(String orderId);

    //查询订单列表
    Page<OrderDTO> findByPage(String buyOpenId, Pageable pageable);

    //取消订单
    OrderDTO cancel(OrderDTO orderDTO);

    //完结订单
    OrderDTO finish(OrderDTO orderDTO);

    //支付订单
    OrderDTO payOrder(OrderDTO orderDTO);
}
