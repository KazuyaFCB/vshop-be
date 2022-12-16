package com.example.productcatalogservice.controller;

import com.example.productcatalogservice.dto.CreateOneProductDto;
import com.example.productcatalogservice.dto.GetOneProductByIdDto;
import com.example.productcatalogservice.service.IProductService;
import com.example.productcatalogservice.util.Constant;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Mono;

@RestController
@RequestMapping(value = Constant.API_PRODUCTS)
public class ProductControllerImpl implements IProductController {
    @Autowired
    private IProductService productService;

    @GetMapping(value = "/{id}")
    @ResponseStatus(HttpStatus.OK)
    @Override
    public Mono<GetOneProductByIdDto.Response> getOneProductById(@PathVariable("id") long id){
        return productService.getOneProductById(id);
    }

    @PostMapping(value = "")
    @ResponseStatus(HttpStatus.OK)
    @Override
    public Mono<CreateOneProductDto.Response> createOneProduct(@RequestBody CreateOneProductDto.Request request){
        return productService.createOneProduct(request);
    }
}
