package com.atguigu.glimall.gateway;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

/**
 * 1.开启服务注册发现
 * 2.开启网关功能
 * 3.配置路由转发规则
 */
@EnableDiscoveryClient
//排除跟数据库相关的自动配置
@SpringBootApplication(exclude = {DataSourceAutoConfiguration.class})
public class GatewayApplication {

	public static void main(String[] args) {
		SpringApplication.run(GatewayApplication.class, args);
	}

}
