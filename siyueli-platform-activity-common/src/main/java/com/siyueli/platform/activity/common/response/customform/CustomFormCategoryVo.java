package com.siyueli.platform.activity.common.response.customform;

import com.siyueli.platform.activity.common.common.customform.CustomFormCategoryCommonVo;
import lombok.Data;

import java.util.Date;

@Data
public class CustomFormCategoryVo extends CustomFormCategoryCommonVo {

    private Long id;

    /**
     * 更新时间
     */
    private Date updateAt;
    /**
     * 创建时间
     */
    private Date createAt;
}
