package com.recommendation.restapi.model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Table(name = "products")
@Getter
@Setter
public class Product {

    @Id
    @Column(name = "product_id")
    private String productId;

    @Column(name = "category_id")
    private String categoryId;
}
