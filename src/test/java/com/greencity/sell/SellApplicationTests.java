package com.greencity.sell;

import com.greencity.SellApplication;
import com.greencity.dao.ProductCategoryDao;
import com.greencity.entity.ProductCategory;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.Optional;


@SpringBootTest(classes = {SellApplication.class})
@RunWith(SpringJUnit4ClassRunner.class)
class SellApplicationTests {

    @Autowired
    private ProductCategoryDao productCategoryDao;

    @Test
    public void contextLoads() {
        Optional<ProductCategory> byId = productCategoryDao.findById(1);
        System.out.println(byId.toString());
    }

}
