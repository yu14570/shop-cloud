package com.yxd.controller;

import com.yxd.bo.SubmitOrderBO;
import com.yxd.pojo.OrderStatus;
import com.yxd.pojo.Orders;
import com.yxd.service.OrderService;
import com.yxd.vo.OrderVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("order")
public class OrderController {
    @Autowired
    private OrderService orderService;

    /**
     * 用于创建订单相关信息
     * @param submitOrderBO
     */
    @PostMapping("createOrder")
    public OrderVO createOrder(@RequestParam(name = "submitOrderBO")SubmitOrderBO submitOrderBO){
        return orderService.createOrder(submitOrderBO);
    }

    /**
     * 修改订单状态
     * @param orderId
     * @param orderStatus
     */
    @PostMapping("updateOrderStatus")
    public void updateOrderStatus(@RequestParam(name = "orderId")String orderId,
                                  @RequestParam(name = "orderStatus")Integer orderStatus){
        orderService.updateOrderStatus(orderId,orderStatus);
    }

    /**
     * 查询订单状态
     * @param orderId
     * @return
     */
    @PostMapping("queryOrderStatusInfo")
    public OrderStatus queryOrderStatusInfo(@RequestParam(name = "orderId")String orderId){
        return orderService.queryOrderStatusInfo(orderId);
    }

    /**
     * 关闭超时未支付订单
     */
    @GetMapping("closeOrder")
    public void closeOrder(){

    }

    /**
     * 查询订单详情
     */
    @PostMapping("queryOrder")
    public Orders queryOrder(@RequestParam(name = "merchantOrderId")String merchantOrderId,
                             @RequestParam(name = "merchantUserId")String merchantUserId,
                             @RequestParam(name = "orderStatus")Integer orderStatus){
        return orderService.queryOrder(merchantOrderId,merchantUserId,orderStatus);
    }

    /**
     * 订单支付，修改订单表订单状态
     */
    @PostMapping("orderPay")
    public int orderPay(@RequestParam(name = "merchantOrderId")String merchantOrderId,
                        @RequestParam(name = "merchantUserId")String merchantUserId,
                        @RequestParam(name = "orderStatus")Integer orderStatus){
        return orderService.orderPay(merchantOrderId,merchantUserId, orderStatus);
    }
}
