package com.cos.springboot.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.springframework.web.servlet.resource.PathResourceResolver;

// Configuration 쓰면 IoC 해준다.
// WebMvcConfigurer는 web.xml처럼 쓰게 해준다.
@Configuration
public class WebConfig implements WebMvcConfigurer {
	
	@Value("${file.path}")
	private String fileRealPath;
	
	@Override
	public void addResourceHandlers(ResourceHandlerRegistry registry) {
		WebMvcConfigurer.super.addResourceHandlers(registry);
		
		// 파일 경로 인식하게 하기
		// Builder 타입
		registry.addResourceHandler("/media/**")
		// 실제 경로 찾을 때는 /// 쓰기
		.addResourceLocations("file:///" + fileRealPath)
		// 3600초 = 1시간
		.setCachePeriod(3600)
		.resourceChain(true)
		.addResolver(new PathResourceResolver());
		
	}
}
