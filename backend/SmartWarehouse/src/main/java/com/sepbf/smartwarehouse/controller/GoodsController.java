package com.sepbf.smartwarehouse.controller;


import com.sepbf.smartwarehouse.pojo.Goods;
import com.sepbf.smartwarehouse.service.GoodsService;
import jakarta.annotation.Resource;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/goods")
public class GoodsController {

    @Resource
    private GoodsService goodsService;

    @PostMapping("/addGoods")
    public boolean addGoods(@RequestBody Goods goods) {
        return goodsService.addGoods(goods);
    }

}
