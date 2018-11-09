package com.siyueli.platform.activity.client.controller.front;

import cn.siyue.platform.base.ResponseData;
import cn.siyue.platform.httplog.annotation.LogAnnotation;
import com.siyueli.platform.activity.client.controller.BaseController;
import com.siyueli.platform.activity.client.service.sportinformation.SportInformationClient;
import com.siyueli.platform.activity.common.common.PageResponse;
import com.siyueli.platform.activity.common.request.sportinfomation.SportInformationGetRequest;
import com.siyueli.platform.activity.common.request.sportinfomation.SportInformationSearchRequest;
import com.siyueli.platform.activity.common.response.sportinfomation.SportInformationVo;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;


@Api(tags = "前台_资讯管理接口")
@RestController
@RequestMapping("/sportInfomationFront")
public class SportInfomationFrontController extends BaseController {

    @Autowired
    private SportInformationClient sportInformationClient;

    @ApiOperation(nickname = "searchSportInformationFront",value = "搜索资讯接口")
    @LogAnnotation
    @GetMapping("/search")
    public ResponseData<PageResponse<SportInformationVo>> search(@Valid SportInformationSearchRequest requestParam, BindingResult result) {
        //请求的数据参数格式不正确
        if (result.hasErrors()) {
            return getErrorResponse(result);
        }
        return sportInformationClient.search(requestParam);
    }

    @ApiOperation(nickname = "getSportInformationFront",value = "得到资讯接口")
    @LogAnnotation
    @GetMapping("/get")
    public ResponseData<SportInformationVo> get(@Valid SportInformationGetRequest requestParam, BindingResult result) {
        //请求的数据参数格式不正确
        if (result.hasErrors()) {
            return getErrorResponse(result);
        }
        return sportInformationClient.get(requestParam);
    }

}
