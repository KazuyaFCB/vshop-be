package com.example.orderservice.controller;

import com.example.orderservice.service.ICartService;
import com.example.orderservice.dto.CreateOneProductDto;
import com.example.orderservice.dto.GetOneProductByIdDto;
import com.example.orderservice.util.Constant;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Mono;

@RestController
@RequestMapping(value = Constant.API_CARTS)
public class CartControllerImpl implements ICartController {
    @Autowired
    private ICartService cartService;

//    @PostMapping(value = "/cart", params = {"productId", "quantity"})
//    public ResponseEntity<List<Object>> addItemToCart(
//            @RequestParam("productId") Long productId,
//            @RequestParam("quantity") Integer quantity,
//            @RequestHeader(value = "Cookie") String cartId,
//            HttpServletRequest request) {
//        List<Object> cart = cartService.getCart(cartId);
//        if(cart != null) {
//            if(cart.isEmpty()){
//                cartService.addItemToCart(cartId, productId, quantity);
//            }else{
//                if(cartService.checkIfItemIsExist(cartId, productId)){
//                    cartService.changeItemQuantity(cartId, productId, quantity);
//                }else {
//                    cartService.addItemToCart(cartId, productId, quantity);
//                }
//            }
//            return new ResponseEntity<List<Object>>(
//                    cart,
//                    headerGenerator.getHeadersForSuccessPostMethod(request, Long.parseLong(cartId)),
//                    HttpStatus.CREATED);
//        }
//        return new ResponseEntity<List<Object>>(
//                headerGenerator.getHeadersForError(),
//                HttpStatus.BAD_REQUEST);
//    }

    @PostMapping(value = "/testfeign")
    @ResponseStatus(HttpStatus.OK)
    public Mono<CreateOneProductDto.Response> testFeign(CreateOneProductDto.Request request){
        return cartService.testFeign(request);
    }

}
