package com.siyueli.platform.activity.service.service.customform.impl;

import cn.siyue.platform.base.ResponseData;
import cn.siyue.platform.util.ResponseUtil;
import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.plugins.Page;
import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import com.siyueli.platform.activity.common.common.PageResponse;
import com.siyueli.platform.activity.common.entity.customform.CustomFormFieldRelationship;
import com.siyueli.platform.activity.common.request.customform.CustomFormFieldRelationshipSearchRequest;
import com.siyueli.platform.activity.common.response.customform.CustomFormFieldRelationshipVo;
import com.siyueli.platform.activity.service.mapper.customform.CustomFormFieldRelationshipMapper;
import com.siyueli.platform.activity.service.service.customform.CustomFormFieldRelationshipServiceContract;
import com.siyueli.platform.activity.service.util.ConvertUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 表单与字段关系表 服务实现类
 * </p>
 *
 * @author Sipin ERP Development Team
 */
@Primary
@Service
public class CustomFormFieldRelationshipService extends ServiceImpl<CustomFormFieldRelationshipMapper, CustomFormFieldRelationship> implements CustomFormFieldRelationshipServiceContract {

    private static final Logger LOGGER = LoggerFactory.getLogger(CustomFormFieldRelationshipService.class);

    @Override
    public ResponseData<PageResponse<CustomFormFieldRelationshipVo>> search(CustomFormFieldRelationshipSearchRequest requestParam) {
        EntityWrapper<CustomFormFieldRelationship> entityWrapper = new EntityWrapper<CustomFormFieldRelationship>();
        Page<CustomFormFieldRelationship> page = new Page<CustomFormFieldRelationship>(requestParam.getPage(), requestParam.getSize());
        Page<CustomFormFieldRelationship> resultPage = selectPage(page, entityWrapper);
        try {
            PageResponse<CustomFormFieldRelationshipVo> pageResponse = ConvertUtil.getPageResponse(resultPage, CustomFormFieldRelationshipVo.class);
            return ResponseUtil.success(pageResponse);
        } catch (Exception e) {
            LOGGER.error(e.getMessage(), e);
        }

        return ResponseUtil.fail();
    }
}
