package com.siyueli.platform.activity.client.callback.activitywindow;

import cn.siyue.platform.base.ResponseData;
import com.siyueli.platform.activity.client.callback.BaseServiceFallBack;
import com.siyueli.platform.activity.client.service.activitywindow.ActivityWindowClient;
import com.siyueli.platform.activity.common.request.activitywindow.actwincontent.*;
import com.siyueli.platform.activity.common.request.activitywindow.actwingroup.*;
import com.siyueli.platform.activity.common.request.activitywindow.actwinplate.*;
import org.springframework.stereotype.Component;

@Component
public class ActivityWindowFallBack extends BaseServiceFallBack implements ActivityWindowClient {
    @Override
    public ResponseData addPlate(AddActWinPlateRequest requestParam) {
        return getDownGradeResponse();
    }

    @Override
    public ResponseData updatePlate(UpdateActWinPlateRequest requestParam) {
        return getDownGradeResponse();
    }

    @Override
    public ResponseData getPlate(GetActWinPlateRequest requestParam) {
        return getDownGradeResponse();
    }

    @Override
    public ResponseData searchPlate(SearchActWinPlateRequest requestParam) {
        return getDownGradeResponse();
    }

    @Override
    public ResponseData deletePlate(DeleteActWinPlateRequest requestParam) {
        return getDownGradeResponse();
    }

    @Override
    public ResponseData addGroup(AddActWinGroupRequest requestParam) {
        return getDownGradeResponse();
    }

    @Override
    public ResponseData updateGroup(UpdateActWinGroupRequest requestParam) {
        return getDownGradeResponse();
    }

    @Override
    public ResponseData getGroup(GetActWinGroupRequest requestParam) {
        return getDownGradeResponse();
    }

    @Override
    public ResponseData searchGroup(SearchActWinGroupRequest requestParam) {
        return getDownGradeResponse();
    }

    @Override
    public ResponseData deleteGroup(DeleteActWinGroupRequest requestParam) {
        return getDownGradeResponse();
    }

    @Override
    public ResponseData addContent(AddActWinContentRequest requestParam) {
        return getDownGradeResponse();
    }

    @Override
    public ResponseData updateContent(UpdateActWinContentRequest requestParam) {
        return getDownGradeResponse();
    }

    @Override
    public ResponseData getContent(GetActWinContentRequest requestParam) {
        return getDownGradeResponse();
    }

    @Override
    public ResponseData searchContent(SearchActWinContentRequest requestParam) {
        return getDownGradeResponse();
    }

    @Override
    public ResponseData deleteContent(DeleteActWinContentRequest requestParam) {
        return getDownGradeResponse();
    }
}
