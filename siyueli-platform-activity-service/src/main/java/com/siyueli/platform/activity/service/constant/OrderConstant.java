package com.siyueli.platform.activity.service.constant;

public class OrderConstant {

    /**
     * 未付款
     */
    public static final Integer ORDER_STATUS_NO_PAYMENT = 0;

    /**
     * 支付失败
     */
    public static final Integer ORDER_STATUS_PAYMENT_FAIL = 1;

    /**
     * 已付款
     */
    public static final Integer ORDER_STATUS_PAID = 10;

    /**
     * 过期
     */
    public static final Integer ORDER_STATUS_EXPIRED = 5;

    /**
     * 待退款
     */
    public static final Integer ORDER_STATUS_READY_REFUND = 20;

    /**
     * 已退款
     */
    public static final Integer ORDER_STATUS_REFUNDED = 40;
}
