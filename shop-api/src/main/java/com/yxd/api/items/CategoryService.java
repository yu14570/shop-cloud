package com.yxd.api.items;

import com.yxd.pojo.Category;
import com.yxd.vo.CategoryVO;
import com.yxd.vo.NewItemsVO;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@FeignClient(contextId = "categoryService",name = "eureka-items")
public interface CategoryService {

    /**
     * 查询所有一级分类
     * @return
     */
    @GetMapping("/items/category/queryAllRootLevelCat")
    public List<Category> queryAllRootLevelCat();

    /**
     * 根据一级分类id查询子分类信息
     * @param rootCatId
     * @return
     */
    @PostMapping("/items/category/getSubCatList")
    public List<CategoryVO> getSubCatList(@RequestParam(name = "rootCatId")Integer rootCatId);

    /**
     * 查询首页每个一级分类下的6条最新商品数据
     * @param rootCatId
     * @return
     */
    @PostMapping("/items/category/getSixNewItemsLazy")
    public List<NewItemsVO> getSixNewItemsLazy(@RequestParam(name = "rootCatId")Integer rootCatId);

}
