package com.greencity.converter;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.greencity.dto.OrderDTO;
import com.greencity.entity.OrderDetail;
import com.greencity.enums.ResultEnum;
import com.greencity.exception.SellException;
import com.greencity.form.OrderFrom;
import lombok.extern.slf4j.Slf4j;

import java.util.ArrayList;
import java.util.List;

/**
 * @author AndyFung
 * @version 1.0
 * @date 2020/7/10/010 11:08
 */
@Slf4j
public class OrderForm2OrderDTOConverter {

    public static OrderDTO convert(OrderFrom orderFrom) {
        OrderDTO orderDTO = new OrderDTO();
        Gson gson = new Gson();

        orderDTO.setBuyerName(orderFrom.getName());
        orderDTO.setBuyerIphone(orderFrom.getPhone());
        orderDTO.setBuyerAddress(orderFrom.getAddress());
        orderDTO.setBuyerOpenid(orderFrom.getOpenId());
        List<OrderDetail> orderDetailList = new ArrayList<>();
        try {
            orderDetailList = gson.fromJson(orderFrom.getItems(),
                    new TypeToken<List<OrderDetail>>() {
                    }.getType());
        } catch (Exception e) {
            log.error("[对象转换] 错误 ，String：{}", orderFrom.getItems());
            throw new SellException(ResultEnum.PARAM_REEOR);
        }
        orderDTO.setOrderDetailList(orderDetailList);
        return orderDTO;
    }
}
