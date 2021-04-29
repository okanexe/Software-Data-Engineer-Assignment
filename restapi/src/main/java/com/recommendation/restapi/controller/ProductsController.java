package com.recommendation.restapi.controller;

import com.recommendation.restapi.model.Order;
import com.recommendation.restapi.model.OrderItem;
import com.recommendation.restapi.model.Product;
import com.recommendation.restapi.model.ProductView;
import com.recommendation.restapi.service.OrderItemService;
import com.recommendation.restapi.service.OrderService;
import com.recommendation.restapi.service.ProductService;
import com.recommendation.restapi.service.ProductViewService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.websocket.server.PathParam;
import java.util.ArrayList;
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

    @GetMapping
    public String get(){
        return "hello-world";
    }

    @GetMapping("/okan")
    public String getOkan(){
        return "okan";
    }

    @GetMapping("/get")
    public String setOkan(@RequestParam(defaultValue = "bosluk") String p){
        return p;
    }

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

    @GetMapping("/user")
    public List<Order> getUsersOrder(String userId){
        return orderService.givenUser(userId);
    }

    @GetMapping("/views")
    public List<ProductView> getProductViews(){
        return productViewService.getAll();
    }
}

// controller --> service --> repository --> database
