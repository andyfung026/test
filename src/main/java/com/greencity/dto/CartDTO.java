package com.greencity.dto;

import lombok.Data;

import javax.persistence.Entity;

/**
 * @author AndyFung
 * @version 1.0
 * @date 2020/7/8/008 15:11
 */

@Data
public class CartDTO {

    private String productId;

    private Integer productQuantity;


    public CartDTO(String productId, Integer productQuantity) {
        this.productId = productId;
        this.productQuantity = productQuantity;
    }
}
