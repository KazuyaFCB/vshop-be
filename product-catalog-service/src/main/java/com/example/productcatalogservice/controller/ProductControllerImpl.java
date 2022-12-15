package com.example.productcatalogservice.controller;

import com.example.productcatalogservice.dto.GetOneProductByIdDto;
import com.example.productcatalogservice.service.IProductService;
import com.example.productcatalogservice.util.Constant;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Mono;

@RestController
@RequestMapping(value = Constant.API_PRODUCTS)
public class ProductControllerImpl {
    @Autowired
    private IProductService productService;

    @GetMapping(value = "/{id}")
    @ResponseStatus(HttpStatus.OK)
    public Mono<GetOneProductByIdDto.Response> getOneProductById(@PathVariable("id") long id){
        return productService.getOneProductById(id);
    }
}
