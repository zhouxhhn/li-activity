package com.siyueli.platform.activity.client.callback.sportactivity;

import cn.siyue.platform.base.ResponseData;
import com.siyueli.platform.activity.client.callback.BaseServiceFallBack;
import com.siyueli.platform.activity.client.service.sportactivity.SportInvitationLetterClient;
import com.siyueli.platform.activity.common.common.PageResponse;
import com.siyueli.platform.activity.common.request.sportactivity.*;
import com.siyueli.platform.activity.common.response.sportactivity.SportInvitationLetterVo;
import org.springframework.stereotype.Component;

@Component
public class SportInvitationLetterFallBack extends BaseServiceFallBack implements SportInvitationLetterClient {
    @Override
    public ResponseData add(SportInvitationLetterAddRequest requestParam) {
        return getDownGradeResponse();
    }

    @Override
    public ResponseData update(SportInvitationLetterUpdateRequest requestParam) {
        return getDownGradeResponse();
    }

    @Override
    public ResponseData<SportInvitationLetterVo> get(SportInvitationLetterGetRequest requestParam) {
        return getDownGradeResponse();
    }

    @Override
    public ResponseData<PageResponse<SportInvitationLetterVo>> search(SportInvitationLetterSearchRequest requestParam) {
        return getDownGradeResponse();
    }

    @Override
    public ResponseData delete(SportInvitationLetterDeleteRequest requestParam) {
        return getDownGradeResponse();
    }

    @Override
    public ResponseData inviteTeamMember(SportInvitationLetterInviteTeamMemberRequest requestParam) {
        return getDownGradeResponse();
    }
}
