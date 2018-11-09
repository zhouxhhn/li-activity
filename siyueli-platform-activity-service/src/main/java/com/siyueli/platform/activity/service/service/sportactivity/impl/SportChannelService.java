package com.siyueli.platform.activity.service.service.sportactivity.impl;

import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import com.siyueli.platform.activity.common.entity.sportactivity.SportChannel;
import com.siyueli.platform.activity.service.mapper.sportactivity.SportChannelMapper;
import com.siyueli.platform.activity.service.service.sportactivity.SportChannelServiceContract;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 渠道 服务实现类
 * </p>
 *
 * @author Sipin ERP Development Team
 */
@Primary
@Service
public class SportChannelService extends ServiceImpl<SportChannelMapper, SportChannel> implements SportChannelServiceContract {

}
