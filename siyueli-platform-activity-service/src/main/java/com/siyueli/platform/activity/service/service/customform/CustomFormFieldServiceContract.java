package com.siyueli.platform.activity.service.service.customform;

import cn.siyue.platform.base.ResponseData;
import com.baomidou.mybatisplus.service.IService;
import com.siyueli.platform.activity.common.common.PageResponse;
import com.siyueli.platform.activity.common.entity.customform.CustomFormField;
import com.siyueli.platform.activity.common.request.customform.customformfield.SearchCustomFormFieldRequest;
import com.siyueli.platform.activity.common.response.customform.CustomFormFieldVo;

/**
 * <p>
 * 表单字段表 服务类
 * </p>
 *
 * @author Sipin ERP Development Team
 */
public interface CustomFormFieldServiceContract extends IService<CustomFormField> {

    public ResponseData<PageResponse<CustomFormFieldVo>> search(SearchCustomFormFieldRequest requestParam);
}
