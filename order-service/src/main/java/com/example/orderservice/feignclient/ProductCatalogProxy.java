package com.example.orderservice.feignclient;

import com.example.orderservice.dto.CreateOneProductDto;
import com.example.orderservice.dto.GetOneProductByIdDto;
import com.example.orderservice.util.Constant;
import org.springframework.web.bind.annotation.*;
//import org.springframework.cloud.openfeign.FeignClient;
//import org.springframework.cloud.netflix.ribbon.RibbonClient;
import reactivefeign.spring.config.ReactiveFeignClient;
import reactor.core.publisher.Mono;

//@FeignClient(name = "product-catalog-service", url = "http://localhost:8000/")
//@RibbonClient(name="product-catalog-service")
@ReactiveFeignClient(name = "product-catalog-service")
public interface ProductCatalogProxy {

    @GetMapping(value = Constant.API_PRODUCTS + "/{id}")
    Mono<GetOneProductByIdDto.Response> getOneProductById(@PathVariable("id") long id);

    @PostMapping(Constant.API_PRODUCTS + "/")
    Mono<CreateOneProductDto.Response> createOneProduct(@RequestBody CreateOneProductDto.Request request);
}