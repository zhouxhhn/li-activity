package com.siyueli.platform.activity.common.common.sportactivity;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

@Data
public class SportActivityCommonVo implements Serializable {

    private static final long serialVersionUID = 1L;

    @ApiModelProperty("活动名称")
    private String name;

    @ApiModelProperty("活动开始时间")
    private Date beginTime;

    @ApiModelProperty("活动结束时间")
    private Date endTime;

    @ApiModelProperty("详细地址")
    private String address;

    @ApiModelProperty("主办方")
    private Long sponsor;

    @ApiModelProperty("活动分类id")
    private Long categoryId;

    @ApiModelProperty("是否公开活动")
    private Integer isPublic;

    @ApiModelProperty("活动海报图片id")
    private Long posterImageId;

    @ApiModelProperty("活动海报图片url")
    private String posterImageUrl;

    @ApiModelProperty("活动详情")
    private String activityDetail;

    @ApiModelProperty("分享标题")
    private String shareTitle;

    @ApiModelProperty("分享描述")
    private String shareDescription;

    @ApiModelProperty("分享图片id")
    private Long shareImageId;

    @ApiModelProperty("分享图片")
    private String shareImageUrl;

    @ApiModelProperty("报名数量限制")
    private Integer quantityLimit;

    @ApiModelProperty("报名数量")
    private Integer quantity;

    @ApiModelProperty("报名对象")
    private Integer subject;

    @ApiModelProperty("是否限制团体人数")
    private Integer teamQtyLimit;

    @ApiModelProperty("团体人数最小值")
    private Integer teamQtyMin;

    @ApiModelProperty("团体人数最大值")
    private Integer teamQtyMax;

    @ApiModelProperty("活动是否收费")
    private Integer feeFlag;

    @ApiModelProperty("收费费用")
    private BigDecimal fee;

    @ApiModelProperty("是否支持退费")
    private Integer refundFlag;

    @ApiModelProperty("活动需要审核")
    private Integer auditFlag;

    @ApiModelProperty("表单id")
    private Long formId;

    /*@ApiModelProperty("是否已删除")
    private Integer isDeleted;*/

    @ApiModelProperty("活动地点-省")
    private String siteProvince;

    @ApiModelProperty("活动地点-城市")
    private String siteCity;

    @ApiModelProperty("活动地点-区")
    private String siteArea;

    @ApiModelProperty("允许退款时间")
    private BigDecimal allowRefundTime;

    @ApiModelProperty("受邀人员需要付款")
    private Integer invitedNeedPayment;

    @ApiModelProperty("报名时间-开始")
    private Date signupTimeStart;

    @ApiModelProperty("报名时间-结束")
    private Date signupTimeEnd;

    @ApiModelProperty("状态")
    private Integer status;

    @ApiModelProperty("是否热门")
    private Integer isHot;

    @ApiModelProperty("排序")
    private Integer sort;

}
