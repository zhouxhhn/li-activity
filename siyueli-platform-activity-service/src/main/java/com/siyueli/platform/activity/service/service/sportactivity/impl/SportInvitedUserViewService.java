package com.siyueli.platform.activity.service.service.sportactivity.impl;

import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import com.siyueli.platform.activity.common.entity.sportactivity.SportActivitySignup;
import com.siyueli.platform.activity.common.entity.sportactivity.SportActivityViewStatistics;
import com.siyueli.platform.activity.common.entity.sportactivity.SportInvitedUserView;
import com.siyueli.platform.activity.service.mapper.sportactivity.SportInvitedUserViewMapper;
import com.siyueli.platform.activity.service.service.sportactivity.SportActivityViewStatisticsServiceContract;
import com.siyueli.platform.activity.service.service.sportactivity.SportInvitedUserViewServiceContract;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;

import java.util.Date;

/**
 * <p>
 * 邀请函浏览信息 服务实现类
 * </p>
 *
 * @author Sipin ERP Development Team
 */
@Primary
@Service
public class SportInvitedUserViewService extends ServiceImpl<SportInvitedUserViewMapper, SportInvitedUserView> implements SportInvitedUserViewServiceContract {

    @Autowired
    private SportActivityViewStatisticsServiceContract sportActivityViewStatisticsServiceContract;

    @Override
    public Long viewLetter(Long letterId, Long userId) {
        SportInvitedUserView entity = new SportInvitedUserView();

        entity.setLetterId(letterId);
        entity.setUserId(new Long(userId));
        Date now = new Date();
        entity.setCreateAt(now);
        entity.setUpdateAt(now);

        insertAllColumn(entity);
        return entity.getId();
    }


}
