package com.siyueli.platform.activity.service.service.sportactivity;

import com.baomidou.mybatisplus.service.IService;
import com.siyueli.platform.activity.common.entity.sportactivity.SportInvitedUserView;

/**
 * <p>
 * 邀请函浏览信息 服务类
 * </p>
 *
 * @author Sipin ERP Development Team
 */
public interface SportInvitedUserViewServiceContract extends IService<SportInvitedUserView> {

    public Long viewLetter(Long letterId, Long userId);
}
