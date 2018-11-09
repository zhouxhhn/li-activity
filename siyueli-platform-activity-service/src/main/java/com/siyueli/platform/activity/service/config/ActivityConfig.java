package com.siyueli.platform.activity.service.config;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;

@Component
@Primary
@ConfigurationProperties(prefix = "activity")
@Data
public class ActivityConfig {

    private String api_url;
}
