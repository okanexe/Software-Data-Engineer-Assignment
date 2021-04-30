package com.recommendation.restapi.service;

import com.recommendation.restapi.model.Order;
import com.recommendation.restapi.model.OrderItem;
import com.recommendation.restapi.model.Product;

import java.util.List;

public interface BestSellerProductService {
    public List<OrderItem> bestSeller();
}
