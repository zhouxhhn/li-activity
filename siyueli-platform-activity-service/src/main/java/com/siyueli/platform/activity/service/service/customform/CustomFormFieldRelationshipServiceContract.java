package com.siyueli.platform.activity.service.service.customform;

import cn.siyue.platform.base.ResponseData;
import com.baomidou.mybatisplus.service.IService;
import com.siyueli.platform.activity.common.common.PageResponse;
import com.siyueli.platform.activity.common.entity.customform.CustomFormFieldRelationship;
import com.siyueli.platform.activity.common.request.customform.CustomFormFieldRelationshipSearchRequest;
import com.siyueli.platform.activity.common.response.customform.CustomFormFieldRelationshipVo;

/**
 * <p>
 * 表单与字段关系表 服务类
 * </p>
 *
 * @author Sipin ERP Development Team
 */
public interface CustomFormFieldRelationshipServiceContract extends IService<CustomFormFieldRelationship> {

    public ResponseData<PageResponse<CustomFormFieldRelationshipVo>> search(CustomFormFieldRelationshipSearchRequest requestParam);
}
