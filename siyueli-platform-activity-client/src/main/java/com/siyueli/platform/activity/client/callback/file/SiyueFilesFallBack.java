package com.siyueli.platform.activity.client.callback.file;

import cn.siyue.platform.base.ResponseData;
import com.siyueli.platform.activity.client.callback.BaseServiceFallBack;
import com.siyueli.platform.activity.client.service.file.SiyueFilesService;
import org.springframework.stereotype.Component;
import org.springframework.web.multipart.MultipartFile;

@Component
public class SiyueFilesFallBack extends BaseServiceFallBack implements SiyueFilesService {
    @Override
    public ResponseData handleFileUpload(MultipartFile file) {
        return getDownGradeResponse();
    }
}
