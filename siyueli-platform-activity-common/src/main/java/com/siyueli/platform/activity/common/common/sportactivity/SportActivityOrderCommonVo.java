package com.siyueli.platform.activity.common.common.sportactivity;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.io.Serializable;
import java.math.BigDecimal;

@Data
public class SportActivityOrderCommonVo implements Serializable {

    private static final long serialVersionUID = 1L;

    @ApiModelProperty("订单号")
    private String orderNo;

    @ApiModelProperty("活动报名id")
    private Long signupId;

    @ApiModelProperty("总额")
    private BigDecimal amount;

    @ApiModelProperty("实付金额")
    private BigDecimal paidAmount;

    @ApiModelProperty("状态")
    private Integer status;

    @ApiModelProperty("备注")
    private String remark;

    /*@ApiModelProperty("是否已删除")
    private Integer isDeleted;*/

}
