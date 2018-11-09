package com.siyueli.platform.activity.service.service.sportactivity;

import com.baomidou.mybatisplus.service.IService;
import com.siyueli.platform.activity.common.entity.sportactivity.SportActivityChannel;
import com.siyueli.platform.activity.common.request.sportactivity.SportActivityChannelUpdateStatusRequest;

/**
 * <p>
 * 活动渠道 服务类
 * </p>
 *
 * @author Sipin ERP Development Team
 */
public interface SportActivityChannelServiceContract extends IService<SportActivityChannel> {

    public void updateStatus(SportActivityChannelUpdateStatusRequest requestParam);
}
