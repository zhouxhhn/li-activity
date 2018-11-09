package com.siyueli.platform.activity.service.service.sportmsggroup.impl;

import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import com.siyueli.platform.activity.common.entity.sportmsggroup.SportMsgGroup;
import com.siyueli.platform.activity.service.mapper.sportmsggroup.SportMsgGroupMapper;
import com.siyueli.platform.activity.service.service.sportmsggroup.SportMsgGroupServiceContract;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 消息用户组 服务实现类
 * </p>
 *
 * @author Sipin ERP Development Team
 */
@Primary
@Service
public class SportMsgGroupService extends ServiceImpl<SportMsgGroupMapper, SportMsgGroup> implements SportMsgGroupServiceContract {

}
