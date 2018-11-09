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
 * 活动渠道
 * </p>
 *
 * @author Sipin ERP Development Team
 */
@Data
@Accessors(chain = true)
@TableName("sport_activity_channel")
public class SportActivityChannel extends Model<SportActivityChannel> {

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
     * 渠道id
     */
    @TableField("channel_id")
    private Long channelId;
    /**
     * 渠道链接
     */
    @TableField("link_url")
    private String linkUrl;
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
     * 渠道状态
     */
    private Integer status;


    @Override
    protected Serializable pkVal() {
        return this.id;
    }

}
