package com.siyueli.platform.activity.client.controller.sportmemberfavorites;


import cn.siyue.platform.base.ResponseData;
import cn.siyue.platform.httplog.annotation.LogAnnotation;
import com.siyueli.platform.activity.client.controller.BaseController;
import com.siyueli.platform.activity.client.service.sportmemberfavorites.SportMemberFavoritesClient;
import com.siyueli.platform.activity.common.common.PageResponse;
import com.siyueli.platform.activity.common.request.sportmemberfavorites.*;
import com.siyueli.platform.activity.common.response.sportmemberfavorites.SportMemberFavoritesVo;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@Api(tags = "体育活动_收藏管理接口")
@RestController
@RequestMapping("/sportMemberFavorites")
public class SportMemberFavoritesController extends BaseController {

    @Autowired
    private SportMemberFavoritesClient sportMemberFavoritesClient;

    @ApiOperation(nickname = "addSportMemberFavorites",value = "新增体育活动_收藏接口")
    @LogAnnotation
    @PostMapping("/add")
    public ResponseData add(@Valid @RequestBody SportMemberFavoritesAddRequest requestParam, BindingResult result) {
        //请求的数据参数格式不正确
        if (result.hasErrors()) {
            return getErrorResponse(result);
        }
        return sportMemberFavoritesClient.add(requestParam);
    }

    @ApiOperation(nickname = "updateSportMemberFavorites",value = "更新体育活动_收藏接口")
    @LogAnnotation
    @PostMapping("/update/{id}")
    public ResponseData update(@PathVariable(value = "id") Long id, @Valid @RequestBody SportMemberFavoritesUpdateFrontRequest requestParam, BindingResult result) {
        //请求的数据参数格式不正确
        if (result.hasErrors()) {
            return getErrorResponse(result);
        }

        SportMemberFavoritesUpdateRequest updateRequest = new SportMemberFavoritesUpdateRequest();
        BeanUtils.copyProperties(requestParam, updateRequest);
        updateRequest.setId(id);
        return sportMemberFavoritesClient.update(updateRequest);
    }

    @ApiOperation(nickname = "getSportMemberFavorites",value = "得到体育活动_收藏接口")
    @LogAnnotation
    @GetMapping("/get")
    public ResponseData<SportMemberFavoritesVo> get(@Valid SportMemberFavoritesGetRequest requestParam, BindingResult result) {
        //请求的数据参数格式不正确
        if (result.hasErrors()) {
            return getErrorResponse(result);
        }
        return sportMemberFavoritesClient.get(requestParam);
    }

    @ApiOperation(nickname = "searchSportMemberFavorites",value = "搜索体育活动_收藏接口")
    @LogAnnotation
    @GetMapping("/search")
    public ResponseData<PageResponse<SportMemberFavoritesVo>> search(@Valid SportMemberFavoritesSearchRequest requestParam, BindingResult result) {
        //请求的数据参数格式不正确
        if (result.hasErrors()) {
            return getErrorResponse(result);
        }
        return sportMemberFavoritesClient.search(requestParam);
    }

    @ApiOperation(nickname = "deleteSportMemberFavorites",value = "删除体育活动_收藏接口")
    @LogAnnotation
    @PostMapping("/delete/{id}")
    public ResponseData delete(@PathVariable(value = "id") Long id) {
        SportMemberFavoritesDeleteRequest requestParam = new SportMemberFavoritesDeleteRequest();
        requestParam.setId(id);
        return sportMemberFavoritesClient.delete(requestParam);
    }

}
