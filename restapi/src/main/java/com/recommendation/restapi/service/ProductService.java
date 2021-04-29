package com.recommendation.restapi.service;

import com.recommendation.restapi.model.Order;
import com.recommendation.restapi.model.Product;

import java.util.List;

public interface ProductService {
    public List<Product> getAll();
    public List<String> getProductId();
}
