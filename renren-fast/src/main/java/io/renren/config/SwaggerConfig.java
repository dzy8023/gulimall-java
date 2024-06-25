package io.renren.config;

import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Contact;
import io.swagger.v3.oas.models.info.Info;
import org.springdoc.core.models.GroupedOpenApi;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @author: zjl
 * @datetime: 2024/6/14
 */

@Configuration
public class SwaggerConfig {
    @Bean
    public OpenAPI customOpenAPI() {
        return new OpenAPI()
                .info(new Info()
                        .title("Springboot3.x整合Knife4接口文档")
                        .version("1.0")
                        .description("Springboot3.x整合Knife4")
                        .termsOfService("zhoujl.blog.csdn.net")
                        .contact(new Contact().name("Susheng").url("zhoujl.blog.csdn.net").email("180xxxx8296@163.com"))
                );
    }

    @Bean
    public GroupedOpenApi publicApi() {
        return GroupedOpenApi.builder()
                .group("前端接口")
                .pathsToMatch("/api/**")
                .build();
    }

    @Bean
    public GroupedOpenApi adminApi() {
        return GroupedOpenApi.builder()
                .group("后端接口")
                .pathsToMatch("/admin/**")
                .build();
    }

}
