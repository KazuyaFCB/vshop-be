package com.example.orderservice.service;

import com.example.productcatalogservice.dto.CreateOneProductDto;
import com.example.productcatalogservice.dto.GetOneProductByIdDto;
import reactor.core.publisher.Mono;

public interface ICartService {
    Mono<Void> addItemToCart(String cartId, Long productId, Integer quantity);
    Mono<CreateOneProductDto.Response> testFeign(CreateOneProductDto.Request request);
}
