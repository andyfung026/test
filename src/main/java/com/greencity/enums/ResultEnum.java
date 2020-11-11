package com.greencity.enums;

import lombok.Getter;

/**
 * @author AndyFung
 * @version 1.0
 * @date 2020/7/8/008 11:59
 */
@Getter
public enum ResultEnum {

    PRODUCT_NOT_EXIST(10, "商品不存在"),
    PRODUCT_STOCK_ERROR(11, "库存不足"),
    ORDER_NOT_EXIST(12, "订单不存在"),
    ORDERDETAIL_NOT_EXIST(13, "订单详情不存在"),
    ORDER_STATUS_REEOR(14, "订单状态不正确"),
    ORDER_UPDATE_FAIL(15, "订单更新失败"),
    ORDER_DETAIL_EMPTY(16, "订单中无商品详情"),
    ORDER_PAY_STATUS_ERROR(17, "支付订单状态不正确"),

    PARAM_REEOR(20, "参数不正确"),

    CART_EMPTY(30, "购物车不能为空"),

    ORDER_OWNER_ERROR(40, "该订单不属于当前用户"),

    WE_MP_ERROR(18, "微信公众号有错");

    private Integer code;

    private String message;

    ResultEnum(Integer code, String message) {
        this.code = code;
        this.message = message;
    }
}
