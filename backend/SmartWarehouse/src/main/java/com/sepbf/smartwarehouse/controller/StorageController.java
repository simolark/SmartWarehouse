package com.sepbf.smartwarehouse.controller;



import com.sepbf.smartwarehouse.service.CartService;
import jakarta.annotation.Resource;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController
@RequestMapping("/store")
public class StorageController {
    @Resource
    private CartService storageService;


    @PostMapping("/storeIn")
    public boolean storeIn(@RequestBody Map<String ,Object>map){
        //获取前端json数据
        System.out.println(map);
        return true;
    }

}
