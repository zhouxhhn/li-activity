package com.siyueli.platform.activity.client.controller.sportactivity;


import cn.siyue.platform.base.ResponseData;
import cn.siyue.platform.httplog.annotation.LogAnnotation;
import com.siyueli.platform.activity.client.controller.BaseController;
import com.siyueli.platform.activity.client.service.sportactivity.SportActivityTeamClient;
import com.siyueli.platform.activity.common.common.PageResponse;
import com.siyueli.platform.activity.common.request.sportactivity.*;
import com.siyueli.platform.activity.common.response.sportactivity.SportActivityTeamVo;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@Api(tags = "活动队伍管理接口")
@RestController
@RequestMapping("/sportActivityTeam")
public class SportActivityTeamController extends BaseController {

    @Autowired
    private SportActivityTeamClient sportActivityTeamClient;

    @ApiOperation(nickname = "addSportActivityTeam",value = "新增活动队伍接口")
    @LogAnnotation
    @PostMapping("/add")
    public ResponseData add(@Valid @RequestBody SportActivityTeamAddRequest requestParam, BindingResult result) {
        //请求的数据参数格式不正确
        if (result.hasErrors()) {
            return getErrorResponse(result);
        }
        return sportActivityTeamClient.add(requestParam);
    }

    @ApiOperation(nickname = "updateSportActivityTeam",value = "更新活动队伍接口")
    @LogAnnotation
    @PostMapping("/update/{id}")
    public ResponseData update(@PathVariable(value = "id") Long id, @Valid @RequestBody SportActivityTeamUpdateFrontRequest requestParam, BindingResult result) {
        //请求的数据参数格式不正确
        if (result.hasErrors()) {
            return getErrorResponse(result);
        }

        SportActivityTeamUpdateRequest updateRequest = new SportActivityTeamUpdateRequest();
        BeanUtils.copyProperties(requestParam, updateRequest);
        updateRequest.setId(id);
        return sportActivityTeamClient.update(updateRequest);
    }

    @ApiOperation(nickname = "getSportActivityTeam",value = "得到活动队伍接口")
    @LogAnnotation
    @GetMapping("/get")
    public ResponseData<SportActivityTeamVo> get(@Valid SportActivityTeamGetRequest requestParam, BindingResult result) {
        //请求的数据参数格式不正确
        if (result.hasErrors()) {
            return getErrorResponse(result);
        }
        return sportActivityTeamClient.get(requestParam);
    }

    @ApiOperation(nickname = "searchSportActivityTeam",value = "搜索活动队伍接口")
    @LogAnnotation
    @GetMapping("/search")
    public ResponseData<PageResponse<SportActivityTeamVo>> search(@Valid SportActivityTeamSearchRequest requestParam, BindingResult result) {
        //请求的数据参数格式不正确
        if (result.hasErrors()) {
            return getErrorResponse(result);
        }
        return sportActivityTeamClient.search(requestParam);
    }

    @ApiOperation(nickname = "deleteSportActivityTeam",value = "删除活动队伍接口")
    @LogAnnotation
    @PostMapping("/delete/{id}")
    public ResponseData delete(@PathVariable(value = "id") Long id) {
        SportActivityTeamDeleteRequest requestParam = new SportActivityTeamDeleteRequest();
        requestParam.setId(id);
        return sportActivityTeamClient.delete(requestParam);
    }

}
