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
 * 活动分类
 * </p>
 *
 * @author Sipin ERP Development Team
 */
@Data
@Accessors(chain = true)
@TableName("sport_activity_category")
public class SportActivityCategory extends Model<SportActivityCategory> {

    private static final long serialVersionUID = 1L;

    /**
     * 主键
     */
    @TableId(value = "id", type = IdType.AUTO)
    private Long id;
    /**
     * 分类名称
     */
    private String name;
    /**
     * 父级id
     */
    @TableField("parent_id")
    private Long parentId;
    /**
     * 最左
     */
    private Integer lft;
    /**
     * 最右
     */
    private Integer rgt;
    /**
     * 排序
     */
    private Integer sort;
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
     * 分类简介
     */
    private String introduction;
    /**
     * 分类id
     */
    @TableField("image_id")
    private Long imageId;
    /**
     * 分类url
     */
    @TableField("image_url")
    private String imageUrl;
    /**
     * 是否设为热门分类
     */
    @TableField("is_hot")
    private Integer isHot;


    @Override
    protected Serializable pkVal() {
        return this.id;
    }

}
