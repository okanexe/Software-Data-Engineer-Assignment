package com.recommendation.restapi.repository;

import com.recommendation.restapi.model.Order;
import com.recommendation.restapi.model.OrderItem;

import java.util.List;

public interface BestSellerProductRepository {
    public List<OrderItem> getOrderItem();
    public List<Order> getOrder();
}
