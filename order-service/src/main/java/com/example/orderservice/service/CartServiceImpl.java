package com.example.orderservice.service;

import com.example.orderservice.dto.GetOneProductByIdDto;
import com.example.orderservice.feignclient.ProductCatalogProxy;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Mono;

@Service
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
    public Mono<GetOneProductByIdDto.Response> testFeign() {
        return productCatalogProxy.getOneProductById(1);
    }
}
