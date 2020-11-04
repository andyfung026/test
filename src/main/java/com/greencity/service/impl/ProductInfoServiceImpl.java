package com.greencity.service.impl;

import com.greencity.dao.ProductInfoDao;
import com.greencity.dto.CartDTO;
import com.greencity.entity.ProductInfo;
import com.greencity.enums.ProductInfoStatusEnum;
import com.greencity.enums.ResultEnum;
import com.greencity.exception.SellException;
import com.greencity.service.ProductInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.criteria.CriteriaBuilder;
import java.util.List;
import java.util.Optional;

@Service
public class ProductInfoServiceImpl implements ProductInfoService {

    @Autowired
    private ProductInfoDao productInfoDao;
    @Override
    public Optional<ProductInfo> findOne(String productId) {
        return productInfoDao.findById(productId);
    }

    @Override
    public List<ProductInfo> findAll() {
        return productInfoDao.findByProductStatus(ProductInfoStatusEnum.UP.getCode());
    }

    @Override
    public Page<ProductInfo> findAll(Pageable pageable) {
        return productInfoDao.findAll(pageable);
    }

    @Override
    public ProductInfo save(ProductInfo productInfo) {
        return productInfoDao.save(productInfo);
    }

    @Override
    public void increaseStock(List<CartDTO> cartDTOList) {
        for (CartDTO cartDTO : cartDTOList) {
            Optional<ProductInfo> productInfo = productInfoDao.findById(cartDTO.getProductId());
            if (productInfo == null) {
                throw new SellException(ResultEnum.PRODUCT_NOT_EXIST);
            }
            Integer result = productInfo.get().getProductStock() + cartDTO.getProductQuantity();
            productInfo.get().setProductStock(result);
            productInfoDao.save(productInfo.get());
        }
    }

    @Override
    @Transactional
    public void decrease(List<CartDTO> cartDTOList) {
        for (CartDTO cartDTO : cartDTOList) {
            String productId = cartDTO.getProductId();

            Optional<ProductInfo> productInfo = productInfoDao.findById(productId);
            if (productInfo == null) {
                throw new SellException(ResultEnum.PRODUCT_NOT_EXIST);
            }
            Integer result = productInfo.get().getProductStock() - cartDTO.getProductQuantity();
            if (result < 0) {
                throw new SellException(ResultEnum.PRODUCT_STOCK_ERROR);
            }
            productInfo.get().setProductStock(result);
            productInfoDao.save(productInfo.get());
        }
    }
}
