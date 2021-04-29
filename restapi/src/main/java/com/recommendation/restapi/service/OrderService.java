package com.recommendation.restapi.service;

import com.recommendation.restapi.model.Order;

import java.util.List;

public interface OrderService {
    public List<Order> getAll();
    public List<Order> givenUser(String userId);
}
