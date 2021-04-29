package com.recommendation.restapi.service;

import com.recommendation.restapi.model.Order;
import com.recommendation.restapi.repository.OrderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class OrderServiceImpl implements OrderService{

    @Autowired
    private OrderRepository orderRepository;

    @Override
    public List<Order> getAll() {
        return orderRepository.getAll();
    }

    @Override
    public List<Order> givenUser(String userId) {
        List<Order> orders = orderRepository.getAll();
        List<Order> givenUser = new ArrayList<>();

        orders.forEach(item -> {
            if(item.getUserId().equals(userId)){
                givenUser.add(item);
            }
        });
        return givenUser;
    }
}
