package com.example.orderservice.feignclient;

import com.example.productcatalogservice.dto.CreateOneProductDto;
import com.example.productcatalogservice.dto.GetOneProductByIdDto;
import com.example.productcatalogservice.util.Constant;
import org.springframework.cloud.openfeign.SpringQueryMap;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import reactivefeign.spring.config.ReactiveFeignClient;
//import org.springframework.cloud.openfeign.FeignClient;
import reactor.core.publisher.Mono;

//@FeignClient(name = "product-catalog-service", url = "http://localhost:8000/")
@ReactiveFeignClient(name = "product-catalog-service")
public interface ProductCatalogProxy {

    @GetMapping(value = Constant.API_PRODUCTS + "/{id}")
    Mono<GetOneProductByIdDto.Response> getOneProductById(@PathVariable("id") long id);

    @PostMapping(Constant.API_PRODUCTS + "/")
    Mono<CreateOneProductDto.Response> createOneProduct(@RequestBody CreateOneProductDto.Request request);
}