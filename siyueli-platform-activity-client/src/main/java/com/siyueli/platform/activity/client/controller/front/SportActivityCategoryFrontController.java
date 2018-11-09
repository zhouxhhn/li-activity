package com.siyueli.platform.activity.client.controller.front;

import cn.siyue.platform.base.ResponseData;
import cn.siyue.platform.httplog.annotation.LogAnnotation;
import com.siyueli.platform.activity.client.controller.BaseController;
import com.siyueli.platform.activity.client.service.sportactivity.SportActivityCategoryClient;
import com.siyueli.platform.activity.common.common.PageResponse;
import com.siyueli.platform.activity.common.request.sportactivity.SportActivityCategorySearchRequest;
import com.siyueli.platform.activity.common.response.sportactivity.SportActivityCategoryVo;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@Api(tags = "前台_活动分类管理接口")
@RestController
@RequestMapping("/sportActivityCategoryFront")
public class SportActivityCategoryFrontController extends BaseController {

    @Autowired
    private SportActivityCategoryClient sportActivityCategoryClient;

    @ApiOperation(nickname = "searchSportActivityCategoryFront",value = "搜索活动分类接口")
    @LogAnnotation
    @GetMapping("/search")
    public ResponseData<PageResponse<SportActivityCategoryVo>> search(@Valid SportActivityCategorySearchRequest requestParam, BindingResult result) {
        //请求的数据参数格式不正确
        if (result.hasErrors()) {
            return getErrorResponse(result);
        }
        return sportActivityCategoryClient.search(requestParam);
    }
}
