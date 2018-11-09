package com.siyueli.platform.activity.client.controller.sportinfomation;


import cn.siyue.platform.base.ResponseData;
import cn.siyue.platform.httplog.annotation.LogAnnotation;
import com.siyueli.platform.activity.client.controller.BaseController;
import com.siyueli.platform.activity.client.service.sportinformation.SportInfomationCategoryClient;
import com.siyueli.platform.activity.common.common.PageResponse;
import com.siyueli.platform.activity.common.request.sportinfomation.*;
import com.siyueli.platform.activity.common.response.sportinfomation.SportInfomationCategoryVo;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@Api(tags = "资讯分类管理接口")
@RestController
@RequestMapping("/sportInfomationCategory")
public class SportInfomationCategoryController extends BaseController {

    @Autowired
    private SportInfomationCategoryClient sportInfomationCategoryClient;

    @ApiOperation(nickname = "addSportInfomationCategory",value = "新增资讯分类接口")
    @LogAnnotation
    @PostMapping("/add")
    public ResponseData add(@Valid @RequestBody SportInfomationCategoryAddRequest requestParam, BindingResult result) {
        //请求的数据参数格式不正确
        if (result.hasErrors()) {
            return getErrorResponse(result);
        }
        return sportInfomationCategoryClient.add(requestParam);
    }

    @ApiOperation(nickname = "updateSportInfomationCategory",value = "更新资讯分类接口")
    @LogAnnotation
    @PostMapping("/update/{id}")
    public ResponseData update(@PathVariable(value = "id") Long id, @Valid @RequestBody SportInfomationCategoryUpdateFrontRequest requestParam, BindingResult result) {
        //请求的数据参数格式不正确
        if (result.hasErrors()) {
            return getErrorResponse(result);
        }

        SportInfomationCategoryUpdateRequest updateRequest = new SportInfomationCategoryUpdateRequest();
        BeanUtils.copyProperties(requestParam, updateRequest);
        updateRequest.setId(id);
        return sportInfomationCategoryClient.update(updateRequest);
    }

    @ApiOperation(nickname = "getSportInfomationCategory",value = "得到资讯分类接口")
    @LogAnnotation
    @GetMapping("/get")
    public ResponseData<SportInfomationCategoryVo> get(@Valid SportInfomationCategoryGetRequest requestParam, BindingResult result) {
        //请求的数据参数格式不正确
        if (result.hasErrors()) {
            return getErrorResponse(result);
        }
        return sportInfomationCategoryClient.get(requestParam);
    }

    @ApiOperation(nickname = "searchSportInfomationCategory",value = "搜索资讯分类接口")
    @LogAnnotation
    @GetMapping("/search")
    public ResponseData<PageResponse<SportInfomationCategoryVo>> search(@Valid SportInfomationCategorySearchRequest requestParam, BindingResult result) {
        //请求的数据参数格式不正确
        if (result.hasErrors()) {
            return getErrorResponse(result);
        }
        return sportInfomationCategoryClient.search(requestParam);
    }

    @ApiOperation(nickname = "deleteSportInfomationCategory",value = "删除资讯分类接口")
    @LogAnnotation
    @PostMapping("/delete/{id}")
    public ResponseData delete(@PathVariable(value = "id") Long id) {
        SportInfomationCategoryDeleteRequest requestParam = new SportInfomationCategoryDeleteRequest();
        requestParam.setId(id);
        return sportInfomationCategoryClient.delete(requestParam);
    }

}
