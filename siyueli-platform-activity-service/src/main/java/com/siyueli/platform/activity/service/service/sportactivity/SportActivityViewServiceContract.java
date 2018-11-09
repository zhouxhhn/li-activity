package com.siyueli.platform.activity.service.service.sportactivity;

import com.baomidou.mybatisplus.service.IService;
import com.siyueli.platform.activity.common.entity.sportactivity.SportActivityView;
import com.siyueli.platform.activity.common.request.sportactivity.SportActivityViewAddRequest;

/**
 * <p>
 * 活动浏览 服务类
 * </p>
 *
 * @author Sipin ERP Development Team
 */
public interface SportActivityViewServiceContract extends IService<SportActivityView> {

    public Long viewActivity(SportActivityViewAddRequest requestParam, Long userId);
}
