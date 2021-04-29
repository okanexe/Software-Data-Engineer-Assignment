package com.recommendation.restapi.repository;

import com.recommendation.restapi.model.Order;

import java.util.List;

public interface OrderRepository {
    public List<Order> getAll();
}
