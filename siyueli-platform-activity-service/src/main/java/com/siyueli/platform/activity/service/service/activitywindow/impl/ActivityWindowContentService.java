package com.siyueli.platform.activity.service.service.activitywindow.impl;

import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import com.siyueli.platform.activity.common.entity.activitywindow.ActivityWindowContent;
import com.siyueli.platform.activity.service.mapper.activitywindow.ActivityWindowContentMapper;
import com.siyueli.platform.activity.service.service.activitywindow.ActivityWindowContentServiceContract;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 活动橱窗内容表 服务实现类
 * </p>
 *
 * @author Sipin ERP Development Team
 */
@Primary
@Service
public class ActivityWindowContentService extends ServiceImpl<ActivityWindowContentMapper, ActivityWindowContent> implements ActivityWindowContentServiceContract {

}
