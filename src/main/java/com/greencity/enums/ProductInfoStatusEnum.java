package com.greencity.enums;

import lombok.Getter;

@Getter
public enum ProductInfoStatusEnum {

    UP(0, "在架"),
    DOWN(1, "下架");

    private Integer code;

    private String message;


    ProductInfoStatusEnum(Integer code, String message) {
        this.code = code;
        this.message = message;
    }
}
