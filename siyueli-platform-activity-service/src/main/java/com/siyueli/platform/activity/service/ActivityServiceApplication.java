/*
 * (C) Copyright 2018 Siyue Holding Group.
 */
package com.siyueli.platform.activity.service;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

/**
 * 微信服务类入口
 */
@EnableDiscoveryClient
@SpringBootApplication(scanBasePackages = {"com.siyueli.platform.activity.service.*","cn.siyue.platform.*"})
@MapperScan("com.siyueli.platform.activity.service.mapper")
public class ActivityServiceApplication {

  public static void main(String[] args) {
    SpringApplication.run(ActivityServiceApplication.class);
  }
}
