package com.greencity.sell;


import com.greencity.dao.OrderMasterDao;
import com.greencity.entity.OrderMaster;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.test.context.junit4.SpringRunner;

import java.math.BigDecimal;
import java.time.LocalDateTime;


@RunWith(SpringRunner.class)
@SpringBootTest
public class OrderMasterDaoTest {

    @Autowired
    private OrderMasterDao orderMasterDao;

    private final String openId="000001";

    @Test
    public void saveTest() {
        OrderMaster orderMaster = new OrderMaster();
        orderMaster.setOrderId("123457");
        orderMaster.setBuyerName("布隆");
        orderMaster.setBuyerIphone("13838284728");
        orderMaster.setBuyerAddress("东仲花园24号楼，二单元602");
        orderMaster.setBuyerOpenid(openId);
        orderMaster.setOrderAmount(new BigDecimal(4.5));
        orderMaster.setCreateTime(LocalDateTime.now());
        orderMaster.setUpdateTime(LocalDateTime.now());
        OrderMaster result = orderMasterDao.save(orderMaster);
        Assert.assertNotNull(result);

    }

    @Test
    public void findByBuyerOpenId() throws Exception{
        PageRequest pageRequest = new PageRequest(0, 2);
        Page<OrderMaster> orderMastterPage = orderMasterDao.findByBuyerOpenid("000001", pageRequest);
        Assert.assertNotEquals(0,orderMastterPage.getTotalElements());
    }
}