package com.yxd.controller;

import com.yxd.pojo.Category;
import com.yxd.items.service.CategoryService;
import com.yxd.vo.CategoryVO;
import com.yxd.vo.NewItemsVO;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @description:
 * @author: yxd
 * @create: 2021-10-01
 */
@Api(value = "CategoryController", tags = {"分类查询接口"})
@RestController
@RequestMapping("/items/category")
public class CategoryController {
    public static final Logger logger = LoggerFactory.getLogger(CategoryController.class);

    @Autowired
    private CategoryService categoryService;
    /**
     * 查询所有一级分类
     * @return
     */
    @ApiOperation(value = "查询所有一级分类", notes = "查询所有一级分类", httpMethod = "GET")
    @GetMapping("/queryAllRootLevelCat")
    public List<Category> queryAllRootLevelCat(){
        return categoryService.queryAllRootLevelCat();
    }

    /**
     * 根据一级分类id查询子分类信息
     * @param rootCatId
     * @return
     */
    @ApiOperation(value = "根据一级分类id查询子分类信息", notes = "根据一级分类id查询子分类信息", httpMethod = "POST")
    @PostMapping("/getSubCatList")
    public List<CategoryVO> getSubCatList(
            @ApiParam(name = "rootCatId", value = "一级分类id", required = true)
            @RequestParam(name = "rootCatId")Integer rootCatId){
        logger.info("进入{}控制器,参数为{}","CategoryController",rootCatId);
        return categoryService.getSubCatList(rootCatId);
    }

    /**
     * 查询首页每个一级分类下的6条最新商品数据
     * @param rootCatId
     * @return
     */
    @ApiOperation(value = "查询首页每个一级分类下的6条最新商品数据", notes = "查询首页每个一级分类下的6条最新商品数据", httpMethod = "POST")
    @PostMapping("/getSixNewItemsLazy")
    public List<NewItemsVO> getSixNewItemsLazy(
            @ApiParam(name = "rootCatId", value = "一级分类id", required = true)
            @RequestParam(name = "rootCatId")Integer rootCatId){
        return categoryService.getSixNewItemsLazy(rootCatId);
    }
}
