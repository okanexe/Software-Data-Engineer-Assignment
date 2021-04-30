package com.recommendation.restapi.service;

import com.recommendation.restapi.model.Order;
import com.recommendation.restapi.model.OrderItem;
import com.recommendation.restapi.model.Product;
import com.recommendation.restapi.repository.BestSellerProductRepository;
import com.recommendation.restapi.repository.OrderItemRepository;
import com.recommendation.restapi.repository.OrderRepository;
import com.recommendation.restapi.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class BestSellerProductServiceImpl implements BestSellerProductService{

    @Autowired
    private OrderRepository orderRepository;

    @Autowired
    private OrderItemRepository orderItemRepository;

    @Autowired
    private ProductRepository productRepository;

    @Autowired
    private BestSellerProductRepository bestSellerProductRepository;


    @Override
    public List<OrderItem> bestSeller() {
        return bestSellerProductRepository.getOrderItem();
    }
}
