package com.yxd.service;

import com.yxd.bo.SubmitOrderBO;
import com.yxd.pojo.OrderStatus;
import com.yxd.pojo.Orders;
import com.yxd.vo.OrderVO;

public interface OrderService {

    /**
     * 用于创建订单相关信息
     * @param submitOrderBO
     */
    public OrderVO createOrder(SubmitOrderBO submitOrderBO);

    /**
     * 修改订单状态
     * @param orderId
     * @param orderStatus
     */
    public void updateOrderStatus(String orderId, Integer orderStatus);

    /**
     * 查询订单状态
     * @param orderId
     * @return
     */
    public OrderStatus queryOrderStatusInfo(String orderId);

    /**
     * 关闭超时未支付订单
     */
    public void closeOrder();

    /**
     * 查询订单详情
     */
    public Orders queryOrder(String merchantOrderId, String merchantUserId, Integer orderStatus);

    /**
     * 订单支付，修改订单表订单状态
     */
    public int orderPay(String merchantOrderId, String merchantUserId, Integer orderStatus);
}
