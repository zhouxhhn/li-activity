package com.siyueli.platform.activity.service.service.customform.impl;

import cn.siyue.platform.base.ResponseData;
import cn.siyue.platform.util.ResponseUtil;
import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.plugins.Page;
import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import com.siyueli.platform.activity.common.common.PageResponse;
import com.siyueli.platform.activity.common.entity.customform.CustomFormField;
import com.siyueli.platform.activity.common.request.customform.customformfield.SearchCustomFormFieldRequest;
import com.siyueli.platform.activity.common.response.customform.CustomFormFieldVo;
import com.siyueli.platform.activity.service.mapper.customform.CustomFormFieldMapper;
import com.siyueli.platform.activity.service.service.customform.CustomFormFieldServiceContract;
import com.siyueli.platform.activity.service.util.ConvertUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 表单字段表 服务实现类
 * </p>
 *
 * @author Sipin ERP Development Team
 */
@Primary
@Service
public class CustomFormFieldService extends ServiceImpl<CustomFormFieldMapper, CustomFormField> implements CustomFormFieldServiceContract {

    private static final Logger LOGGER = LoggerFactory.getLogger(CustomFormFieldService.class);

    @Override
    public ResponseData<PageResponse<CustomFormFieldVo>> search(SearchCustomFormFieldRequest requestParam) {
        EntityWrapper<CustomFormField> entityWrapper = new EntityWrapper<CustomFormField>();
        Page<CustomFormField> page = new Page<CustomFormField>(requestParam.getPage(), requestParam.getSize());
        Page<CustomFormField> resultPage = selectPage(page, entityWrapper);
        try {
            PageResponse<CustomFormFieldVo> pageResponse = ConvertUtil.getPageResponse(resultPage, CustomFormFieldVo.class);
            return ResponseUtil.success(pageResponse);
        } catch (Exception e) {
            LOGGER.error(e.getMessage(), e);
        }

        return ResponseUtil.fail();
    }
}
