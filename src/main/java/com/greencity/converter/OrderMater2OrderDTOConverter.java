package com.greencity.converter;

import com.greencity.dto.OrderDTO;
import com.greencity.entity.OrderMaster;
import org.springframework.beans.BeanUtils;

import java.util.List;
import java.util.stream.Collectors;

/**
 * @author AndyFung
 * @version 1.0
 * @date 2020/7/9/009 16:28
 */
public class OrderMater2OrderDTOConverter {

    public static OrderDTO converter(OrderMaster orderMaster) {
        OrderDTO orderDTO = new OrderDTO();
        BeanUtils.copyProperties(orderMaster, orderDTO);
        return orderDTO;
    }

    public static List<OrderDTO> converter(List<OrderMaster> orderMasterList) {

        return orderMasterList.stream().map(m ->
                converter(m)
        ).collect(Collectors.toList());
    }
}
