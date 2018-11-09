package com.siyueli.platform.activity.service.service.sportactivity.impl;

import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import com.siyueli.platform.activity.common.entity.sportactivity.SportActivityTeam;
import com.siyueli.platform.activity.service.mapper.sportactivity.SportActivityTeamMapper;
import com.siyueli.platform.activity.service.service.sportactivity.SportActivityTeamServiceContract;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 活动队伍 服务实现类
 * </p>
 *
 * @author Sipin ERP Development Team
 */
@Primary
@Service
public class SportActivityTeamService extends ServiceImpl<SportActivityTeamMapper, SportActivityTeam> implements SportActivityTeamServiceContract {

}
