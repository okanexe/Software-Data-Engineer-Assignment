package com.recommendation.restapi.repository;

import com.recommendation.restapi.model.Order;
import com.recommendation.restapi.model.OrderItem;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;
import java.util.List;

@Repository
public class BestSellerProductRepositoryImpl implements BestSellerProductRepository{

    @Autowired
    private EntityManager entityManager;

    @Override
    public List<OrderItem> getOrderItem() {


        String query = "select sum(ori.quantity), ori.productId from OrderItem ori inner join Order o on ori.orderId=o.orderId  inner join Product p on p.productId=ori.productId where o.userId = 'user-88' group by ori.productId order by summary desc";

        return entityManager.createQuery(query).getResultList();
    }

    @Override
    public List<Order> getOrder() {
        return null;
    }
}
