package com.yxd.controller;

import com.yxd.pojo.Items;
import com.yxd.pojo.ItemsImg;
import com.yxd.pojo.ItemsParam;
import com.yxd.pojo.ItemsSpec;
import com.yxd.service.ItemService;
import com.yxd.utils.PagedGridResult;
import com.yxd.vo.CommentLevelCountsVO;
import com.yxd.vo.ShopcartVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @description:
 * @author: yxd
 * @create: 2021-10-02
 */
@RestController
@RequestMapping("/items/item")
public class ItemController {

    @Autowired
    private ItemService itemService;

    /**
     * 根据商品ID查询详情
     * @param itemId
     * @return
     */
    @PostMapping("queryItemById")
    public Items queryItemById(@RequestParam("itemId")String itemId){
        return itemService.queryItemById(itemId);
    }

    /**
     * 根据商品id查询商品图片列表
     * @param itemId
     * @return
     */
    @PostMapping("queryItemImgList")
    public List<ItemsImg> queryItemImgList(@RequestParam("itemId")String itemId){
        return itemService.queryItemImgList(itemId);
    }

    /**
     * 根据商品id查询商品规格
     * @param itemId
     * @return
     */
    @PostMapping("queryItemSpecList")
    public List<ItemsSpec> queryItemSpecList(@RequestParam("itemId")String itemId){
        return itemService.queryItemSpecList(itemId);
    }

    /**
     * 根据商品id查询商品参数
     * @param itemId
     * @return
     */
    @PostMapping("queryItemParam")
    public ItemsParam queryItemParam(@RequestParam("itemId")String itemId){
        return itemService.queryItemParam(itemId);
    }

    /**
     * 根据商品id查询商品的评价等级数量
     * @param itemId
     */
    @PostMapping("queryCommentCounts")
    public CommentLevelCountsVO queryCommentCounts(@RequestParam("itemId")String itemId){
        return itemService.queryCommentCounts(itemId);
    }

    /**
     * 根据商品id查询商品的评价（分页）
     * @param itemId
     * @param level
     * @return
     */
    @PostMapping("queryPagedComments")
    public PagedGridResult queryPagedComments(@RequestParam("itemId")String itemId,
                                              @RequestParam("level")Integer level,
                                              @RequestParam("page")Integer page,
                                              @RequestParam("pageSize")Integer pageSize){
        return itemService.queryPagedComments(itemId, level, page, pageSize);
    }

    /**
     * 搜索商品列表
     * @param keywords
     * @param sort
     * @param page
     * @param pageSize
     * @return
     */
    @PostMapping("searhItems")
    public PagedGridResult searhItems( @RequestParam("keywords")String keywords,
                                       @RequestParam("sort")String sort,
                                       @RequestParam("page")Integer page,
                                       @RequestParam("pageSize")Integer pageSize){
        return itemService.searhItems(keywords,sort,page,pageSize);
    }

    /**
     * 根据分类id搜索商品列表
     * @param catId
     * @param sort
     * @param page
     * @param pageSize
     * @return
     */
    @PostMapping("searhItemsByCateId")
    public PagedGridResult searhItemsByCateId( @RequestParam("catId")Integer catId,
                                       @RequestParam("sort")String sort,
                                       @RequestParam("page")Integer page,
                                       @RequestParam("pageSize")Integer pageSize){
        return itemService.searhItems(catId,sort,page,pageSize);
    }

    /**
     * 根据规格ids查询最新的购物车中商品数据（用于刷新渲染购物车中的商品数据）
     * @param specIds
     * @return
     */
    @PostMapping("queryItemsBySpecIds")
    public List<ShopcartVO> queryItemsBySpecIds( @RequestParam("specIds")String specIds){
        return itemService.queryItemsBySpecIds(specIds);
    }

    /**
     * 根据商品规格id获取规格对象的具体信息
     * @param specId
     * @return
     */
    @PostMapping("queryItemSpecById")
    public ItemsSpec queryItemSpecById( @RequestParam("specId")String specId){
        return itemService.queryItemSpecById(specId);
    }

    /**
     * 根据商品id获得商品图片主图url
     * @param itemId
     * @return
     */
    @PostMapping("queryItemMainImgById")
    public String queryItemMainImgById( @RequestParam("itemId")String itemId){
        return itemService.queryItemMainImgById(itemId);
    }

    /**
     * 减少库存
     * @param specId
     * @param buyCounts
     */
    @PostMapping("decreaseItemSpecStock")
    public void decreaseItemSpecStock( @RequestParam("specId")String specId,
                                       @RequestParam("buyCounts")int buyCounts){
        itemService.decreaseItemSpecStock(specId,buyCounts);
    }
}
