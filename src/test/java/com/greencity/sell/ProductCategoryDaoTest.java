package com.greencity.sell;

import com.greencity.SellApplication;
import com.greencity.dao.ProductCategoryDao;
import com.greencity.entity.ProductCategory;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.time.LocalDateTime;
import java.util.Optional;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = SellApplication.class)
public class ProductCategoryDaoTest {
    @Autowired
    private ProductCategoryDao productCategoryDao;

    @Test
    public void testProductCategory() {
        Optional<ProductCategory> byId = productCategoryDao.findById(1);
        System.out.println(byId.toString());
    }


    @Test
    public void updateProductCategory() {
        ProductCategory productCategory = new ProductCategory();
        productCategory.setCategoryId(3);
        productCategory.setCategoryName("阿s萨");
        productCategory.setCategoryType(2);
        productCategory.setCreateTime(LocalDateTime.now());
        productCategory.setUpdateTime(LocalDateTime.now());
        productCategoryDao.save(productCategory);
    }
}