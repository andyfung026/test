package com.greencity.sell;

import com.greencity.entity.ProductCategory;

import com.greencity.service.impl.ProductCategoryServiceImpl;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.time.LocalDateTime;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;


@RunWith(SpringRunner.class)
@SpringBootTest
public class ProductCategoryServiceImplTest {

    @Autowired
    private ProductCategoryServiceImpl productCategoryService;

    @Test
    public void findOne() {
        Optional<ProductCategory> one = productCategoryService.findOne(1);
        System.out.println(one);
    }

    @Test
    public void findAll() throws Exception{
        List<ProductCategory> all = productCategoryService.findAll();
        Assert.assertNotEquals(0,all.size());
    }

    @Test
    public void findByCategoryTypeIn() {
        List<ProductCategory> productCategoryList = productCategoryService.findByCategoryTypeIn(Arrays.asList(1,2,3,4));
        for (int i = 0; i < productCategoryList.size(); i++) {
            System.out.println(productCategoryList.get(i));
        }
    }

    @Test
    public void save()throws Exception {
        ProductCategory productCategory = new ProductCategory();
        //productCategory.setCategoryId();
        productCategory.setCategoryName("男喜欢");
        productCategory.setCategoryType(4);
        productCategory.setCreateTime(LocalDateTime.now());
        productCategory.setUpdateTime(LocalDateTime.now());
        ProductCategory save = productCategoryService.save(productCategory);
        Assert.assertNotNull(save);
    }
}