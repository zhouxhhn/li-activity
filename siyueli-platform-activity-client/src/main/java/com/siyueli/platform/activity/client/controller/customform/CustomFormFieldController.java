package com.siyueli.platform.activity.client.controller.customform;


import cn.siyue.platform.base.ResponseData;
import cn.siyue.platform.httplog.annotation.LogAnnotation;
import com.siyueli.platform.activity.client.controller.BaseController;
import com.siyueli.platform.activity.client.service.customform.CustomFormFieldClient;
import com.siyueli.platform.activity.common.common.PageResponse;
import com.siyueli.platform.activity.common.request.customform.customformfield.*;
import com.siyueli.platform.activity.common.response.customform.CustomFormFieldVo;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@Api(tags = "斯越里_后台_自定义表单_表单字段管理接口")
@RestController
@RequestMapping("/customFormField")
public class CustomFormFieldController extends BaseController {

    @Autowired
    private CustomFormFieldClient customFormFieldClient;

    @ApiOperation(nickname = "addCustomFormField",value = "新增表单字段接口")
    @LogAnnotation
    @PostMapping("/add")
    public ResponseData add(@Valid @RequestBody AddCustomFormFieldRequest requestParam, BindingResult result) {
        //请求的数据参数格式不正确
        if (result.hasErrors()) {
            return getErrorResponse(result);
        }
        return customFormFieldClient.add(requestParam);
    }

    @ApiOperation(nickname = "updateCustomFormField",value = "更新表单字段接口")
    @LogAnnotation
    @PostMapping("/update/{id}")
    public ResponseData update(@PathVariable(value = "id") Long id, @Valid @RequestBody CustomFormFieldUpdateFrontRequest requestParam, BindingResult result) {
        //请求的数据参数格式不正确
        if (result.hasErrors()) {
            return getErrorResponse(result);
        }

        UpdateCustomFormFieldRequest updateRequest = new UpdateCustomFormFieldRequest();
        BeanUtils.copyProperties(requestParam, updateRequest);
        updateRequest.setId(id);
        return customFormFieldClient.update(updateRequest);
    }

    @ApiOperation(nickname = "getCustomFormField",value = "得到表单字段接口")
    @LogAnnotation
    @GetMapping("/get")
    public ResponseData<CustomFormFieldVo> get(@Valid GetCustomFormFieldRequest requestParam, BindingResult result) {
        //请求的数据参数格式不正确
        if (result.hasErrors()) {
            return getErrorResponse(result);
        }
        return customFormFieldClient.get(requestParam);
    }

    @ApiOperation(nickname = "searchCustomFormField",value = "搜索表单字段接口")
    @LogAnnotation
    @GetMapping("/search")
    public ResponseData<PageResponse<CustomFormFieldVo>> search(@Valid SearchCustomFormFieldRequest requestParam, BindingResult result) {
        //请求的数据参数格式不正确
        if (result.hasErrors()) {
            return getErrorResponse(result);
        }
        return customFormFieldClient.search(requestParam);
    }

    @ApiOperation(nickname = "deleteCustomFormField",value = "删除表单字段接口")
    @LogAnnotation
    @PostMapping("/delete/{id}")
    public ResponseData delete(@PathVariable(value = "id") Long id) {
        DeleteCustomFormFieldRequest requestParam = new DeleteCustomFormFieldRequest();
        requestParam.setId(id);
        return customFormFieldClient.delete(requestParam);
    }

}
