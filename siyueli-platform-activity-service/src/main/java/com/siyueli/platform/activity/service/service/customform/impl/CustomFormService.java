package com.siyueli.platform.activity.service.service.customform.impl;

import cn.siyue.platform.base.ResponseData;
import cn.siyue.platform.util.ResponseUtil;
import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.plugins.Page;
import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import com.siyueli.platform.activity.common.common.PageResponse;
import com.siyueli.platform.activity.common.entity.customform.CustomForm;
import com.siyueli.platform.activity.common.entity.customform.CustomFormField;
import com.siyueli.platform.activity.common.entity.customform.CustomFormFieldRelationship;
import com.siyueli.platform.activity.common.entity.sportactivity.SportActivity;
import com.siyueli.platform.activity.common.request.customform.CustomFormGetRequest;
import com.siyueli.platform.activity.common.request.customform.CustomFormSearchRequest;
import com.siyueli.platform.activity.common.response.customform.CustomFormFieldRelationshipVo;
import com.siyueli.platform.activity.common.response.customform.CustomFormFieldVo;
import com.siyueli.platform.activity.common.response.customform.CustomFormVo;
import com.siyueli.platform.activity.common.response.sportactivity.SportActivityVo;
import com.siyueli.platform.activity.service.mapper.customform.CustomFormMapper;
import com.siyueli.platform.activity.service.service.customform.CustomFormFieldRelationshipServiceContract;
import com.siyueli.platform.activity.service.service.customform.CustomFormFieldServiceContract;
import com.siyueli.platform.activity.service.service.customform.CustomFormServiceContract;
import com.siyueli.platform.activity.service.util.ConvertUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * <p>
 * 表单 服务实现类
 * </p>
 *
 * @author Sipin ERP Development Team
 */
@Primary
@Service
public class CustomFormService extends ServiceImpl<CustomFormMapper, CustomForm> implements CustomFormServiceContract {

    private static final Logger LOGGER = LoggerFactory.getLogger(CustomFormService.class);

    @Autowired
    private CustomFormMapper customFormMapper;

    @Autowired
    private CustomFormFieldServiceContract customFormFieldServiceContract;

    @Autowired
    private CustomFormFieldRelationshipServiceContract customFormFieldRelationshipServiceContract;

    @Override
    public ResponseData<PageResponse<CustomFormVo>> search(CustomFormSearchRequest requestParam) {
        Page<CustomFormVo> page = new Page<CustomFormVo>(requestParam.getPage(), requestParam.getSize());
        List<CustomFormVo> list = customFormMapper.search(page);

        PageResponse<CustomFormVo> pageResponse = new PageResponse<CustomFormVo>();
        pageResponse.setRecords(list);
        pageResponse.setPages(page.getPages());
        pageResponse.setTotal(page.getTotal());
        pageResponse.setCurrent(page.getCurrent());
        pageResponse.setSize(page.getSize());

        return ResponseUtil.success(pageResponse);
    }

    @Override
    public CustomFormVo get(CustomFormGetRequest requestParam) {
        CustomForm entity = selectById(requestParam.getId());
        CustomFormVo cffVo = null;
        if (entity != null) {
            cffVo = new CustomFormVo();
            BeanUtils.copyProperties(entity, cffVo);

            EntityWrapper<CustomFormFieldRelationship> entityWrapper = new EntityWrapper<CustomFormFieldRelationship>();
            entityWrapper.eq("form_id", entity.getId());
            List<CustomFormFieldRelationship> list = customFormFieldRelationshipServiceContract.selectList(entityWrapper);
            if (list != null && list.size() > 0) {
                List<Long> fieldIdList = new ArrayList<Long>();
                for (CustomFormFieldRelationship cffrs : list) {
                    fieldIdList.add(cffrs.getFieldId());
                }

                List<CustomFormField> customFormFieldList = customFormFieldServiceContract.selectBatchIds(fieldIdList);
                try {
                    List<CustomFormFieldVo> fieldVoList = ConvertUtil.convertList(CustomFormFieldVo.class, customFormFieldList);
                    cffVo.setFieldList(fieldVoList);
                } catch (Exception e) {
                    LOGGER.error(e.getMessage(), e);
                    throw new RuntimeException();
                }
            }

        }
        return cffVo;
    }
}
