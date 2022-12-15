package com.example.orderservice.service;

import com.example.orderservice.dto.GetOneProductByIdDto;
import reactor.core.publisher.Mono;

public interface ICartService {
    Mono<Void> addItemToCart(String cartId, Long productId, Integer quantity);
    Mono<GetOneProductByIdDto.Response> testFeign();
}
