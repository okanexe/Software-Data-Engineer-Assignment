package com.recommendation.restapi.repository;

import com.recommendation.restapi.model.Order;
import com.recommendation.restapi.model.Product;

import java.util.List;

public interface ProductRepository {
    public List<Product> getAll();
}
