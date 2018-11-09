package com.siyueli.platform.activity.client.controller.customform;


import cn.siyue.platform.base.ResponseData;
import cn.siyue.platform.httplog.annotation.LogAnnotation;
import com.siyueli.platform.activity.client.controller.BaseController;
import com.siyueli.platform.activity.client.service.customform.CustomFormCategoryClient;
import com.siyueli.platform.activity.common.common.PageResponse;
import com.siyueli.platform.activity.common.request.customform.customformcategory.*;
import com.siyueli.platform.activity.common.response.customform.CustomFormCategoryVo;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@Api(tags = "斯越里_后台_自定义表单_表单分类管理接口")
@RestController
@RequestMapping("/customFormCategory")
public class CustomFormCategoryController extends BaseController {

    @Autowired
    private CustomFormCategoryClient customFormCategoryClient;

    @ApiOperation(nickname = "addCustomFormCategory",value = "新增表单分类接口")
    @LogAnnotation
    @PostMapping("/add")
    public ResponseData add(@Valid @RequestBody AddCustomFormCategoryRequest requestParam, BindingResult result) {
        //请求的数据参数格式不正确
        if (result.hasErrors()) {
            return getErrorResponse(result);
        }
        return customFormCategoryClient.add(requestParam);
    }

    @ApiOperation(nickname = "updateCustomFormCategory",value = "更新表单分类接口")
    @LogAnnotation
    @PostMapping("/update/{id}")
    public ResponseData update(@PathVariable(value = "id") Long id, @Valid @RequestBody CustomFormCategoryUpdateFrontRequest requestParam, BindingResult result) {
        //请求的数据参数格式不正确
        if (result.hasErrors()) {
            return getErrorResponse(result);
        }

        UpdateCustomFormCategoryRequest updateRequest = new UpdateCustomFormCategoryRequest();
        BeanUtils.copyProperties(requestParam, updateRequest);
        updateRequest.setId(id);
        return customFormCategoryClient.update(updateRequest);
    }

    @ApiOperation(nickname = "getCustomFormCategory",value = "得到表单分类接口")
    @LogAnnotation
    @GetMapping("/get")
    public ResponseData<CustomFormCategoryVo> get(@Valid GetCustomFormCategoryRequest requestParam, BindingResult result) {
        //请求的数据参数格式不正确
        if (result.hasErrors()) {
            return getErrorResponse(result);
        }
        return customFormCategoryClient.get(requestParam);
    }

    @ApiOperation(nickname = "searchCustomFormCategory",value = "搜索表单分类接口")
    @LogAnnotation
    @GetMapping("/search")
    public ResponseData<PageResponse<CustomFormCategoryVo>> search(@Valid SearchCustomFormCategoryRequest requestParam, BindingResult result) {
        //请求的数据参数格式不正确
        if (result.hasErrors()) {
            return getErrorResponse(result);
        }
        return customFormCategoryClient.search(requestParam);
    }

    @ApiOperation(nickname = "deleteCustomFormCategory",value = "删除表单分类接口")
    @LogAnnotation
    @PostMapping("/delete/{id}")
    public ResponseData delete(@PathVariable(value = "id") Long id) {
        DeleteCustomFormCategoryRequest requestParam = new DeleteCustomFormCategoryRequest();
        requestParam.setId(id);
        return customFormCategoryClient.delete(requestParam);
    }

}
