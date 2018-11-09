package com.siyueli.platform.activity.service.service.sportactivity;

import com.baomidou.mybatisplus.service.IService;
import com.siyueli.platform.activity.common.entity.sportactivity.SportInvitationLetter;

/**
 * <p>
 * 邀请函 服务类
 * </p>
 *
 * @author Sipin ERP Development Team
 */
public interface SportInvitationLetterServiceContract extends IService<SportInvitationLetter> {


    public Long inviteTeamMember(Long userId, Long activityId);
}
