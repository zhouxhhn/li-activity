package com.siyueli.platform.activity.service.service.sportmsggroup.impl;

import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import com.siyueli.platform.activity.common.entity.sportmsggroup.SportMsgGroupUser;
import com.siyueli.platform.activity.service.mapper.sportmsggroup.SportMsgGroupUserMapper;
import com.siyueli.platform.activity.service.service.sportmsggroup.SportMsgGroupUserServiceContract;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 消息用户组的用户 服务实现类
 * </p>
 *
 * @author Sipin ERP Development Team
 */
@Primary
@Service
public class SportMsgGroupUserService extends ServiceImpl<SportMsgGroupUserMapper, SportMsgGroupUser> implements SportMsgGroupUserServiceContract {

}
