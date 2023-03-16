package com.sepbf.smartwarehouse.controller;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.sepbf.smartwarehouse.pojo.Cart;
import com.sepbf.smartwarehouse.service.CartService;
import jakarta.annotation.Resource;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/cart")
public class CartController {

    @Resource
    private CartService cartService;

    @PostMapping ("/addCart")
    public boolean addCart(@RequestBody Cart cart) {
        return cartService.addCart(cart);
    }



}
