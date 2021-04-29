package com.recommendation.restapi.repository;

import com.recommendation.restapi.model.Order;
import com.recommendation.restapi.model.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import java.util.List;

@Repository
public class ProductRepositoryImpl implements ProductRepository{

    @Autowired
    private EntityManager entityManager;

    @Override
    public List<Product> getAll() {
        List<Product> products = entityManager.createQuery("from Product", Product.class).getResultList();
        return products;
    }
}
