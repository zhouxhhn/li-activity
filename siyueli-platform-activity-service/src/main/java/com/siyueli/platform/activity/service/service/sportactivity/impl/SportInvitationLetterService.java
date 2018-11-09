package com.siyueli.platform.activity.service.service.sportactivity.impl;

import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import com.siyueli.platform.activity.common.entity.sportactivity.SportInvitationLetter;
import com.siyueli.platform.activity.service.mapper.sportactivity.SportInvitationLetterMapper;
import com.siyueli.platform.activity.service.service.sportactivity.SportInvitationLetterServiceContract;
import org.springframework.beans.BeanUtils;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;

import java.util.Date;

/**
 * <p>
 * 邀请函 服务实现类
 * </p>
 *
 * @author Sipin ERP Development Team
 */
@Primary
@Service
public class SportInvitationLetterService extends ServiceImpl<SportInvitationLetterMapper, SportInvitationLetter> implements SportInvitationLetterServiceContract {

    @Override
    public Long inviteTeamMember(Long userId, Long activityId) {
        EntityWrapper<SportInvitationLetter> entityWrapper = new EntityWrapper<SportInvitationLetter>();
        entityWrapper.eq("user_id", userId);
        entityWrapper.eq("activity_id", activityId);

        SportInvitationLetter entity = selectOne(entityWrapper);
        if (entity != null) {
            return entity.getId();
        }

        entity = new SportInvitationLetter();

        entity.setUserId(userId);
        entity.setActivityId(activityId);
        Date now = new Date();
        entity.setCreateAt(now);
        entity.setUpdateAt(now);

        insertAllColumn(entity);
        return entity.getId();
    }
}
