package com.recommendation.restapi.service;

import com.recommendation.restapi.model.OrderItem;

import java.util.List;

public interface OrderItemService {
    public List<OrderItem> getAll();
}
