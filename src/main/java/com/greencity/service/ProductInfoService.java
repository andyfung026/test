package com.greencity.service;

import com.greencity.dto.CartDTO;
import com.greencity.entity.ProductInfo;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

public interface ProductInfoService {
    Optional<ProductInfo> findOne(String productId);

    //查询所有在架商品
    List<ProductInfo> findAll();


    Page<ProductInfo> findAll(Pageable pageable);

    ProductInfo save(ProductInfo productInfo);

    //加库存
    void increaseStock(List<CartDTO> cartDTOList);

    //减库存
    void decrease(List<CartDTO> cartDTOList);
}
