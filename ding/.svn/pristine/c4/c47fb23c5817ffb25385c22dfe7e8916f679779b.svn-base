package com.ddcar.configure;

import javax.servlet.MultipartConfigElement;

import org.springframework.boot.web.servlet.MultipartConfigFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * User: ZhangXuanWei
 * Time: 2018/2/15 11:51
 * Description:
 */
@Configuration
public class CommonConfig {
	@Bean
    public MultipartConfigElement multipartConfigElement() {
        MultipartConfigFactory factory = new MultipartConfigFactory();
        factory.setMaxFileSize(1024L * 1024L*1000);
        return factory.createMultipartConfig();
    }
}
