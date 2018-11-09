/*
 * (C) Copyright 2018 Siyue Holding Group.
 */
package com.siyueli.platform.activity.client;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.ServletComponentScan;
import org.springframework.cloud.client.circuitbreaker.EnableCircuitBreaker;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.openfeign.EnableFeignClients;

/**
 * 微信服务消费的应用
 */
@ServletComponentScan
@EnableCircuitBreaker
@EnableFeignClients
@EnableDiscoveryClient
@SpringBootApplication(scanBasePackages = {"com.siyueli.platform.activity.client.*","cn.siyue.platform.*"})
public class ActivityClientApplication {

  public static void main(String[] args) {
    SpringApplication.run(ActivityClientApplication.class);
  }
}
