package com.siyueli.platform.activity.service.service.customform;

import cn.siyue.platform.base.ResponseData;
import com.baomidou.mybatisplus.service.IService;
import com.siyueli.platform.activity.common.common.PageResponse;
import com.siyueli.platform.activity.common.entity.customform.CustomForm;
import com.siyueli.platform.activity.common.request.customform.CustomFormGetRequest;
import com.siyueli.platform.activity.common.request.customform.CustomFormSearchRequest;
import com.siyueli.platform.activity.common.response.customform.CustomFormVo;

/**
 * <p>
 * 表单 服务类
 * </p>
 *
 * @author Sipin ERP Development Team
 */
public interface CustomFormServiceContract extends IService<CustomForm> {

    public ResponseData<PageResponse<CustomFormVo>> search(CustomFormSearchRequest requestParam);

    public CustomFormVo get(CustomFormGetRequest requestParam);
}
