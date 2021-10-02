package com.yxd.enmus;

/**
 * 订单支付状态
 */
public enum PaymentStatus {
    WAIT_PAY(1,"等待支付"),
    SURE_PAY(2,"已支付");

    public final Integer type;
    public final String value;
    PaymentStatus(Integer type, String value){
        this.type = type;
        this.value = value;
    }
}
