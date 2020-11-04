package com.greencity.sell;

import com.greencity.dao.ProductInfoDao;
import com.greencity.entity.ProductInfo;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest
public class ProductInfoDaoTest {

    @Autowired
    private ProductInfoDao productInfoDao;


    @Test
    public void testSave()throws Exception {
        ProductInfo productInfo = new ProductInfo();
        productInfo.setProductId("111111");
        productInfo.setProductName("小米粥");
        productInfo.setProductPrice(new BigDecimal(3.5));
        productInfo.setProductStock(100);
        productInfo.setProductDescription("很好喝");
        productInfo.setProductIcon("http://*****.jpg");
        productInfo.setProductStatus(0);
        productInfo.setCategoryType(2);
        productInfo.setCreateTime(LocalDateTime.now());
        productInfo.setUpdateTime(LocalDateTime.now());
        ProductInfo save = productInfoDao.save(productInfo);
        Assert.assertNotNull(save);
    }
    @Test
    public void findByStatus()throws Exception {
        List<ProductInfo> byStatus = productInfoDao.findByProductStatus(1);
        for (int i = 0; i < byStatus.size(); i++) {
            System.out.println(byStatus.get(i));
        }
    }
}