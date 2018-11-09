package com.siyueli.platform.activity.client.service.sportmemberfavorites;

import cn.siyue.platform.base.ResponseData;
import com.siyueli.platform.activity.client.callback.sportmemberfavorites.SportMemberFavoritesFallBack;
import com.siyueli.platform.activity.common.common.PageResponse;
import com.siyueli.platform.activity.common.request.sportmemberfavorites.*;
import com.siyueli.platform.activity.common.response.sportmemberfavorites.SportMemberFavoritesVo;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@FeignClient(name = "siyueli-activity-service", fallback = SportMemberFavoritesFallBack.class)
public interface SportMemberFavoritesClient {

    @RequestMapping(value = "/sportMemberFavorites/add", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE)
    ResponseData add(@RequestBody SportMemberFavoritesAddRequest requestParam);

    @RequestMapping(value = "/sportMemberFavorites/update", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE)
    ResponseData update(@RequestBody SportMemberFavoritesUpdateRequest requestParam);

    @RequestMapping(value = "/sportMemberFavorites/get", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE)
    ResponseData<SportMemberFavoritesVo> get(@RequestBody SportMemberFavoritesGetRequest requestParam);

    @RequestMapping(value = "/sportMemberFavorites/search", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE)
    ResponseData<PageResponse<SportMemberFavoritesVo>> search(@RequestBody SportMemberFavoritesSearchRequest requestParam);

    @RequestMapping(value = "/sportMemberFavorites/delete", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE)
    ResponseData delete(@RequestBody SportMemberFavoritesDeleteRequest requestParam);
}
