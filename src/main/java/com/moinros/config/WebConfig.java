package com.moinros.config;

import javax.servlet.MultipartConfigElement;

import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.boot.web.servlet.MultipartConfigFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;
import org.springframework.util.unit.DataSize;
import org.springframework.util.unit.DataUnit;

@Component
public class WebConfig {
	@Bean
	public MultipartConfigElement multipartConfigElement() {
		MultipartConfigFactory factory = new MultipartConfigFactory();
		// 文件最大255MB,DataUnit提供5中类型B,KB,MB,GB,TB
		factory.setMaxFileSize(DataSize.of(255, DataUnit.MEGABYTES));
		/// 设置总上传数据总大小255MB
		factory.setMaxRequestSize(DataSize.of(255, DataUnit.MEGABYTES));
		return factory.createMultipartConfig();
	}

	/**
	 * 注释: 将自定义过滤器添加到容器中
	 *
	 * @return FilterRegistrationBean<EncoidingFilter>
	 */
	@Bean
	public FilterRegistrationBean<EncoidingFilter> filterRegist() {
		FilterRegistrationBean<EncoidingFilter> frBean = new FilterRegistrationBean<EncoidingFilter>();
		frBean.setFilter(new EncoidingFilter());
		frBean.addUrlPatterns("/*");
		return frBean;
	}
}
