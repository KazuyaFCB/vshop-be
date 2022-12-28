package com.example.orderservice.dto;

//import com.example.productcatalogservice.entity.ProductEntity;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

public interface GetOneProductByIdDto {
    @Data
    @Builder
    @AllArgsConstructor
    @NoArgsConstructor
    class Response {
        private boolean success;
        //private ProductEntity data;
        private String message;
        private String port;
    }
}
