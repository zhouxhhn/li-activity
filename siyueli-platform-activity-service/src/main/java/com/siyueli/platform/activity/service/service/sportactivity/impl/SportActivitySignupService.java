package com.siyueli.platform.activity.service.service.sportactivity.impl;

import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import com.siyueli.platform.activity.common.entity.sportactivity.*;
import com.siyueli.platform.activity.common.request.sportactivity.SportActivitySignupAddRequest;
import com.siyueli.platform.activity.common.request.sportactivity.SportActivitySignupUpdateStatusRequest;
import com.siyueli.platform.activity.service.constant.OrderConstant;
import com.siyueli.platform.activity.service.mapper.sportactivity.SportActivitySignupMapper;
import com.siyueli.platform.activity.service.service.sportactivity.*;
import com.siyueli.platform.activity.service.service.user.UserService;
import com.siyueli.platform.activity.service.util.RandomStringUtil;
import org.apache.commons.lang.StringUtils;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;
import java.util.Date;

/**
 * <p>
 * 活动报名 服务实现类
 * </p>
 *
 * @author Sipin ERP Development Team
 */
@Primary
@Service
public class SportActivitySignupService extends ServiceImpl<SportActivitySignupMapper, SportActivitySignup> implements SportActivitySignupServiceContract {

    @Autowired
    private SportActivityTeamServiceContract sportActivityTeamService;

    @Autowired
    private SportInvitationLetterServiceContract sportInvitationLetterService;

    @Autowired
    private SportActivityOrderServiceContract sportActivityOrderService;

    @Autowired
    private SportActivityServiceContract sportActivityService;

    @Autowired
    private UserService userService;

    @Override
    public String signUp(SportActivitySignupAddRequest requestParam) {
        String userId = userService.getUserIdByFrontToken(getToken());
        String orderNo = getOrderNo(requestParam.getActivityId(), new Long(userId));

        if (StringUtils.isNotEmpty(orderNo)) {
            return orderNo;
        }

        Long teamId = null;
        if (requestParam.getLetterId() != null) {
            SportInvitationLetter sportInvitationLetter = sportInvitationLetterService.selectById(requestParam.getLetterId());
            if (sportInvitationLetter != null) {
                SportActivitySignup invitationUserSignup = selectById(sportInvitationLetter.getUserId());
                if (invitationUserSignup != null) {
                    teamId = invitationUserSignup.getTeamId();
                }

            }
        }

        if (teamId == null) {
            teamId = addTeam("报名队伍", requestParam.getActivityId());
        }

        SportActivitySignup entity = new SportActivitySignup();
        BeanUtils.copyProperties(requestParam, entity);

        entity.setTeamId(teamId);
        entity.setStatus(20);
        entity.setUserId(new Long(userId));
        Date now = new Date();
        entity.setCreateAt(now);
        entity.setUpdateAt(now);
        entity.setIsDeleted(0);

        insertAllColumn(entity);

        orderNo = addOrder(requestParam.getActivityId(), entity.getId());
        return orderNo;
    }

    private String getOrderNo(Long activityId, Long userId) {
        EntityWrapper<SportActivitySignup> entityWrapper = new EntityWrapper<SportActivitySignup>();
        entityWrapper.eq("activity_id", activityId);
        entityWrapper.eq("user_id",userId);

        SportActivitySignup sportActivitySignup = selectOne(entityWrapper);
        if (sportActivitySignup != null) {
            EntityWrapper<SportActivityOrder> orderEntityWrapper = new EntityWrapper<SportActivityOrder>();
            orderEntityWrapper.eq("signup_id", sportActivitySignup.getId());
            SportActivityOrder sportActivityOrder = sportActivityOrderService.selectOne(orderEntityWrapper);
            if (sportActivityOrder != null) {
                return sportActivityOrder.getOrderNo();
            }
        }
        return null;
    }

    private String getToken() {
        HttpServletRequest request = ((ServletRequestAttributes) RequestContextHolder.getRequestAttributes()).getRequest();
        String token = request.getHeader("token");
        return token;
    }

    @Override
    public void updateStatus(SportActivitySignupUpdateStatusRequest requestParam) {
        SportActivitySignup entity = selectById(requestParam.getId());
        if (entity != null) {
            entity.setStatus(requestParam.getStatus());
            Date now = new Date();
            entity.setUpdateAt(now);
            updateAllColumnById(entity);
        }
    }

    private String addOrder(Long activityId, Long signupId) {
        SportActivity sportActivity = sportActivityService.selectById(activityId);

        SportActivityOrder entity = new SportActivityOrder();
        entity.setAmount(sportActivity.getFee());
        String orderNo = RandomStringUtil.getCurrentAndRandom("A");
        entity.setOrderNo(orderNo);
        entity.setSignupId(signupId);
        entity.setIsDeleted(0);
        entity.setStatus(OrderConstant.ORDER_STATUS_NO_PAYMENT);

        Date now = new Date();
        entity.setCreateAt(now);
        entity.setUpdateAt(now);

        sportActivityOrderService.insertAllColumn(entity);
        return orderNo;
    }

    private Long addTeam(String name, Long activityId) {
        SportActivityTeam entity = new SportActivityTeam();
        entity.setActivityId(activityId);
        entity.setName(name);

        Date now = new Date();

        entity.setCreateAt(now);
        entity.setUpdateAt(now);

        sportActivityTeamService.insertAllColumn(entity);
        return entity.getId();
    }
}
