package com.yxd.api.items;

import com.yxd.pojo.Carousel;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@FeignClient(contextId = "CarouselFeign",name = "eureka-items")
public interface CarouselFeign {

    /**
     * 查询所有轮播图列表
     * @param isShow
     * @return
     */
    @PostMapping("/items/carousel/queryAll")
    public List<Carousel> queryAll(@RequestParam(name = "isShow")Integer isShow);

}

