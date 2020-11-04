package com.greencity.dao;

import com.greencity.entity.OrderDetail;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;

import static org.junit.Assert.*;

@RunWith(SpringRunner.class)
@SpringBootTest
public class OrderDetailDaoTest {


    @Autowired
    private OrderDetailDao orderDetailDao;


    @Test
    public void saveTest() {
        OrderDetail orderDetail = new OrderDetail();
        orderDetail.setDetailId("003");
        orderDetail.setOrderId("123321");
        orderDetail.setProductId("01");
        orderDetail.setProductName("鸡蛋卷饼");
        orderDetail.setProductPrice(new BigDecimal(5.0));
        orderDetail.setProductIcon("http://*****.jpg");
        orderDetail.setProductQuantity(2);
        orderDetail.setUpdateTime(LocalDateTime.now());
        OrderDetail save = orderDetailDao.save(orderDetail);
        Assert.assertNotNull(save);
    }


    @Test
    public void findByOrderId() {
        List<OrderDetail> byOrderId = orderDetailDao.findByOrderId("123321");
        Assert.assertNotEquals(0,byOrderId.size());
    }
}