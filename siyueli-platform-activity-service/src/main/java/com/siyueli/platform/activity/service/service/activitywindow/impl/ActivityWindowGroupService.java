package com.siyueli.platform.activity.service.service.activitywindow.impl;

import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import com.siyueli.platform.activity.common.entity.activitywindow.ActivityWindowGroup;
import com.siyueli.platform.activity.service.mapper.activitywindow.ActivityWindowGroupMapper;
import com.siyueli.platform.activity.service.service.activitywindow.ActivityWindowGroupServiceContract;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 活动橱窗分组表 服务实现类
 * </p>
 *
 * @author Sipin ERP Development Team
 */
@Primary
@Service
public class ActivityWindowGroupService extends ServiceImpl<ActivityWindowGroupMapper, ActivityWindowGroup> implements ActivityWindowGroupServiceContract {

}
