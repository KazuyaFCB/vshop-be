package com.example.productcatalogservice.controller;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import io.github.resilience4j.bulkhead.annotation.Bulkhead;
import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker;
import io.github.resilience4j.ratelimiter.annotation.RateLimiter;
import io.github.resilience4j.retry.annotation.Retry;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
@Slf4j
public class CircuitBreakerController {

    @GetMapping("/test-retry-api")
    @Retry(name = "test-retry-api", fallbackMethod = "hardcodedResponse")
    public String testRetry() {
        log.info("Test Retry api call received");
		ResponseEntity<String> forEntity = new RestTemplate().getForEntity("http://localhost:8080/some-dummy-url",
					String.class);
		return forEntity.getBody();
        //return "sample-api";
    }

    @GetMapping("/test-circuit-breaker-api")
    @CircuitBreaker(name = "test-circuit-breaker-api", fallbackMethod = "hardcodedResponse")
    public String testCircuitBreaker() {
        log.info("Test Circuit Breaker api call received");
        ResponseEntity<String> forEntity = new RestTemplate().getForEntity("http://localhost:8080/some-dummy-url",
                String.class);
        return forEntity.getBody();
        //return "sample-api";
    }

    public String hardcodedResponse(Exception ex) {
        log.info("call hardcodedResponse");
        return "fallback-response";
    }

    @GetMapping("/test-rate-limiter-api")
    @RateLimiter(name="test-rate-limiter-api")
    public String testRateLimiter() {
        log.info("Test Rate Limiter api call received");
        return "sample-api";
    }

    @GetMapping("/test-bulkhead-api")
    @Bulkhead(name="test-bulkhead-api")
    public String testBulkhead() {
        log.info("Test Bulkhead api call received");
        return "sample-api";
    }

    @GetMapping("/test-hystrix-api")
    @HystrixCommand(fallbackMethod = "hardcodedResponse2")
    public String testHystrix() {
        log.info("Test Hystrix api call received");
        ResponseEntity<String> forEntity = new RestTemplate().getForEntity("http://localhost:8080/some-dummy-url",
                String.class);
        return forEntity.getBody();
    }

    public String hardcodedResponse2() {
        log.info("call hardcodedResponse");
        return "fallback-response";
    }
}