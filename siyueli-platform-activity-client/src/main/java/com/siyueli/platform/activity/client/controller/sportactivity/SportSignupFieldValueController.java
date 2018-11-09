package com.siyueli.platform.activity.client.controller.sportactivity;


import cn.siyue.platform.base.ResponseData;
import cn.siyue.platform.httplog.annotation.LogAnnotation;
import com.siyueli.platform.activity.client.controller.BaseController;
import com.siyueli.platform.activity.client.service.sportactivity.SportSignupFieldValueClient;
import com.siyueli.platform.activity.common.common.PageResponse;
import com.siyueli.platform.activity.common.request.sportactivity.*;
import com.siyueli.platform.activity.common.response.sportactivity.SportSignupFieldValueVo;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@Api(tags = "活动报名字段值管理接口")
@RestController
@RequestMapping("/sportSignupFieldValue")
public class SportSignupFieldValueController extends BaseController {

    @Autowired
    private SportSignupFieldValueClient sportSignupFieldValueClient;

    @ApiOperation(nickname = "addSportSignupFieldValue",value = "新增活动报名字段值接口")
    @LogAnnotation
    @PostMapping("/add")
    public ResponseData add(@Valid @RequestBody SportSignupFieldValueAddRequest requestParam, BindingResult result) {
        //请求的数据参数格式不正确
        if (result.hasErrors()) {
            return getErrorResponse(result);
        }
        return sportSignupFieldValueClient.add(requestParam);
    }

    @ApiOperation(nickname = "updateSportSignupFieldValue",value = "更新活动报名字段值接口")
    @LogAnnotation
    @PostMapping("/update/{id}")
    public ResponseData update(@PathVariable(value = "id") Long id, @Valid @RequestBody SportSignupFieldValueUpdateFrontRequest requestParam, BindingResult result) {
        //请求的数据参数格式不正确
        if (result.hasErrors()) {
            return getErrorResponse(result);
        }

        SportSignupFieldValueUpdateRequest updateRequest = new SportSignupFieldValueUpdateRequest();
        BeanUtils.copyProperties(requestParam, updateRequest);
        updateRequest.setId(id);
        return sportSignupFieldValueClient.update(updateRequest);
    }

    @ApiOperation(nickname = "getSportSignupFieldValue",value = "得到活动报名字段值接口")
    @LogAnnotation
    @GetMapping("/get")
    public ResponseData<SportSignupFieldValueVo> get(@Valid SportSignupFieldValueGetRequest requestParam, BindingResult result) {
        //请求的数据参数格式不正确
        if (result.hasErrors()) {
            return getErrorResponse(result);
        }
        return sportSignupFieldValueClient.get(requestParam);
    }

    @ApiOperation(nickname = "searchSportSignupFieldValue",value = "搜索活动报名字段值接口")
    @LogAnnotation
    @GetMapping("/search")
    public ResponseData<PageResponse<SportSignupFieldValueVo>> search(@Valid SportSignupFieldValueSearchRequest requestParam, BindingResult result) {
        //请求的数据参数格式不正确
        if (result.hasErrors()) {
            return getErrorResponse(result);
        }
        return sportSignupFieldValueClient.search(requestParam);
    }

    @ApiOperation(nickname = "deleteSportSignupFieldValue",value = "删除活动报名字段值接口")
    @LogAnnotation
    @PostMapping("/delete/{id}")
    public ResponseData delete(@PathVariable(value = "id") Long id) {
        SportSignupFieldValueDeleteRequest requestParam = new SportSignupFieldValueDeleteRequest();
        requestParam.setId(id);
        return sportSignupFieldValueClient.delete(requestParam);
    }

}
