package com.siyueli.platform.activity.service.service.activitywindow.impl;

import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import com.siyueli.platform.activity.common.entity.activitywindow.ActivityWindowPlate;
import com.siyueli.platform.activity.service.mapper.activitywindow.ActivityWindowPlateMapper;
import com.siyueli.platform.activity.service.service.activitywindow.ActivityWindowPlateServiceContract;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 活动橱窗板块表 服务实现类
 * </p>
 *
 * @author Sipin ERP Development Team
 */
@Primary
@Service
public class ActivityWindowPlateService extends ServiceImpl<ActivityWindowPlateMapper, ActivityWindowPlate> implements ActivityWindowPlateServiceContract {

}
