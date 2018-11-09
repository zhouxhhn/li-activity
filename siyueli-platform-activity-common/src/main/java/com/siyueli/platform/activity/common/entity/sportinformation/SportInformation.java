package com.siyueli.platform.activity.common.entity.sportinformation;

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
 * 资讯
 * </p>
 *
 * @author Sipin ERP Development Team
 */
@Data
@Accessors(chain = true)
@TableName("sport_information")
public class SportInformation extends Model<SportInformation> {

    private static final long serialVersionUID = 1L;

    /**
     * 主键
     */
    @TableId(value = "id", type = IdType.AUTO)
    private Long id;
    /**
     * 分类id
     */
    @TableField("category_id")
    private Long categoryId;
    /**
     * 文章标题
     */
    private String title;
    /**
     * 文章简介
     */
    private String introduction;
    /**
     * 排序
     */
    private Integer sort;
    /**
     * 是否热门文章
     */
    @TableField("is_hot")
    private Integer isHot;
    /**
     * 文章详情
     */
    private String details;
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
