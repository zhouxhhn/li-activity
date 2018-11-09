package com.siyueli.platform.activity.common.entity.sportactivity;

import com.baomidou.mybatisplus.activerecord.Model;
import com.baomidou.mybatisplus.annotations.TableField;
import com.baomidou.mybatisplus.annotations.TableId;
import com.baomidou.mybatisplus.annotations.TableName;
import com.baomidou.mybatisplus.enums.IdType;
import lombok.Data;
import lombok.experimental.Accessors;

import java.io.Serializable;
import java.util.Date;

/**
 * <p>
 * 活动报名
 * </p>
 *
 * @author Sipin ERP Development Team
 */
@Data
@Accessors(chain = true)
@TableName("sport_activity_signup")
public class SportActivitySignup extends Model<SportActivitySignup> {

    private static final long serialVersionUID = 1L;

    /**
     * 主键
     */
    @TableId(value = "id", type = IdType.AUTO)
    private Long id;
    /**
     * 活动id
     */
    @TableField("activity_id")
    private Long activityId;
    /**
     * 活动渠道id
     */
    @TableField("activity_channel_id")
    private Long activityChannelId;
    /**
     * 队伍id
     */
    @TableField("team_id")
    private Long teamId;
    /**
     * 用户id
     */
    @TableField("user_id")
    private Long userId;
    /**
     * 状态
     */
    private Integer status;
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


    @Override
    protected Serializable pkVal() {
        return this.id;
    }

}
