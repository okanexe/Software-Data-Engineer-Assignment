package com.recommendation.restapi.repository;

import com.recommendation.restapi.model.Order;
import org.hibernate.Session;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import javax.persistence.EntityManager;
import java.util.List;

@Repository
public class OrderRepositoryImpl implements OrderRepository{
    @Autowired
    private EntityManager entityManager;

    @Override
    public List<Order> getAll() {
        List<Order> orders = entityManager.createQuery("from Order", Order.class).getResultList();
        return orders;
    }

}
