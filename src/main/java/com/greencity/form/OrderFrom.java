package com.greencity.form;

import lombok.Data;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

/**
 * @author AndyFung
 * @version 1.0
 * @date 2020/7/10/010 10:53
 */
@Data
public class OrderFrom {

    @NotEmpty(message = "姓名必填")
    private String name;

    @NotEmpty(message = "手机号必填")
    private String phone;

    @NotEmpty(message = "地址必填")
    private String address;


    @NotEmpty(message = "openId必填")
    private String openId;

    @NotEmpty(message = "购物车不能为空")
    private String items;
}
