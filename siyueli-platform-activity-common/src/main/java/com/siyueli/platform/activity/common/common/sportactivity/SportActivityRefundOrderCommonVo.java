package com.siyueli.platform.activity.common.common.sportactivity;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.io.Serializable;
import java.math.BigDecimal;

@Data
public class SportActivityRefundOrderCommonVo implements Serializable {

    private static final long serialVersionUID = 1L;

    @ApiModelProperty("订单id")
    private Long orderId;

    @ApiModelProperty("退款单号")
    private String refundOrderNo;

    @ApiModelProperty("活动报名id")
    private Long signupId;

    @ApiModelProperty("退款金额")
    private BigDecimal refundAmount;

    @ApiModelProperty("状态")
    private Integer status;

    /*@ApiModelProperty("是否已删除")
    private Integer isDeleted;*/

}
