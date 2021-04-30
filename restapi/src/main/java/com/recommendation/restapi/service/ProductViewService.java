package com.recommendation.restapi.service;

import com.recommendation.restapi.model.OrderItem;
import com.recommendation.restapi.model.ProductView;

import java.util.List;

public interface ProductViewService {
    public List<ProductView> getAll();
    public List<ProductView> getProductViewByGivenUser(String userId);
}
