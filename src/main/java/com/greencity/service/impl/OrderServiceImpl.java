package com.greencity.service.impl;

import com.greencity.converter.OrderMater2OrderDTOConverter;
import com.greencity.dao.OrderDetailDao;
import com.greencity.dao.OrderMasterDao;
import com.greencity.dto.CartDTO;
import com.greencity.dto.OrderDTO;
import com.greencity.entity.OrderDetail;
import com.greencity.entity.OrderMaster;
import com.greencity.entity.ProductInfo;
import com.greencity.enums.OrderStatusEnum;
import com.greencity.enums.PayStatusEnum;
import com.greencity.enums.ResultEnum;
import com.greencity.exception.SellException;
import com.greencity.service.OrderService;
import com.greencity.service.ProductInfoService;
import com.greencity.util.KeyUtil;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.CollectionUtils;

import java.beans.Beans;
import java.math.BigDecimal;
import java.math.BigInteger;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

/**
 * @author AndyFung
 * @version 1.0
 * @date 2020/7/8/008 11:45
 */
@Service
@Slf4j
public class OrderServiceImpl implements OrderService {

    @Autowired
    private ProductInfoService productInfoService;

    @Autowired
    private OrderDetailDao orderDetailDao;

    @Autowired
    private OrderMasterDao orderMasterDao;


    @Override
    @Transactional
    public OrderDTO createOrder(OrderDTO orderDto) {

        String orderId= KeyUtil.genUniqueKey();
        BigDecimal orderAmount = new BigDecimal(BigInteger.ZERO);

        //查询商品价格数量
        for (OrderDetail orderDetail : orderDto.getOrderDetailList()) {
            Optional<ProductInfo> productInfo = productInfoService.findOne(orderDetail.getProductId());
            if (productInfo == null) {
                throw new SellException(ResultEnum.PRODUCT_NOT_EXIST);
            }
            //计算出订单总价
            orderAmount=productInfo.get().getProductPrice().multiply(new BigDecimal(orderDetail.getProductQuantity()))
                    .add(orderAmount);

            //订单详情入库
            orderDetail.setDetailId(KeyUtil.genUniqueKey());
            orderDetail.setOrderId(orderId);
            BeanUtils.copyProperties(productInfo.get(),orderDetail);
            orderDetailDao.save(orderDetail);
        }

        //写入订单数据库
        OrderMaster orderMaster = new OrderMaster();
        orderDto.setOrderId(orderId);
        BeanUtils.copyProperties(orderDto, orderMaster);
        orderMaster.setOrderAmount(orderAmount);
        orderMaster.setOrderStatus(OrderStatusEnum.NEW.getCode());
        orderMaster.setPayStatus(PayStatusEnum.WAIT.getCode());
        orderMasterDao.save(orderMaster);

        //扣库存
        List<CartDTO> cartDTOList = orderDto.getOrderDetailList().stream().map(e ->
                new CartDTO(e.getProductId(), e.getProductQuantity())
        ).collect(Collectors.toList());
        productInfoService.decrease(cartDTOList);
        return orderDto;
    }

    @Override
    public OrderDTO findOne(String orderId) {
        Optional<OrderMaster> orderMaster = orderMasterDao.findById(orderId);
        if (orderMaster == null) {
            throw new SellException(ResultEnum.ORDER_NOT_EXIST);
        }
        //查询订单详情
        List<OrderDetail> orderDetailList = orderDetailDao.findByOrderId(orderId);
        if (CollectionUtils.isEmpty(orderDetailList)) {
            throw new SellException(ResultEnum.ORDERDETAIL_NOT_EXIST);
        }
        OrderDTO orderDTO = new OrderDTO();
        BeanUtils.copyProperties(orderMaster.get(),orderDTO);
        orderDTO.setOrderDetailList(orderDetailList);
        return orderDTO;
    }

    @Override
    public Page<OrderDTO> findByPage(String buyOpenId, Pageable pageable) {
        Page<OrderMaster> orderMasterDaoList = orderMasterDao.findByBuyerOpenid(buyOpenId, pageable);
        List<OrderDTO> converter = OrderMater2OrderDTOConverter.converter(orderMasterDaoList.getContent());
        Page<OrderDTO> orderDTOPage = new PageImpl<OrderDTO>(converter, pageable, orderMasterDaoList.getTotalElements());
        return orderDTOPage;
    }

    @Override
    @Transactional
    public OrderDTO cancel(OrderDTO orderDTO) {
        OrderMaster orderMaster = new OrderMaster();
        //判断订单状态
        if (!orderDTO.getOrderStatus().equals(OrderStatusEnum.NEW.getCode())) {
            log.error("【取消订单】 订单状态不正确，orderId={},orderStatus={}", orderDTO.getOrderStatus());
            throw new SellException(ResultEnum.ORDER_STATUS_REEOR);
        }
        //修改订单状态
        orderDTO.setOrderStatus(OrderStatusEnum.CANCEL.getCode());
        BeanUtils.copyProperties(orderDTO,orderMaster);
        OrderMaster orderMasterSave = orderMasterDao.save(orderMaster);
        if (orderMasterSave == null) {
            log.error("[更新失败] orderMasterSave: {}", orderMasterSave);
            throw new SellException(ResultEnum.ORDER_UPDATE_FAIL);
        }
        //返还库存
        if (CollectionUtils.isEmpty(orderDTO.getOrderDetailList())) {
            log.error("[取消订单] 订单中无商品详情 orderDto: {}", orderDTO);
            throw new SellException(ResultEnum.ORDER_DETAIL_EMPTY);
        }
        List<CartDTO> cartDTOList = orderDTO.getOrderDetailList().stream().map(m -> new CartDTO(m.getProductId(), m.getProductQuantity()))
                .collect(Collectors.toList());
        productInfoService.increaseStock(cartDTOList);
        //如果已支付，需要退款
        if (orderDTO.getOrderStatus().equals(PayStatusEnum.PAY_SUCCESS.getCode())) {
            //TODO
        }
        return orderDTO;
    }

    @Override
    public OrderDTO finish(OrderDTO orderDTO) {
        //判断订单状态
        if (!orderDTO.getOrderStatus().equals(OrderStatusEnum.NEW.getCode())) {
            log.error("[完结订单] 订单状态不正确 ，orderId:{}",orderDTO.getOrderId());
            throw new SellException(ResultEnum.ORDER_STATUS_REEOR);
        }
        //修改订单状态
        orderDTO.setOrderStatus(OrderStatusEnum.FINISHED.getCode());
        OrderMaster orderMaster = new OrderMaster();
        BeanUtils.copyProperties(orderDTO, orderMaster);
        OrderMaster orderMasterSave = orderMasterDao.save(orderMaster);
        if (orderMasterSave == null) {
            log.error("[完结订单] 更新失败 orderMasterSave: {}", orderMasterSave);
            throw new SellException(ResultEnum.ORDER_UPDATE_FAIL);
        }
        return orderDTO;
    }

    @Override
    public OrderDTO payOrder(OrderDTO orderDTO) {
        //判断订单状态
        if (!orderDTO.getOrderStatus().equals(OrderStatusEnum.NEW.getCode())) {
            log.error("[订单支付完成] 订单状态不正确 ，orderId:{}",orderDTO.getOrderId());
            throw new SellException(ResultEnum.ORDER_STATUS_REEOR);
        }
        //判断支付状态
        if (!orderDTO.getPayStatus().equals(PayStatusEnum.WAIT.getCode())) {
            log.error("[订单支付完成] 订单状态不对 ，orderId: {}", orderDTO.getOrderId());
            throw new SellException(ResultEnum.ORDER_PAY_STATUS_ERROR);
        }
        //修改支付状态
        orderDTO.setPayStatus(PayStatusEnum.PAY_SUCCESS.getCode());
        OrderMaster orderMaster = new OrderMaster();
        BeanUtils.copyProperties(orderDTO, orderMaster);
        OrderMaster orderMasterSave = orderMasterDao.save(orderMaster);
        if (orderMasterSave == null) {
            log.error("[订单支付完成] 更新失败 orderMasterSave: {}", orderMasterSave);
            throw new SellException(ResultEnum.ORDER_UPDATE_FAIL);
        }
        return orderDTO;
    }
}
