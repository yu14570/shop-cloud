package com.yxd.controller;

import com.yxd.pojo.Carousel;
import com.yxd.items.service.CarouselService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @description:
 * @author: yxd
 * @create: 2021-10-01
 */
@RestController
@RequestMapping("/items/carousel")
public class CarouselController {
    @Autowired
    private CarouselService carouselService;

    @PostMapping("/queryAll")
    public List<Carousel> queryAll(@RequestParam(name = "isShow")Integer isShow) {
        System.out.println("进入CarouselController控制器");
        return carouselService.queryAll(isShow);
    }
}
