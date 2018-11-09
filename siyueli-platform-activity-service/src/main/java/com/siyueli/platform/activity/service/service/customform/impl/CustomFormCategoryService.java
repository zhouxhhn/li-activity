package com.siyueli.platform.activity.service.service.customform.impl;

import cn.siyue.platform.base.ResponseData;
import cn.siyue.platform.util.ResponseUtil;
import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.plugins.Page;
import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import com.siyueli.platform.activity.common.common.PageResponse;
import com.siyueli.platform.activity.common.entity.customform.CustomFormCategory;
import com.siyueli.platform.activity.common.request.customform.customformcategory.SearchCustomFormCategoryRequest;
import com.siyueli.platform.activity.common.response.customform.CustomFormCategoryVo;
import com.siyueli.platform.activity.service.mapper.customform.CustomFormCategoryMapper;
import com.siyueli.platform.activity.service.service.customform.CustomFormCategoryServiceContract;
import com.siyueli.platform.activity.service.util.ConvertUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 表单分类表 服务实现类
 * </p>
 *
 * @author Sipin ERP Development Team
 */
@Primary
@Service
public class CustomFormCategoryService extends ServiceImpl<CustomFormCategoryMapper, CustomFormCategory> implements CustomFormCategoryServiceContract {

    private static final Logger LOGGER = LoggerFactory.getLogger(CustomFormCategoryService.class);

    @Override
    public ResponseData<PageResponse<CustomFormCategoryVo>> search(SearchCustomFormCategoryRequest requestParam) {
        EntityWrapper<CustomFormCategory> entityWrapper = new EntityWrapper<CustomFormCategory>();
        Page<CustomFormCategory> page = new Page<CustomFormCategory>(requestParam.getPage(), requestParam.getSize());
        Page<CustomFormCategory> resultPage = selectPage(page, entityWrapper);
        try {
            PageResponse<CustomFormCategoryVo> pageResponse = ConvertUtil.getPageResponse(resultPage, CustomFormCategoryVo.class);
            return ResponseUtil.success(pageResponse);
        } catch (Exception e) {
            LOGGER.error(e.getMessage(), e);
        }

        return ResponseUtil.fail();
    }
}
