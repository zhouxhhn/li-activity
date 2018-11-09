package com.siyueli.platform.activity.common.entity.sportactivity;

import com.baomidou.mybatisplus.activerecord.Model;
import com.baomidou.mybatisplus.annotations.TableField;
import com.baomidou.mybatisplus.annotations.TableId;
import com.baomidou.mybatisplus.annotations.TableName;
import com.baomidou.mybatisplus.enums.IdType;
import lombok.Data;
import lombok.experimental.Accessors;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

/**
 * <p>
 * 体育活动
 * </p>
 *
 * @author Sipin ERP Development Team
 */
@Data
@Accessors(chain = true)
@TableName("sport_activity")
public class SportActivity extends Model<SportActivity> {

    private static final long serialVersionUID = 1L;

    /**
     * 主键
     */
    @TableId(value = "id", type = IdType.AUTO)
    private Long id;
    /**
     * 活动名称
     */
    private String name;
    /**
     * 活动开始时间
     */
    @TableField("begin_time")
    private Date beginTime;
    /**
     * 活动结束时间
     */
    @TableField("end_time")
    private Date endTime;
    /**
     * 详细地址
     */
    private String address;
    /**
     * 主办方
     */
    private Long sponsor;
    /**
     * 活动分类id
     */
    @TableField("category_id")
    private Long categoryId;
    /**
     * 是否公开活动
     */
    @TableField("is_public")
    private Integer isPublic;
    /**
     * 活动海报图片id
     */
    @TableField("poster_image_id")
    private Long posterImageId;
    /**
     * 活动海报图片url
     */
    @TableField("poster_image_url")
    private String posterImageUrl;
    /**
     * 活动详情
     */
    @TableField("activity_detail")
    private String activityDetail;
    /**
     * 分享标题
     */
    @TableField("share_title")
    private String shareTitle;
    /**
     * 分享描述
     */
    @TableField("share_description")
    private String shareDescription;
    /**
     * 分享图片id
     */
    @TableField("share_image_id")
    private Long shareImageId;
    /**
     * 分享图片
     */
    @TableField("share_image_url")
    private String shareImageUrl;
    /**
     * 报名数量限制
     */
    @TableField("quantity_limit")
    private Integer quantityLimit;
    /**
     * 报名数量
     */
    private Integer quantity;
    /**
     * 报名对象
     */
    private Integer subject;
    /**
     * 是否限制团体人数
     */
    @TableField("team_qty_limit")
    private Integer teamQtyLimit;
    /**
     * 团体人数最小值
     */
    @TableField("team_qty_min")
    private Integer teamQtyMin;
    /**
     * 团体人数最大值
     */
    @TableField("team_qty_max")
    private Integer teamQtyMax;
    /**
     * 活动是否收费
     */
    @TableField("fee_flag")
    private Integer feeFlag;
    /**
     * 收费费用
     */
    private BigDecimal fee;
    /**
     * 是否支持退费
     */
    @TableField("refund_flag")
    private Integer refundFlag;
    /**
     * 活动需要审核
     */
    @TableField("audit_flag")
    private Integer auditFlag;
    /**
     * 表单id
     */
    @TableField("form_id")
    private Long formId;
    /**
     * 是否已删除
     */
    @TableField("is_deleted")
    private Integer isDeleted;
    /**
     * 创建时间
     */
    @TableField("create_at")
    private Date createAt;
    /**
     * 更新时间
     */
    @TableField("update_at")
    private Date updateAt;
    /**
     * 活动地点-省
     */
    @TableField("site_province")
    private Long siteProvince;
    /**
     * 活动地点-城市
     */
    @TableField("site_city")
    private Long siteCity;
    /**
     * 活动地点-区
     */
    @TableField("site_area")
    private Long siteArea;
    /**
     * 允许退款时间
     */
    @TableField("allow_refund_time")
    private BigDecimal allowRefundTime;
    /**
     * 受邀人员需要付款
     */
    @TableField("invited_need_payment")
    private Integer invitedNeedPayment;
    /**
     * 报名时间-开始
     */
    @TableField("signup_time_start")
    private Date signupTimeStart;
    /**
     * 报名时间-结束
     */
    @TableField("signup_time_end")
    private Date signupTimeEnd;
    /**
     * 状态
     */
    private Integer status;
    /**
     * 是否热门
     */
    @TableField("is_hot")
    private Integer isHot;
    /**
     * 排序
     */
    private Integer sort;


    @Override
    protected Serializable pkVal() {
        return this.id;
    }

}
