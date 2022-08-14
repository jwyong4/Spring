package com.example.cmarket.order;

public interface OrderService {
    Order createOrder(Long userId, String itemName, int itemPrice);
}
