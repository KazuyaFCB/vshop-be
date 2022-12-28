package com.example.productcatalogservice.dto;

import com.example.productcatalogservice.entity.ProductEntity;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

public interface CreateOneProductDto {
    @Data
    @Builder
    @AllArgsConstructor
    @NoArgsConstructor
    class Request {
        private String productName;
        private BigDecimal price;
        private String description;
        private String category;
        private int availability;
    }

    @Data
    @Builder
    @AllArgsConstructor
    @NoArgsConstructor
    class Response {
        private boolean success;
        private ProductEntity data;
        private String message;
        private String port;
    }
}
