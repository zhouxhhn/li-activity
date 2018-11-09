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
 * 体育活动_主办方
 * </p>
 *
 * @author Sipin ERP Development Team
 */
@Data
@Accessors(chain = true)
@TableName("sport_activity_sponsor")
public class SportActivitySponsor extends Model<SportActivitySponsor> {

    private static final long serialVersionUID = 1L;

    /**
     * 主键
     */
    @TableId(value = "id", type = IdType.AUTO)
    private Long id;
    /**
     * 主办方名称
     */
    private String name;
    /**
     * 联系电话
     */
    private String telephone;
    /**
     * 联系邮箱
     */
    private String email;
    /**
     * 官方网址
     */
    private String website;
    /**
     * 主办方介绍
     */
    private String introduction;
    /**
     * 主办方logo图片id
     */
    @TableField("logo_image_id")
    private Long logoImageId;
    /**
     * 主办方logo图片url
     */
    @TableField("logo_image_url")
    private String logoImageUrl;
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
