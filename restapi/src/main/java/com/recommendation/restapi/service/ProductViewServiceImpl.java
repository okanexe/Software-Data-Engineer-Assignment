package com.recommendation.restapi.service;

import com.recommendation.restapi.model.OrderItem;
import com.recommendation.restapi.model.ProductView;
import com.recommendation.restapi.repository.ProductViewRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductViewServiceImpl implements ProductViewService{

    @Autowired
    private ProductViewRepository productViewRepository;

    @Override
    public List<ProductView> getAll() {
        return productViewRepository.getAll();
    }

}
