/*
 * (C) Copyright 2018 Siyue Holding Group.
 */
package com.siyueli.platform.activity.client.config;

import feign.codec.Encoder;
import feign.form.spring.SpringFormEncoder;
import org.springframework.beans.factory.ObjectFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.http.HttpMessageConverters;
import org.springframework.cloud.openfeign.support.SpringEncoder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.context.annotation.Scope;

@Configuration
public class FeignMultipartSupportConfig {

  @Autowired
  private ObjectFactory<HttpMessageConverters> messageConverters;

  @Bean
  @Primary
  @Scope("prototype")
  public Encoder multipartFormEncoder() {
    return new SpringFormEncoder(new SpringEncoder(this.messageConverters));
  }
}
