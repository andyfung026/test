package com.greencity.controller;

import com.greencity.entity.ProductCategory;
import com.greencity.entity.ProductInfo;
import com.greencity.service.ProductCategoryService;
import com.greencity.service.ProductInfoService;
import com.greencity.util.ResultVOUtil;
import com.greencity.vo.ProductInfoVO;
import com.greencity.vo.ProductVO;
import com.greencity.vo.ResultVO;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

/**
 * 买家商品
 */

@RestController
@RequestMapping("/buyer/product")
public class BuyerProductController {

    @Autowired
    private ProductInfoService productInfoService;

    @Autowired
    private ProductCategoryService productCategoryService;

    @GetMapping("/list")
    public ResultVO list() {
        //查询所有的上架商品
        List<ProductInfo> productInfoList = productInfoService.findAll();
        List<Integer> categoryList = productInfoList.stream()
                .map(m -> m.getCategoryType())
                .collect(Collectors.toList());

        List<ProductCategory> byCategoryTypeList = productCategoryService.findByCategoryTypeIn(categoryList);

        //数据拼接
        List<ProductVO> productVOList = new ArrayList<>();
        for (ProductCategory productCategory : byCategoryTypeList) {
            ProductVO productVO = new ProductVO();
            productVO.setCategorytype(productCategory.getCategoryType());
            productVO.setCategoryName(productCategory.getCategoryName());

            List<ProductInfoVO> productInfoVOList = new ArrayList<>();
            for (ProductInfo productInfo : productInfoList) {
                if (productInfo.getCategoryType().equals(productCategory.getCategoryType())) {
                    ProductInfoVO productInfoVO = new ProductInfoVO();
                    //把对象复制过来
                    BeanUtils.copyProperties(productInfo, productInfoVO);
                    productInfoVOList.add(productInfoVO);
                }
            }
            productVO.setProductInfoVOList(productInfoVOList);
            productVOList.add(productVO);
        }
        return ResultVOUtil.success(productVOList);
    }
}
