package com.employee.employee_management.config;

import org.springframework.context.annotation.Configuration;

import io.swagger.v3.oas.annotations.enums.SecuritySchemeIn;
import io.swagger.v3.oas.annotations.enums.SecuritySchemeType;
import io.swagger.v3.oas.annotations.security.SecurityScheme;


@Configuration
@SecurityScheme(
	    name = "bearerAuth",
	    type = SecuritySchemeType.HTTP,
	    scheme = "bearer",
	    bearerFormat = "JWT",
	    in = SecuritySchemeIn.HEADER
	)
public class SwaggerConfig {

//	@Bean
//	public OpenAPI customOpenAPI() {
//		
//		return new OpenAPI()
//				.info(new Info().title("JavaInUse Authentication Service"))				
//				.addSecurityItem(new SecurityRequirement().addList("JavaInUseSecurityScheme"))
//				.components(new Components().addSecuritySchemes("JavaInUseSecurityScheme", new SecurityScheme()
//						.name("JavaInUseSecurityScheme").type(SecurityScheme.Type.HTTP).scheme("bearer").bearerFormat("JWT")));
//		
//	}
}
