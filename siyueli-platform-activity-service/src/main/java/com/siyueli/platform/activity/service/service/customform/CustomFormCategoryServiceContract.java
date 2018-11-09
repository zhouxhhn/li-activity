package com.siyueli.platform.activity.service.service.customform;

import cn.siyue.platform.base.ResponseData;
import com.baomidou.mybatisplus.service.IService;
import com.siyueli.platform.activity.common.common.PageResponse;
import com.siyueli.platform.activity.common.entity.customform.CustomFormCategory;
import com.siyueli.platform.activity.common.request.customform.customformcategory.SearchCustomFormCategoryRequest;
import com.siyueli.platform.activity.common.response.customform.CustomFormCategoryVo;

/**
 * <p>
 * 表单分类表 服务类
 * </p>
 *
 * @author Sipin ERP Development Team
 */
public interface CustomFormCategoryServiceContract extends IService<CustomFormCategory> {

    public ResponseData<PageResponse<CustomFormCategoryVo>> search(SearchCustomFormCategoryRequest requestParam);
}
