package com.recommendation.restapi.service;

import com.recommendation.restapi.model.Product;
import com.recommendation.restapi.repository.OrderRepository;
import com.recommendation.restapi.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ProductServiceImpl implements ProductService{

    @Autowired
    private ProductRepository productRepository;

    @Override
    public List<Product> getAll() {
        return productRepository.getAll();
    }

    @Override
    public List<String> getProductId() {
         List<Product> products = productRepository.getAll();
         List<String> productIds = new ArrayList<>();
         products.forEach(item->{
             productIds.add(item.getProductId());
         });
        return productIds;
    }

}
