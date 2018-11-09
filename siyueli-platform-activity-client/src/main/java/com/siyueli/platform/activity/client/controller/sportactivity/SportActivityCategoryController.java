package com.siyueli.platform.activity.client.controller.sportactivity;


import cn.siyue.platform.base.ResponseData;
import cn.siyue.platform.httplog.annotation.LogAnnotation;
import com.siyueli.platform.activity.client.controller.BaseController;
import com.siyueli.platform.activity.client.service.sportactivity.SportActivityCategoryClient;
import com.siyueli.platform.activity.common.common.PageResponse;
import com.siyueli.platform.activity.common.request.sportactivity.*;
import com.siyueli.platform.activity.common.response.sportactivity.SportActivityCategoryVo;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@Api(tags = "活动分类管理接口")
@RestController
@RequestMapping("/sportActivityCategory")
public class SportActivityCategoryController extends BaseController {

    @Autowired
    private SportActivityCategoryClient sportActivityCategoryClient;

    @ApiOperation(nickname = "addSportActivityCategory",value = "新增活动分类接口")
    @LogAnnotation
    @PostMapping("/add")
    public ResponseData add(@Valid @RequestBody SportActivityCategoryAddRequest requestParam, BindingResult result) {
        //请求的数据参数格式不正确
        if (result.hasErrors()) {
            return getErrorResponse(result);
        }
        return sportActivityCategoryClient.add(requestParam);
    }

    @ApiOperation(nickname = "updateSportActivityCategory",value = "更新活动分类接口")
    @LogAnnotation
    @PostMapping("/update/{id}")
    public ResponseData update(@PathVariable(value = "id") Long id, @Valid @RequestBody SportActivityCategoryUpdateFrontRequest requestParam, BindingResult result) {
        //请求的数据参数格式不正确
        if (result.hasErrors()) {
            return getErrorResponse(result);
        }

        SportActivityCategoryUpdateRequest updateRequest = new SportActivityCategoryUpdateRequest();
        BeanUtils.copyProperties(requestParam, updateRequest);
        updateRequest.setId(id);
        return sportActivityCategoryClient.update(updateRequest);
    }

    @ApiOperation(nickname = "getSportActivityCategory",value = "得到活动分类接口")
    @LogAnnotation
    @GetMapping("/get")
    public ResponseData<SportActivityCategoryVo> get(@Valid SportActivityCategoryGetRequest requestParam, BindingResult result) {
        //请求的数据参数格式不正确
        if (result.hasErrors()) {
            return getErrorResponse(result);
        }
        return sportActivityCategoryClient.get(requestParam);
    }

    @ApiOperation(nickname = "searchSportActivityCategory",value = "搜索活动分类接口")
    @LogAnnotation
    @GetMapping("/search")
    public ResponseData<PageResponse<SportActivityCategoryVo>> search(@Valid SportActivityCategorySearchRequest requestParam, BindingResult result) {
        //请求的数据参数格式不正确
        if (result.hasErrors()) {
            return getErrorResponse(result);
        }
        return sportActivityCategoryClient.search(requestParam);
    }

    @ApiOperation(nickname = "deleteSportActivityCategory",value = "删除活动分类接口")
    @LogAnnotation
    @PostMapping("/delete/{id}")
    public ResponseData delete(@PathVariable(value = "id") Long id) {
        SportActivityCategoryDeleteRequest requestParam = new SportActivityCategoryDeleteRequest();
        requestParam.setId(id);
        return sportActivityCategoryClient.delete(requestParam);
    }

}
