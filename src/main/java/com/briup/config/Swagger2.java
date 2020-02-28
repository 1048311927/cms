package com.briup.config;

/** * Project Name:poll * File Name:Swagger2.java * Package Name:com.briup.apps.poll.config * Date:2018年6月10日下午6:22:51 * Copyright (c) 2018, chenzhou1025@126.com All Rights Reserved. * */
   
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.ParameterBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.schema.ModelRef;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Parameter;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;
import java.util.ArrayList;
import java.util.List;

/**
 * * ClassName:Swagger2 <br/>
 * * Function: TODO ADD FUNCTION. <br/>
 * * Reason: TODO ADD REASON. <br/>
 * 配置工具类 Date:     2018年6月10日 下午6:22:51 <br/>
 * * @author   shangzw * @version   * @since   JDK 1.8 * @see
 */
@Configuration
@EnableSwagger2
public class Swagger2 {
	@Bean
	public Docket createRestApi() {
		return new Docket(DocumentationType.SWAGGER_2).apiInfo(apiInfo()).select()
				.apis(RequestHandlerSelectors.basePackage("com.briup.web")).paths(PathSelectors.any()).build();
	}

	private ApiInfo apiInfo() {
		return new ApiInfoBuilder().title("看點咨詢").description("前後端分類項目").termsOfServiceUrl("http://www.briup.com")
				.version("1.0").build();
	}
}
