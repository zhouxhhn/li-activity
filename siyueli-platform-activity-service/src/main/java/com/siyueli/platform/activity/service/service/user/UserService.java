package com.siyueli.platform.activity.service.service.user;

public interface UserService {

    public String getUserIdByBackendToken(String token);

    public String getUserIdByFrontToken(String token);
}
