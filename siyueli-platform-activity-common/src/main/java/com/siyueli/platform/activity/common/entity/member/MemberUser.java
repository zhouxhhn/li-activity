package com.siyueli.platform.activity.common.entity.member;

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
 * 会员表
 * </p>
 *
 * @author Sipin ERP Development Team
 */
@Data
@Accessors(chain = true)
@TableName("member_user")
public class MemberUser extends Model<MemberUser> {

    private static final long serialVersionUID = 1L;

    @TableId(value = "id", type = IdType.AUTO)
    private Long id;
    /**
     * 会员号
     */
    private String code;
    /**
     * 会员名称
     */
    private String name;
    /**
     * 手机号码
     */
    private String cellphone;
    /**
     * 会员等级
     */
    @TableField("grade_id")
    private Long gradeId;
    /**
     * 注册时间
     */
    @TableField("create_at")
    private Date createAt;
    /**
     * 注册渠道
     */
    @TableField("register_channel")
    private String registerChannel;
    /**
     * 微信unnitId
     */
    @TableField("unnit_id")
    private String unnitId;
    /**
     * 车牌号
     */
    @TableField("car_num")
    private String carNum;
    /**
     * 生日
     */
    private Date birthday;
    /**
     * 密码
     */
    private String password;
    /**
     * 状态
     */
    private Integer status;
    /**
     * 身份证号码
     */
    @TableField("identity_id")
    private String identityId;
    /**
     * 邮箱
     */
    private String email;
    /**
     * 余额
     */
    private BigDecimal balance;
    /**
     * 赠送余额
     */
    @TableField("donate_balance")
    private BigDecimal donateBalance;
    /**
     * 押金
     */
    private BigDecimal deposite;
    /**
     * 积分
     */
    private BigDecimal points;
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
