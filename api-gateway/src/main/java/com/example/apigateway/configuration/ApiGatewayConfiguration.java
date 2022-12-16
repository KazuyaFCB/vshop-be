package com.example.apigateway.configuration;

import org.springframework.cloud.gateway.route.RouteLocator;
import org.springframework.cloud.gateway.route.builder.RouteLocatorBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ApiGatewayConfiguration {

    @Bean
    public RouteLocator gatewayRouter(RouteLocatorBuilder builder) {
        return builder.routes()
                .route(p -> p
                        .path("/get")
                        .filters(f -> f
                                .addRequestHeader("MyHeader", "MyURI")
                                .addRequestParameter("Param", "MyValue"))
                        .uri("http://httpbin.org:80"))
                .route(p -> p.path("/api/products/**")
                        .uri("lb://product-catalog-service"))
                .route(p -> p.path("/api/carts/**")
                        .uri("lb://order-service"))
                .route(p -> p.path("/api/carts-new/**")
                        .filters(f -> f.rewritePath(
                                "/api/carts-new/(?<segment>.*)",
                                "/api/carts/${segment}"))
                        .uri("lb://order-service"))
                .build();
    }

}