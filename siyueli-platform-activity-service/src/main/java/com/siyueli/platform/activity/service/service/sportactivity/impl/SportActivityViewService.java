package com.siyueli.platform.activity.service.service.sportactivity.impl;

import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import com.siyueli.platform.activity.common.entity.sportactivity.SportActivitySignup;
import com.siyueli.platform.activity.common.entity.sportactivity.SportActivityView;
import com.siyueli.platform.activity.common.entity.sportactivity.SportActivityViewStatistics;
import com.siyueli.platform.activity.common.request.sportactivity.SportActivityViewAddRequest;
import com.siyueli.platform.activity.service.mapper.sportactivity.SportActivityViewMapper;
import com.siyueli.platform.activity.service.service.sportactivity.SportActivityViewServiceContract;
import com.siyueli.platform.activity.service.service.sportactivity.SportActivityViewStatisticsServiceContract;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;

import java.util.Date;

/**
 * <p>
 * 活动浏览 服务实现类
 * </p>
 *
 * @author Sipin ERP Development Team
 */
@Primary
@Service
public class SportActivityViewService extends ServiceImpl<SportActivityViewMapper, SportActivityView> implements SportActivityViewServiceContract {

    @Autowired
    private SportActivityViewStatisticsServiceContract sportActivityViewStatisticsServiceContract;

    @Override
    public Long viewActivity(SportActivityViewAddRequest requestParam, Long userId) {
        SportActivityView entity = new SportActivityView();
        BeanUtils.copyProperties(requestParam, entity);

        entity.setUserId(userId);
        Date now = new Date();
        entity.setCreateAt(now);
        entity.setUpdateAt(now);

        insertAllColumn(entity);

        addActivityViewStatistics(requestParam.getActivityId(), requestParam.getActivityChannelId(), userId);

        return entity.getId();
    }

    private void addActivityViewStatistics(Long activityId, Long activityChannelId, Long userId) {
        SportActivityView sportActivityView = getSportActivityView(activityId, activityChannelId, userId);
        boolean viewFlag = false;
        if (sportActivityView != null) {
            viewFlag = true;
        }

        EntityWrapper<SportActivityViewStatistics> entityWrapper = new EntityWrapper<SportActivityViewStatistics>();
        entityWrapper.eq("activity_id", activityId);
        entityWrapper.eq("activity_channel_id", activityChannelId);

        SportActivityViewStatistics sportActivityViewStatistics = sportActivityViewStatisticsServiceContract.selectOne(entityWrapper);
        Date now = new Date();
        if (sportActivityViewStatistics != null) {
            sportActivityViewStatistics.setViewCount(sportActivityViewStatistics.getViewCount() + 1);
            if (!viewFlag) {
                sportActivityViewStatistics.setViewUserCount(sportActivityViewStatistics.getViewUserCount() + 1);
            }

            sportActivityViewStatistics.setUpdateAt(now);
            sportActivityViewStatisticsServiceContract.updateAllColumnById(sportActivityViewStatistics);
        } else {
            sportActivityViewStatistics = new SportActivityViewStatistics();
            sportActivityViewStatistics.setActivityId(activityId);
            sportActivityViewStatistics.setActivityChannelId(activityChannelId);
            sportActivityViewStatistics.setViewCount(1);
            sportActivityViewStatistics.setViewUserCount(1);
            sportActivityViewStatistics.setCreateAt(now);
            sportActivityViewStatistics.setUpdateAt(now);

            sportActivityViewStatisticsServiceContract.insertAllColumn(sportActivityViewStatistics);
        }
    }

    private SportActivityView getSportActivityView(Long activityId, Long activityChannelId, Long userId) {
        EntityWrapper<SportActivityView> entityWrapper = new EntityWrapper<SportActivityView>();
        entityWrapper.eq("activity_id", activityId);
        entityWrapper.eq("activity_channel_id", activityChannelId);
        entityWrapper.eq("user_id", userId);
        SportActivityView sportActivityView = selectOne(entityWrapper);
        return sportActivityView;
    }
}
