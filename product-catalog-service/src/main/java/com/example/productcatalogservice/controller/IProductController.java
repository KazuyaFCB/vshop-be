package com.example.productcatalogservice.controller;

import com.example.productcatalogservice.dto.CreateOneProductDto;
import com.example.productcatalogservice.dto.GetOneProductByIdDto;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import reactor.core.publisher.Mono;

public interface IProductController {
    Mono<GetOneProductByIdDto.Response> getOneProductById(@PathVariable("id") long id);
    Mono<CreateOneProductDto.Response> createOneProduct(@RequestBody CreateOneProductDto.Request request);
}
