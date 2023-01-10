package com.example.orderservice.service;

import com.example.orderservice.dto.CreateOneProductDto;
import com.example.orderservice.dto.GetOneProductByIdDto;
import com.example.orderservice.feignclient.ProductCatalogProxy;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Mono;

@Service
@Slf4j
public class CartServiceImpl implements ICartService {
    @Autowired
    private ProductCatalogProxy productCatalogProxy;

    @Override
    public Mono<Void> addItemToCart(String cartId, Long productId, Integer quantity) {
        return productCatalogProxy.getOneProductById(productId).flatMap(response -> {
            //Item item = new Item(quantity,response.getData(), CartUtilities.getSubTotalForItem(response.getData(),quantity));
            //cartRedisRepository.addItemToCart(cartId, item);
            return Mono.empty();
        });
    }

    @Override
    public Mono<CreateOneProductDto.Response> testFeign(CreateOneProductDto.Request request) {
        return productCatalogProxy.createOneProduct(request).flatMap(response -> {
            log.info("{}", response);
            return Mono.just(response);
        });
    }
}
