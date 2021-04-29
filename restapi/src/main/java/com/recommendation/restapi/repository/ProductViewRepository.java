package com.recommendation.restapi.repository;

import com.recommendation.restapi.model.Product;
import com.recommendation.restapi.model.ProductView;

import java.util.List;

public interface ProductViewRepository {
    public List<ProductView> getAll();
}
