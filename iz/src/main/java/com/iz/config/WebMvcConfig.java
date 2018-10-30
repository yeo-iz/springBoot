package com.iz.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurationSupport;

/**
 * @author yt
 * @version 1.0
 * @date 2018/8/3
 * @remark
 */
@Configuration
public class WebMvcConfig extends WebMvcConfigurationSupport {

  @Override
  protected void addViewControllers(ViewControllerRegistry registry) {
    registry.addViewController("login").setViewName("login");
  }
}
