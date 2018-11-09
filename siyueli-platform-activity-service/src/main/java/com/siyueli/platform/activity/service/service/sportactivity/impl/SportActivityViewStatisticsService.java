package com.siyueli.platform.activity.service.service.sportactivity.impl;

import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import com.siyueli.platform.activity.common.entity.sportactivity.SportActivityViewStatistics;
import com.siyueli.platform.activity.service.mapper.sportactivity.SportActivityViewStatisticsMapper;
import com.siyueli.platform.activity.service.service.sportactivity.SportActivityViewStatisticsServiceContract;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 活动浏览统计 服务实现类
 * </p>
 *
 * @author Sipin ERP Development Team
 */
@Primary
@Service
public class SportActivityViewStatisticsService extends ServiceImpl<SportActivityViewStatisticsMapper, SportActivityViewStatistics> implements SportActivityViewStatisticsServiceContract {

}
