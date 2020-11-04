package com.greencity.controller;

import com.baomidou.mybatisplus.core.toolkit.CollectionUtils;
import com.baomidou.mybatisplus.core.toolkit.StringUtils;
import com.greencity.converter.OrderForm2OrderDTOConverter;
import com.greencity.dto.OrderDTO;
import com.greencity.enums.ResultEnum;
import com.greencity.exception.SellException;
import com.greencity.form.OrderFrom;
import com.greencity.service.BuyerService;
import com.greencity.service.OrderService;
import com.greencity.util.ResultVOUtil;
import com.greencity.vo.ResultVO;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author AndyFung
 * @version 1.0
 * @date 2020/7/10/010 10:50
 */
@RestController
@Slf4j
@RequestMapping("/buyer/order")
public class BuyerOrderController {

    @Autowired
    private OrderService orderService;

    @Autowired
    private BuyerService buyerService;


    /**
     * @param orderFrom
     * @param bindingResult
     * @return
     */
    @PostMapping("/create")
    public ResultVO<Map<String, String>> create(@Valid OrderFrom orderFrom, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            log.error("[创建订单] 参数不正确 orderFrom: {}", orderFrom);
            throw new SellException(ResultEnum.PARAM_REEOR.getCode(), bindingResult.getFieldError().getDefaultMessage());
        }
        OrderDTO orderDTO = OrderForm2OrderDTOConverter.convert(orderFrom);
        if (CollectionUtils.isEmpty(orderDTO.getOrderDetailList())) {
            log.error("[创建订单] 购物车补不能为空 ");
            throw new SellException(ResultEnum.CART_EMPTY);
        }
        OrderDTO order = orderService.createOrder(orderDTO);
        HashMap<String, String> stringHashMap = new HashMap<String, String>();
        stringHashMap.put("OrderId", order.getOrderId());
        return ResultVOUtil.success();
    }

    //订单列表
    @GetMapping("/list")
    public ResultVO<List<OrderDTO>> list(@RequestParam("openid") String openid,
                                         @RequestParam(value = "page", defaultValue = "0") Integer page,
                                         @RequestParam(value = "size", defaultValue = "10") Integer size) {
        if (StringUtils.isEmpty(openid)) {
            log.error("[查询订单列表] openId为空");
            throw new SellException(ResultEnum.PARAM_REEOR);
        }

        PageRequest pageRequest = new PageRequest(page, size);
        Page<OrderDTO> byPage = orderService.findByPage(openid, pageRequest);
        return ResultVOUtil.success(byPage.getContent());
    }

    //订单详情

    @GetMapping("/detail")
    public ResultVO<OrderDTO> detail(@RequestParam("openid") String openid,
                                     @RequestParam("orderId") String orderId) {
        OrderDTO orderDTO = buyerService.findOrderOne(openid, orderId);
        return ResultVOUtil.success(orderDTO);
    }
    //取消订单

    @PostMapping("/cancel")
    public ResultVO<OrderDTO> cancel(@RequestParam("openid") String openid,
                                     @RequestParam("orderId") String orderId) {
        buyerService.cancelOrder(openid, orderId);
        return ResultVOUtil.success();
    }
}
