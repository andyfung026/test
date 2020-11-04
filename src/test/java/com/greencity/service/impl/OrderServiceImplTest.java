package com.greencity.service.impl;

import com.greencity.dto.OrderDTO;
import com.greencity.entity.OrderDetail;
import com.greencity.enums.OrderStatusEnum;
import com.greencity.enums.PayStatusEnum;
import lombok.extern.slf4j.Slf4j;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.ArrayList;
import java.util.List;

/**
 * @author AndyFung
 * @version 1.0
 * @date 2020/7/8/008 15:59
 */

@RunWith(SpringRunner.class)
@SpringBootTest
@Slf4j
public class OrderServiceImplTest {

    @Autowired
    private OrderServiceImpl orderServiceImpl;

    private final String BUYER_OPENID="000001";

    private final String ORDER_ID = "1594274789490796887";

    @Test
    public void createOrder() throws Exception{
        OrderDTO orderDTO = new OrderDTO();
        orderDTO.setBuyerName("辛德拉");
        orderDTO.setBuyerAddress("艾欧尼亚");
        orderDTO.setBuyerIphone("15617745511");
        orderDTO.setBuyerOpenid(BUYER_OPENID);
        //购物车
        List<OrderDetail> orderDetailList = new ArrayList<>();
        OrderDetail orderDetail = new OrderDetail();
        orderDetail.setProductId("111111");
        orderDetail.setProductQuantity(5);

        orderDetailList.add(orderDetail);
        orderDTO.setOrderDetailList(orderDetailList);
        OrderDTO result = orderServiceImpl.createOrder(orderDTO);
        log.info("[创建订单] result={}",result );
        Assert.assertNotNull(result);
    }

    @Test
    public void findOne() {
        OrderDTO one = orderServiceImpl.findOne(ORDER_ID);
        log.info("[查询单个订单] one ：{}", one);
        Assert.assertEquals(ORDER_ID,one.getOrderId());

    }
    @Test
    public void findByPage() {
        PageRequest pageRequest = new PageRequest(0, 2);
        Page<OrderDTO> byPage = orderServiceImpl.findByPage(BUYER_OPENID, pageRequest);
        Assert.assertNotEquals(0,byPage.getTotalElements());

    }

    @Test
    public void cancel() {
        OrderDTO one = orderServiceImpl.findOne(ORDER_ID);
        OrderDTO cancel = orderServiceImpl.cancel(one);
        Assert.assertEquals(OrderStatusEnum.CANCEL.getCode(),cancel.getOrderStatus());

    }

    @Test
    public void finish() {
        OrderDTO one = orderServiceImpl.findOne(ORDER_ID);
        OrderDTO finish = orderServiceImpl.finish(one);
        Assert.assertEquals(OrderStatusEnum.FINISHED.getCode(),finish.getOrderStatus());
    }

    @Test
    public void payOrder() {
        OrderDTO one = orderServiceImpl.findOne(ORDER_ID);
        OrderDTO payOrder = orderServiceImpl.payOrder(one);
        Assert.assertEquals(PayStatusEnum.PAY_SUCCESS .getCode(),payOrder.getPayStatus());
    }
}