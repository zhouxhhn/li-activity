package com.siyueli.platform.activity.client.controller.customform;


import cn.siyue.platform.base.ResponseData;
import cn.siyue.platform.httplog.annotation.LogAnnotation;
import com.siyueli.platform.activity.client.controller.BaseController;
import com.siyueli.platform.activity.client.service.customform.CustomFormClient;
import com.siyueli.platform.activity.common.common.PageResponse;
import com.siyueli.platform.activity.common.request.customform.*;
import com.siyueli.platform.activity.common.response.customform.CustomFormVo;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@Api(tags = "斯越里_后台_自定义表单_表单管理接口")
@RestController
@RequestMapping("/customForm")
public class CustomFormController extends BaseController {

    @Autowired
    private CustomFormClient customFormClient;

    @ApiOperation(nickname = "addCustomForm",value = "新增表单接口")
    @LogAnnotation
    @PostMapping("/add")
    public ResponseData add(@Valid @RequestBody CustomFormAddRequest requestParam, BindingResult result) {
        //请求的数据参数格式不正确
        if (result.hasErrors()) {
            return getErrorResponse(result);
        }
        return customFormClient.add(requestParam);
    }

    @ApiOperation(nickname = "updateCustomForm",value = "更新表单接口")
    @LogAnnotation
    @PostMapping("/update/{id}")
    public ResponseData update(@PathVariable(value = "id") Long id, @Valid @RequestBody CustomFormUpdateFrontRequest requestParam, BindingResult result) {
        //请求的数据参数格式不正确
        if (result.hasErrors()) {
            return getErrorResponse(result);
        }

        CustomFormUpdateRequest updateRequest = new CustomFormUpdateRequest();
        BeanUtils.copyProperties(requestParam, updateRequest);
        updateRequest.setId(id);
        return customFormClient.update(updateRequest);
    }

    @ApiOperation(nickname = "getCustomForm",value = "得到表单接口")
    @LogAnnotation
    @GetMapping("/get")
    public ResponseData<CustomFormVo> get(@Valid CustomFormGetRequest requestParam, BindingResult result) {
        //请求的数据参数格式不正确
        if (result.hasErrors()) {
            return getErrorResponse(result);
        }
        return customFormClient.get(requestParam);
    }

    @ApiOperation(nickname = "searchCustomForm",value = "搜索表单接口")
    @LogAnnotation
    @GetMapping("/search")
    public ResponseData<PageResponse<CustomFormVo>> search(@Valid CustomFormSearchRequest requestParam, BindingResult result) {
        //请求的数据参数格式不正确
        if (result.hasErrors()) {
            return getErrorResponse(result);
        }
        return customFormClient.search(requestParam);
    }

    @ApiOperation(nickname = "deleteCustomForm",value = "删除表单接口")
    @LogAnnotation
    @PostMapping("/delete/{id}")
    public ResponseData delete(@PathVariable(value = "id") Long id) {
        CustomFormDeleteRequest requestParam = new CustomFormDeleteRequest();
        requestParam.setId(id);
        return customFormClient.delete(requestParam);
    }

}
