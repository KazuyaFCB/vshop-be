package com.example.productcatalogservice.service;

import com.example.productcatalogservice.dto.GetOneProductByIdDto;
import reactor.core.publisher.Mono;

public interface IProductService {
    Mono<GetOneProductByIdDto.Response> getOneProductById(long id);
}
