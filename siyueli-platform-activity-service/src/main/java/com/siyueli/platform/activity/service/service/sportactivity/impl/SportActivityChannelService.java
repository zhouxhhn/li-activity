package com.siyueli.platform.activity.service.service.sportactivity.impl;

import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import com.siyueli.platform.activity.common.entity.sportactivity.SportActivityChannel;
import com.siyueli.platform.activity.common.request.sportactivity.SportActivityChannelUpdateStatusRequest;
import com.siyueli.platform.activity.service.mapper.sportactivity.SportActivityChannelMapper;
import com.siyueli.platform.activity.service.service.sportactivity.SportActivityChannelServiceContract;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;

import java.util.Date;

/**
 * <p>
 * 活动渠道 服务实现类
 * </p>
 *
 * @author Sipin ERP Development Team
 */
@Primary
@Service
public class SportActivityChannelService extends ServiceImpl<SportActivityChannelMapper, SportActivityChannel> implements SportActivityChannelServiceContract {

    @Override
    public void updateStatus(SportActivityChannelUpdateStatusRequest requestParam) {
        SportActivityChannel sportActivityChannel = selectById(requestParam.getId());
        sportActivityChannel.setStatus(requestParam.getStatus());
        Date now = new Date();
        sportActivityChannel.setUpdateAt(now);

        updateAllColumnById(sportActivityChannel);
    }
}
