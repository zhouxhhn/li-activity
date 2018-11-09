package com.siyueli.platform.activity.service.service.sportactivity;

import com.baomidou.mybatisplus.service.IService;
import com.siyueli.platform.activity.common.entity.sportactivity.SportActivitySignup;
import com.siyueli.platform.activity.common.request.sportactivity.SportActivitySignupAddRequest;
import com.siyueli.platform.activity.common.request.sportactivity.SportActivitySignupUpdateStatusRequest;

/**
 * <p>
 * 活动报名 服务类
 * </p>
 *
 * @author Sipin ERP Development Team
 */
public interface SportActivitySignupServiceContract extends IService<SportActivitySignup> {

    public String signUp(SportActivitySignupAddRequest requestParam);

    public void updateStatus(SportActivitySignupUpdateStatusRequest requestParam);
}
