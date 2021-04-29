package com.recommendation.restapi.repository;

import com.recommendation.restapi.model.ProductView;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import java.util.List;

@Repository
public class ProductViewRepositoryImpl implements ProductViewRepository{

    @Autowired
    private EntityManager entityManager;

    @Override
    public List<ProductView> getAll() {
        return entityManager.createQuery("from ProductView", ProductView.class).getResultList();
    }
}
