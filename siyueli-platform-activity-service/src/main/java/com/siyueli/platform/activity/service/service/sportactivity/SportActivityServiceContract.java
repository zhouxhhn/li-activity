package com.siyueli.platform.activity.service.service.sportactivity;

import com.baomidou.mybatisplus.service.IService;
import com.siyueli.platform.activity.common.common.PageResponse;
import com.siyueli.platform.activity.common.entity.sportactivity.SportActivity;
import com.siyueli.platform.activity.common.request.sportactivity.SportActivitySearchRequest;
import com.siyueli.platform.activity.common.response.sportactivity.SportActivityVo;

import java.util.List;

/**
 * <p>
 * 体育活动 服务类
 * </p>
 *
 * @author Sipin ERP Development Team
 */
public interface SportActivityServiceContract extends IService<SportActivity> {

    public PageResponse<SportActivityVo> search(SportActivitySearchRequest requestParam);
}
