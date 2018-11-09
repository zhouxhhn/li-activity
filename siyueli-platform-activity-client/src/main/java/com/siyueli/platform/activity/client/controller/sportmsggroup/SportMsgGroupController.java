package com.siyueli.platform.activity.client.controller.sportmsggroup;


import cn.siyue.platform.base.ResponseData;
import cn.siyue.platform.httplog.annotation.LogAnnotation;
import com.siyueli.platform.activity.client.controller.BaseController;
import com.siyueli.platform.activity.client.service.sportmsggroup.SportMsgGroupClient;
import com.siyueli.platform.activity.common.common.PageResponse;
import com.siyueli.platform.activity.common.request.sportmsggroup.*;
import com.siyueli.platform.activity.common.response.sportmsggroup.SportMsgGroupVo;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@Api(tags = "消息用户组管理接口")
@RestController
@RequestMapping("/sportMsgGroup")
public class SportMsgGroupController extends BaseController {

    @Autowired
    private SportMsgGroupClient sportMsgGroupClient;

    @ApiOperation(nickname = "addSportMsgGroup",value = "新增消息用户组接口")
    @LogAnnotation
    @PostMapping("/add")
    public ResponseData add(@Valid @RequestBody SportMsgGroupAddRequest requestParam, BindingResult result) {
        //请求的数据参数格式不正确
        if (result.hasErrors()) {
            return getErrorResponse(result);
        }
        return sportMsgGroupClient.add(requestParam);
    }

    @ApiOperation(nickname = "updateSportMsgGroup",value = "更新消息用户组接口")
    @LogAnnotation
    @PostMapping("/update/{id}")
    public ResponseData update(@PathVariable(value = "id") Long id, @Valid @RequestBody SportMsgGroupUpdateFrontRequest requestParam, BindingResult result) {
        //请求的数据参数格式不正确
        if (result.hasErrors()) {
            return getErrorResponse(result);
        }

        SportMsgGroupUpdateRequest updateRequest = new SportMsgGroupUpdateRequest();
        BeanUtils.copyProperties(requestParam, updateRequest);
        updateRequest.setId(id);
        return sportMsgGroupClient.update(updateRequest);
    }

    @ApiOperation(nickname = "getSportMsgGroup",value = "得到消息用户组接口")
    @LogAnnotation
    @GetMapping("/get")
    public ResponseData<SportMsgGroupVo> get(@Valid SportMsgGroupGetRequest requestParam, BindingResult result) {
        //请求的数据参数格式不正确
        if (result.hasErrors()) {
            return getErrorResponse(result);
        }
        return sportMsgGroupClient.get(requestParam);
    }

    @ApiOperation(nickname = "searchSportMsgGroup",value = "搜索消息用户组接口")
    @LogAnnotation
    @GetMapping("/search")
    public ResponseData<PageResponse<SportMsgGroupVo>> search(@Valid SportMsgGroupSearchRequest requestParam, BindingResult result) {
        //请求的数据参数格式不正确
        if (result.hasErrors()) {
            return getErrorResponse(result);
        }
        return sportMsgGroupClient.search(requestParam);
    }

    @ApiOperation(nickname = "deleteSportMsgGroup",value = "删除消息用户组接口")
    @LogAnnotation
    @PostMapping("/delete/{id}")
    public ResponseData delete(@PathVariable(value = "id") Long id) {
        SportMsgGroupDeleteRequest requestParam = new SportMsgGroupDeleteRequest();
        requestParam.setId(id);
        return sportMsgGroupClient.delete(requestParam);
    }

}
