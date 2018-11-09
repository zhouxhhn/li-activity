package com.siyueli.platform.activity.common.response.payment;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

@Data
public class GetPayResultResponse {

    @ApiModelProperty(value = "订单号")
    private String orderNo;

    @ApiModelProperty(value = "状态: 0-未付款, 1-支付失败, 10-已付款，5-过期，20-待退款，40-已退款")
    private Integer status;
}
