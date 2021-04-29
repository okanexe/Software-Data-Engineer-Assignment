package com.recommendation.restapi.service;

import com.recommendation.restapi.model.OrderItem;
import com.recommendation.restapi.repository.OrderItemRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OrderItemServiceImpl implements OrderItemService{

    @Autowired
    private OrderItemRepository orderItemRepository;

    @Override
    public List<OrderItem> getAll() {
        return orderItemRepository.getAll();
    }
}
