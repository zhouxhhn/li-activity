package com.siyueli.platform.activity.service.service.customform;

import cn.siyue.platform.base.ResponseData;
import com.baomidou.mybatisplus.service.IService;
import com.siyueli.platform.activity.common.common.PageResponse;
import com.siyueli.platform.activity.common.entity.customform.CustomFieldOption;
import com.siyueli.platform.activity.common.request.customform.customfieldoption.SearchCustomFieldOptionRequest;
import com.siyueli.platform.activity.common.response.customform.CustomFieldOptionVo;

/**
 * <p>
 * 字段选项表 服务类
 * </p>
 *
 * @author Sipin ERP Development Team
 */
public interface CustomFieldOptionServiceContract extends IService<CustomFieldOption> {

    public ResponseData<PageResponse<CustomFieldOptionVo>> search(SearchCustomFieldOptionRequest requestParam);
}
