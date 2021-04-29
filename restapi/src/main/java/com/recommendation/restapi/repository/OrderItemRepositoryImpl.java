package com.recommendation.restapi.repository;

import com.recommendation.restapi.model.Order;
import com.recommendation.restapi.model.OrderItem;
import jdk.jfr.Registered;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import java.util.List;

@Repository
public class OrderItemRepositoryImpl implements OrderItemRepository{
    @Autowired
    private EntityManager entityManager;

    @Override
    public List<OrderItem> getAll() {
        List<OrderItem> orderItems = entityManager.createQuery("from OrderItem", OrderItem.class).getResultList();
        return orderItems;
    }
}
