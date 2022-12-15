package com.example.orderservice.feignclient;

import com.example.orderservice.dto.GetOneProductByIdDto;
//import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import reactivefeign.spring.config.ReactiveFeignClient;
import reactor.core.publisher.Mono;

@ReactiveFeignClient(name = "product-catalog-service", url = "http://localhost:8000/")
//@FeignClient(name = "product-catalog-service")
public interface ProductCatalogProxy {

    @GetMapping(value = "api/products/{id}")
    Mono<GetOneProductByIdDto.Response> getOneProductById(@PathVariable("id") long id);

}