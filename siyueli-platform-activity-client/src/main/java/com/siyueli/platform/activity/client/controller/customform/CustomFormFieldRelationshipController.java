package com.siyueli.platform.activity.client.controller.customform;


import cn.siyue.platform.base.ResponseData;
import cn.siyue.platform.httplog.annotation.LogAnnotation;
import com.siyueli.platform.activity.client.controller.BaseController;
import com.siyueli.platform.activity.client.service.customform.CustomFormFieldRelationshipClient;
import com.siyueli.platform.activity.common.common.PageResponse;
import com.siyueli.platform.activity.common.request.customform.*;
import com.siyueli.platform.activity.common.response.customform.CustomFormFieldRelationshipVo;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@Api(tags = "斯越里_后台_自定义表单_表单与字段关系管理接口")
@RestController
@RequestMapping("/customFormFieldRelationship")
public class CustomFormFieldRelationshipController extends BaseController {

    @Autowired
    private CustomFormFieldRelationshipClient customFormFieldRelationshipClient;

    @ApiOperation(nickname = "addCustomFormFieldRelationship",value = "新增表单与字段关系接口")
    @LogAnnotation
    @PostMapping("/add")
    public ResponseData add(@Valid @RequestBody CustomFormFieldRelationshipAddRequest requestParam, BindingResult result) {
        //请求的数据参数格式不正确
        if (result.hasErrors()) {
            return getErrorResponse(result);
        }
        return customFormFieldRelationshipClient.add(requestParam);
    }

    @ApiOperation(nickname = "updateCustomFormFieldRelationship",value = "更新表单与字段关系接口")
    @LogAnnotation
    @PostMapping("/update/{id}")
    public ResponseData update(@PathVariable(value = "id") Long id, @Valid @RequestBody CustomFormFieldRelationshipUpdateFrontRequest requestParam, BindingResult result) {
        //请求的数据参数格式不正确
        if (result.hasErrors()) {
            return getErrorResponse(result);
        }

        CustomFormFieldRelationshipUpdateRequest updateRequest = new CustomFormFieldRelationshipUpdateRequest();
        BeanUtils.copyProperties(requestParam, updateRequest);
        updateRequest.setId(id);
        return customFormFieldRelationshipClient.update(updateRequest);
    }

    @ApiOperation(nickname = "getCustomFormFieldRelationship",value = "得到表单与字段关系接口")
    @LogAnnotation
    @GetMapping("/get")
    public ResponseData<CustomFormFieldRelationshipVo> get(@Valid CustomFormFieldRelationshipGetRequest requestParam, BindingResult result) {
        //请求的数据参数格式不正确
        if (result.hasErrors()) {
            return getErrorResponse(result);
        }
        return customFormFieldRelationshipClient.get(requestParam);
    }

    @ApiOperation(nickname = "searchCustomFormFieldRelationship",value = "搜索表单与字段关系接口")
    @LogAnnotation
    @GetMapping("/search")
    public ResponseData<PageResponse<CustomFormFieldRelationshipVo>> search(@Valid CustomFormFieldRelationshipSearchRequest requestParam, BindingResult result) {
        //请求的数据参数格式不正确
        if (result.hasErrors()) {
            return getErrorResponse(result);
        }
        return customFormFieldRelationshipClient.search(requestParam);
    }

    @ApiOperation(nickname = "deleteCustomFormFieldRelationship",value = "删除表单与字段关系接口")
    @LogAnnotation
    @PostMapping("/delete/{id}")
    public ResponseData delete(@PathVariable(value = "id") Long id) {
        CustomFormFieldRelationshipDeleteRequest requestParam = new CustomFormFieldRelationshipDeleteRequest();
        requestParam.setId(id);
        return customFormFieldRelationshipClient.delete(requestParam);
    }

}
