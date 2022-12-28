package com.example.productcatalogservice.exception;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class GetOneProductByIdException extends RuntimeException {
    private Throwable cause;

    public GetOneProductByIdException(Throwable cause) {
        this.cause = cause;
    }
}