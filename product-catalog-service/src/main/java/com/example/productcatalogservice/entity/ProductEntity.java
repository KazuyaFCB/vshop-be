package com.example.productcatalogservice.entity;

import lombok.*;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

import java.math.BigDecimal;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "product")
//@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
public class ProductEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "product_name")
    @NotNull
    private String productName;

    @Column(name = "price")
    @NotNull
    private BigDecimal price;

    @Column(name = "description")
    private String description;

    @Column(name = "category")
    @NotNull
    private String category;

    @Column(name = "availability")
    @NotNull
    private int availability;

}