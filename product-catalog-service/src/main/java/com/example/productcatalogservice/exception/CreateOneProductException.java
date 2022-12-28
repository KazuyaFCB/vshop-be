package com.example.productcatalogservice.exception;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class CreateOneProductException extends RuntimeException {
    private Throwable cause;

    public CreateOneProductException(Throwable cause) {
        this.cause = cause;
    }
}