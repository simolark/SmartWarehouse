package com.sepbf.smartwarehouse.controller;

import com.sepbf.smartwarehouse.pojo.Cart;
import com.sepbf.smartwarehouse.service.CartService;
import jakarta.annotation.Resource;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/cart")
public class CartController {

    @Resource
    private CartService cartService;

    @PostMapping("/addCart")
    public boolean addCart(@RequestBody Cart cart) {
        return cartService.addCart(cart);
    }

    @GetMapping("/getCart")
    public Cart getCart() {
        System.out.println("getCart");
        System.out.println(cartService.getCartById(1));
        return cartService.getCartById(1);
    }


}
