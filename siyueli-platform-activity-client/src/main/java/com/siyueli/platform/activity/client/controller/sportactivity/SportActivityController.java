package com.siyueli.platform.activity.client.controller.sportactivity;


import cn.siyue.platform.base.ResponseData;
import cn.siyue.platform.httplog.annotation.LogAnnotation;
import com.siyueli.platform.activity.client.controller.BaseController;
import com.siyueli.platform.activity.client.service.sportactivity.SportActivityClient;
import com.siyueli.platform.activity.common.common.PageResponse;
import com.siyueli.platform.activity.common.request.sportactivity.*;
import com.siyueli.platform.activity.common.response.sportactivity.SportActivityVo;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@Api(tags = "体育活动管理接口")
@RestController
@RequestMapping("/sportActivity")
public class SportActivityController extends BaseController {

    @Autowired
    private SportActivityClient sportActivityClient;

    @ApiOperation(nickname = "addSportActivity",value = "新增体育活动接口")
    @LogAnnotation
    @PostMapping("/add")
    public ResponseData add(@Valid @RequestBody SportActivityAddRequest requestParam, BindingResult result) {
        //请求的数据参数格式不正确
        if (result.hasErrors()) {
            return getErrorResponse(result);
        }
        return sportActivityClient.add(requestParam);
    }

    @ApiOperation(nickname = "updateSportActivity",value = "更新体育活动接口")
    @LogAnnotation
    @PostMapping("/update/{id}")
    public ResponseData update(@PathVariable(value = "id") Long id, @Valid @RequestBody SportActivityUpdateFrontRequest requestParam, BindingResult result) {
        //请求的数据参数格式不正确
        if (result.hasErrors()) {
            return getErrorResponse(result);
        }

        SportActivityUpdateRequest updateRequest = new SportActivityUpdateRequest();
        BeanUtils.copyProperties(requestParam, updateRequest);
        updateRequest.setId(id);
        return sportActivityClient.update(updateRequest);
    }

    @ApiOperation(nickname = "getSportActivity",value = "得到体育活动接口")
    @LogAnnotation
    @GetMapping("/get")
    public ResponseData<SportActivityVo> get(@Valid SportActivityGetRequest requestParam, BindingResult result) {
        //请求的数据参数格式不正确
        if (result.hasErrors()) {
            return getErrorResponse(result);
        }
        return sportActivityClient.get(requestParam);
    }

    @ApiOperation(nickname = "searchSportActivity",value = "搜索体育活动接口")
    @LogAnnotation
    @GetMapping("/search")
    public ResponseData<PageResponse<SportActivityVo>> search(@Valid SportActivitySearchRequest requestParam, BindingResult result) {
        //请求的数据参数格式不正确
        if (result.hasErrors()) {
            return getErrorResponse(result);
        }
        return sportActivityClient.search(requestParam);
    }

    @ApiOperation(nickname = "deleteSportActivity",value = "删除体育活动接口")
    @LogAnnotation
    @PostMapping("/delete/{id}")
    public ResponseData delete(@PathVariable(value = "id") Long id) {
        SportActivityDeleteRequest requestParam = new SportActivityDeleteRequest();
        requestParam.setId(id);
        return sportActivityClient.delete(requestParam);
    }

}
