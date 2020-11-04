package com.greencity.sell;

import com.greencity.entity.ProductInfo;
import com.greencity.enums.ProductInfoStatusEnum;
import com.greencity.service.impl.ProductInfoServiceImpl;
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
import java.util.List;
import java.util.Optional;

import static org.junit.Assert.*;

@RunWith(SpringRunner.class)
@SpringBootTest
public class ProductInfoServiceImplTest {

    @Autowired
    private ProductInfoServiceImpl productInfoService;

    @Test
    public void findOne() {
        Optional<ProductInfo> one = productInfoService.findOne("123456");
        System.out.println(one);
    }

    @Test
    public void findAll() {
        List<ProductInfo> productInfoList = productInfoService.findAll();
        for (int i = 0; i < productInfoList.size(); i++) {
            System.out.println(productInfoList.get(i));
        }
    }

    @Test
    public void findAll1() {
        PageRequest pageRequest = new PageRequest(0, 2);
        Page<ProductInfo> all = productInfoService.findAll(pageRequest);
        System.out.println(all.getTotalElements());
    }

    @Test
    public void save() {
        ProductInfo productInfo = new ProductInfo();
        productInfo.setProductId("123457");
        productInfo.setProductName("大米粥");
        productInfo.setProductPrice(new BigDecimal(1.5));
        productInfo.setProductStock(100);
        productInfo.setProductDescription("很好喝");
        productInfo.setProductIcon("http://*****.jpg");
        productInfo.setProductStatus(ProductInfoStatusEnum.DOWN.getCode());
        productInfo.setCategoryType(2);
        productInfo.setCreateTime(LocalDateTime.now());
        productInfo.setUpdateTime(LocalDateTime.now());
        ProductInfo save = productInfoService.save(productInfo);
        Assert.assertNotNull(save);
    }
}