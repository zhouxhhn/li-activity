package com.siyueli.platform.activity.client.controller.sportactivity;


import cn.siyue.platform.base.ResponseData;
import cn.siyue.platform.httplog.annotation.LogAnnotation;
import com.siyueli.platform.activity.client.controller.BaseController;
import com.siyueli.platform.activity.client.service.sportactivity.SportActivityRefundOrderClient;
import com.siyueli.platform.activity.common.common.PageResponse;
import com.siyueli.platform.activity.common.request.sportactivity.*;
import com.siyueli.platform.activity.common.response.sportactivity.SportActivityRefundOrderVo;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@Api(tags = "活动报名退款单管理接口")
@RestController
@RequestMapping("/sportActivityRefundOrder")
public class SportActivityRefundOrderController extends BaseController {

    @Autowired
    private SportActivityRefundOrderClient sportActivityRefundOrderClient;

    @ApiOperation(nickname = "addSportActivityRefundOrder",value = "新增活动报名退款单接口")
    @LogAnnotation
    @PostMapping("/add")
    public ResponseData add(@Valid @RequestBody SportActivityRefundOrderAddRequest requestParam, BindingResult result) {
        //请求的数据参数格式不正确
        if (result.hasErrors()) {
            return getErrorResponse(result);
        }
        return sportActivityRefundOrderClient.add(requestParam);
    }

    @ApiOperation(nickname = "updateSportActivityRefundOrder",value = "更新活动报名退款单接口")
    @LogAnnotation
    @PostMapping("/update/{id}")
    public ResponseData update(@PathVariable(value = "id") Long id, @Valid @RequestBody SportActivityRefundOrderUpdateFrontRequest requestParam, BindingResult result) {
        //请求的数据参数格式不正确
        if (result.hasErrors()) {
            return getErrorResponse(result);
        }

        SportActivityRefundOrderUpdateRequest updateRequest = new SportActivityRefundOrderUpdateRequest();
        BeanUtils.copyProperties(requestParam, updateRequest);
        updateRequest.setId(id);
        return sportActivityRefundOrderClient.update(updateRequest);
    }

    @ApiOperation(nickname = "getSportActivityRefundOrder",value = "得到活动报名退款单接口")
    @LogAnnotation
    @GetMapping("/get")
    public ResponseData<SportActivityRefundOrderVo> get(@Valid SportActivityRefundOrderGetRequest requestParam, BindingResult result) {
        //请求的数据参数格式不正确
        if (result.hasErrors()) {
            return getErrorResponse(result);
        }
        return sportActivityRefundOrderClient.get(requestParam);
    }

    @ApiOperation(nickname = "searchSportActivityRefundOrder",value = "搜索活动报名退款单接口")
    @LogAnnotation
    @GetMapping("/search")
    public ResponseData<PageResponse<SportActivityRefundOrderVo>> search(@Valid SportActivityRefundOrderSearchRequest requestParam, BindingResult result) {
        //请求的数据参数格式不正确
        if (result.hasErrors()) {
            return getErrorResponse(result);
        }
        return sportActivityRefundOrderClient.search(requestParam);
    }

    @ApiOperation(nickname = "deleteSportActivityRefundOrder",value = "删除活动报名退款单接口")
    @LogAnnotation
    @PostMapping("/delete/{id}")
    public ResponseData delete(@PathVariable(value = "id") Long id) {
        SportActivityRefundOrderDeleteRequest requestParam = new SportActivityRefundOrderDeleteRequest();
        requestParam.setId(id);
        return sportActivityRefundOrderClient.delete(requestParam);
    }

}
