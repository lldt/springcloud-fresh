package com.lldt.fresh;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.session.data.redis.config.annotation.web.http.EnableRedisHttpSession;

@SpringBootApplication
@EnableEurekaClient
@EnableRedisHttpSession //将session存到redis
@MapperScan("com.lldt.fresh.mapper")
public class FreshUserApplication {
	public static void main(String[] args) {
		SpringApplication.run(FreshUserApplication.class, args);
	}
}
