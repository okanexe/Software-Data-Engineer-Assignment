package com.recommendation.restapi.controller;

import com.recommendation.restapi.model.Order;
import com.recommendation.restapi.model.OrderItem;
import com.recommendation.restapi.model.Product;
import com.recommendation.restapi.model.ProductView;
import com.recommendation.restapi.service.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequestMapping("/products")
@RestController
public class ProductsController {

    @Autowired
    private OrderService orderService;

    @Autowired
    private ProductService productService;

    @Autowired
    private OrderItemService orderItemService;

    @Autowired
    private ProductViewService productViewService;

    @Autowired
    private BestSellerProductService bestSellerProductService;

    @GetMapping("/order")
    public List<Order> getOrder(){
        return orderService.getAll();
    }

    @GetMapping("/product")
    public List<Product> getProduct(){
        return productService.getAll();
    }

    @GetMapping("/productIds")
    public List<String> getProductIds(){
        return productService.getProductId();
    }

    @GetMapping("/orderItem")
    public List<OrderItem> getOrderItem(){
        return orderItemService.getAll();
    }

    /* browsing history with given user id by date time*/
    @GetMapping("/user")
    public List<Order> getUsersOrder(String userId){
        return orderService.givenUser(userId);
    }

    @GetMapping("/views")
    public List<ProductView> getProductViews(){
        return productViewService.getAll();
    }

    @GetMapping("/userProducts")
    public List<ProductView> getUsersProductViews(String userId){
        return productViewService.getProductViewByGivenUser(userId);
    }

    @GetMapping("/bestSeller")
    public List getBestSeller(){
        return bestSellerProductService.bestSeller();
    }
}

// controller --> service --> repository --> database
