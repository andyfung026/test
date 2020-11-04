package com.greencity.service;

import com.greencity.entity.ProductCategory;

import java.util.List;
import java.util.Optional;

public interface ProductCategoryService {

    Optional<ProductCategory> findOne(Integer gategoryId);


    List<ProductCategory> findAll();


    //买家端用
    List<ProductCategory> findByCategoryTypeIn(List<Integer> categoryTypeList);

    //新增和更新
    ProductCategory save(ProductCategory productCategory);
}
