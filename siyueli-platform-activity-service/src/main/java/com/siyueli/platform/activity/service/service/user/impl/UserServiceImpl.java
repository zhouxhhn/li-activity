package com.siyueli.platform.activity.service.service.user.impl;

import com.siyueli.platform.activity.service.constant.ActivityServiceConstant;
import com.siyueli.platform.activity.service.service.redis.JedisClusterService;
import com.siyueli.platform.activity.service.service.user.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private JedisClusterService jedisClusterService;

    @Override
    public String getUserIdByBackendToken(String token) {
        String userId = jedisClusterService.get(ActivityServiceConstant.REDIS_USER_SESSION_KEY_BACKEND + ":" + token);
        return userId;
    }

    @Override
    public String getUserIdByFrontToken(String token) {
        String userId = jedisClusterService.get(ActivityServiceConstant.REDIS_USER_SESSION_KEY_FRONT + ":" + token);
        return userId;
    }
}
