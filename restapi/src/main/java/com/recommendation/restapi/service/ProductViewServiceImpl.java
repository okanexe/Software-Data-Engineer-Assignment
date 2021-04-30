package com.recommendation.restapi.service;

import com.recommendation.restapi.model.OrderItem;
import com.recommendation.restapi.model.ProductView;
import com.recommendation.restapi.repository.OrderItemRepository;
import com.recommendation.restapi.repository.ProductViewRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

@Service
public class ProductViewServiceImpl implements ProductViewService{

    @Autowired
    private ProductViewRepository productViewRepository;

    @Override
    public List<ProductView> getAll() {
        return productViewRepository.getAll();
    }

    @Override
    public List<ProductView> getProductViewByGivenUser(String userId) {
        List<ProductView> productViews = productViewRepository.getAll();
        List<ProductView> listOfUsersProductViews = new ArrayList<>();
        productViews.forEach(item -> {
            if(item.getUserId().equals(userId)){
                listOfUsersProductViews.add(item);
                Collections.reverse(listOfUsersProductViews);
            }
        });
        return listOfUsersProductViews;
    }


}
