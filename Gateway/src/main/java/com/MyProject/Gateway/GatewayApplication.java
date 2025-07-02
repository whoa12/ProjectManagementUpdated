package com.MyProject.Gateway;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.gateway.route.RouteLocator;
import org.springframework.cloud.gateway.route.builder.RouteLocatorBuilder;
import org.springframework.context.annotation.Bean;

import java.time.LocalDateTime;

@SpringBootApplication

public class GatewayApplication {

	public static void main(String[] args) {
		SpringApplication.run(GatewayApplication.class, args);
	}
	@Bean
	public RouteLocator projectoRouteConfig(RouteLocatorBuilder routeLocatorBuilder){
		return routeLocatorBuilder.routes()
				.route(p -> p
						.path("/projecto/userservice/**")
						.filters(f -> f.rewritePath("projecto/userservice/(?<segment>.*)", "/${segment}")
								.circuitBreaker(config -> config.setName("userserviceCircuitBreaker")
										.setFallbackUri("forward:/authSupport"))
										.addResponseHeader("X-Response-Time", LocalDateTime.now().toString()))
						.uri("lb://TASK-USER-SERVICE"))
				.route(p -> p
				.path("/projecto/taskservice/**")
				.filters(f -> f.rewritePath("projecto/taskservice/(?<segment>.*)", "/${segment}")
								.addResponseHeader("X-Response-Time", LocalDateTime.now().toString()))
				.uri("lb://TASKSERVICE"))
				.route(p -> p
						.path("/projecto/submissionservice/**")
						.filters(f -> f.rewritePath("projecto/submissionservice/(?<segment>.*)", "/${segment}")
								.addResponseHeader("X-Response-Time", LocalDateTime.now().toString())) //sending header inside the response

						.uri("lb://SUBMISSIONSERVICE")).build();




	}

}

