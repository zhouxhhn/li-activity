package com.siyueli.platform.activity.client.controller.sportinfomation;


import cn.siyue.platform.base.ResponseData;
import cn.siyue.platform.httplog.annotation.LogAnnotation;
import com.siyueli.platform.activity.client.controller.BaseController;
import com.siyueli.platform.activity.client.service.sportinformation.SportInformationClient;
import com.siyueli.platform.activity.common.common.PageResponse;
import com.siyueli.platform.activity.common.request.sportinfomation.*;
import com.siyueli.platform.activity.common.response.sportinfomation.SportInformationVo;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@Api(tags = "资讯管理接口")
@RestController
@RequestMapping("/sportInformation")
public class SportInformationController extends BaseController {

    @Autowired
    private SportInformationClient sportInformationClient;

    @ApiOperation(nickname = "addSportInformation",value = "新增资讯接口")
    @LogAnnotation
    @PostMapping("/add")
    public ResponseData add(@Valid @RequestBody SportInformationAddRequest requestParam, BindingResult result) {
        //请求的数据参数格式不正确
        if (result.hasErrors()) {
            return getErrorResponse(result);
        }
        return sportInformationClient.add(requestParam);
    }

    @ApiOperation(nickname = "updateSportInformation",value = "更新资讯接口")
    @LogAnnotation
    @PostMapping("/update/{id}")
    public ResponseData update(@PathVariable(value = "id") Long id, @Valid @RequestBody SportInformationUpdateFrontRequest requestParam, BindingResult result) {
        //请求的数据参数格式不正确
        if (result.hasErrors()) {
            return getErrorResponse(result);
        }

        SportInformationUpdateRequest updateRequest = new SportInformationUpdateRequest();
        BeanUtils.copyProperties(requestParam, updateRequest);
        updateRequest.setId(id);
        return sportInformationClient.update(updateRequest);
    }

    @ApiOperation(nickname = "getSportInformation",value = "得到资讯接口")
    @LogAnnotation
    @GetMapping("/get")
    public ResponseData<SportInformationVo> get(@Valid SportInformationGetRequest requestParam, BindingResult result) {
        //请求的数据参数格式不正确
        if (result.hasErrors()) {
            return getErrorResponse(result);
        }
        return sportInformationClient.get(requestParam);
    }

    @ApiOperation(nickname = "searchSportInformation",value = "搜索资讯接口")
    @LogAnnotation
    @GetMapping("/search")
    public ResponseData<PageResponse<SportInformationVo>> search(@Valid SportInformationSearchRequest requestParam, BindingResult result) {
        //请求的数据参数格式不正确
        if (result.hasErrors()) {
            return getErrorResponse(result);
        }
        return sportInformationClient.search(requestParam);
    }

    @ApiOperation(nickname = "deleteSportInformation",value = "删除资讯接口")
    @LogAnnotation
    @PostMapping("/delete/{id}")
    public ResponseData delete(@PathVariable(value = "id") Long id) {
        SportInformationDeleteRequest requestParam = new SportInformationDeleteRequest();
        requestParam.setId(id);
        return sportInformationClient.delete(requestParam);
    }

}
