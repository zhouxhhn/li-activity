package com.siyueli.platform.activity.client.controller.sportactivity;


import cn.siyue.platform.base.ResponseData;
import cn.siyue.platform.httplog.annotation.LogAnnotation;
import com.siyueli.platform.activity.client.controller.BaseController;
import com.siyueli.platform.activity.client.service.sportactivity.SportActivityOrderClient;
import com.siyueli.platform.activity.common.common.PageResponse;
import com.siyueli.platform.activity.common.request.sportactivity.*;
import com.siyueli.platform.activity.common.response.sportactivity.SportActivityOrderVo;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@Api(tags = "活动报名订单管理接口")
@RestController
@RequestMapping("/sportActivityOrder")
public class SportActivityOrderController extends BaseController {

    @Autowired
    private SportActivityOrderClient sportActivityOrderClient;

    @ApiOperation(nickname = "addSportActivityOrder",value = "新增活动报名订单接口")
    @LogAnnotation
    @PostMapping("/add")
    public ResponseData add(@Valid @RequestBody SportActivityOrderAddRequest requestParam, BindingResult result) {
        //请求的数据参数格式不正确
        if (result.hasErrors()) {
            return getErrorResponse(result);
        }
        return sportActivityOrderClient.add(requestParam);
    }

    @ApiOperation(nickname = "updateSportActivityOrder",value = "更新活动报名订单接口")
    @LogAnnotation
    @PostMapping("/update/{id}")
    public ResponseData update(@PathVariable(value = "id") Long id, @Valid @RequestBody SportActivityOrderUpdateFrontRequest requestParam, BindingResult result) {
        //请求的数据参数格式不正确
        if (result.hasErrors()) {
            return getErrorResponse(result);
        }

        SportActivityOrderUpdateRequest updateRequest = new SportActivityOrderUpdateRequest();
        BeanUtils.copyProperties(requestParam, updateRequest);
        updateRequest.setId(id);
        return sportActivityOrderClient.update(updateRequest);
    }

    @ApiOperation(nickname = "getSportActivityOrder",value = "得到活动报名订单接口")
    @LogAnnotation
    @GetMapping("/get")
    public ResponseData<SportActivityOrderVo> get(@Valid SportActivityOrderGetRequest requestParam, BindingResult result) {
        //请求的数据参数格式不正确
        if (result.hasErrors()) {
            return getErrorResponse(result);
        }
        return sportActivityOrderClient.get(requestParam);
    }

    @ApiOperation(nickname = "searchSportActivityOrder",value = "搜索活动报名订单接口")
    @LogAnnotation
    @GetMapping("/search")
    public ResponseData<PageResponse<SportActivityOrderVo>> search(@Valid SportActivityOrderSearchRequest requestParam, BindingResult result) {
        //请求的数据参数格式不正确
        if (result.hasErrors()) {
            return getErrorResponse(result);
        }
        return sportActivityOrderClient.search(requestParam);
    }

    @ApiOperation(nickname = "deleteSportActivityOrder",value = "删除活动报名订单接口")
    @LogAnnotation
    @PostMapping("/delete/{id}")
    public ResponseData delete(@PathVariable(value = "id") Long id) {
        SportActivityOrderDeleteRequest requestParam = new SportActivityOrderDeleteRequest();
        requestParam.setId(id);
        return sportActivityOrderClient.delete(requestParam);
    }

}
