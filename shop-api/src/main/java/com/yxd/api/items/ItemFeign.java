package com.yxd.api.items;

import com.yxd.pojo.Items;
import com.yxd.pojo.ItemsImg;
import com.yxd.pojo.ItemsParam;
import com.yxd.pojo.ItemsSpec;
import com.yxd.utils.PagedGridResult;
import com.yxd.vo.CommentLevelCountsVO;
import com.yxd.vo.ShopcartVO;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

/**
 * @description:
 * @author: yxd
 * @create: 2020-11-29
 */
@FeignClient(contextId = "ItemService",name = "eureka-items")
public interface ItemFeign {

    /**
     * 根据商品ID查询详情
     * @param itemId
     * @return
     */
    @PostMapping("/items/item/queryItemById")
    public Items queryItemById(@RequestParam("itemId")String itemId);

    /**
     * 根据商品id查询商品图片列表
     * @param itemId
     * @return
     */
    @PostMapping("/items/item/queryItemImgList")
    public List<ItemsImg> queryItemImgList(@RequestParam("itemId")String itemId);

    /**
     * 根据商品id查询商品规格
     * @param itemId
     * @return
     */
    @PostMapping("/items/item/queryItemSpecList")
    public List<ItemsSpec> queryItemSpecList(@RequestParam("itemId")String itemId);

    /**
     * 根据商品id查询商品参数
     * @param itemId
     * @return
     */
    @PostMapping("/items/item/queryItemParam")
    public ItemsParam queryItemParam(@RequestParam("itemId")String itemId);

    /**
     * 根据商品id查询商品的评价等级数量
     * @param itemId
     */
    @PostMapping("/items/item/queryCommentCounts")
    public CommentLevelCountsVO queryCommentCounts(@RequestParam("itemId")String itemId);

    /**
     * 根据商品id查询商品的评价（分页）
     * @param itemId
     * @param level
     * @return
     */
    @PostMapping("/items/item/queryPagedComments")
    public PagedGridResult queryPagedComments(@RequestParam("itemId")String itemId,
                                              @RequestParam(name ="level", required = false)Integer level,
                                              @RequestParam("page")Integer page,
                                              @RequestParam("pageSize")Integer pageSize);

    /**
     * 搜索商品列表
     * @param keywords
     * @param sort
     * @param page
     * @param pageSize
     * @return
     */
    @PostMapping("/items/item/searhItems")
    public PagedGridResult searhItems(@RequestParam("keywords")String keywords,
                                      @RequestParam("sort")String sort,
                                      @RequestParam("page")Integer page,
                                      @RequestParam("pageSize")Integer pageSize);

    /**
     * 根据分类id搜索商品列表
     * @param catId
     * @param sort
     * @param page
     * @param pageSize
     * @return
     */
    @PostMapping("/items/item/searhItems")
    public PagedGridResult searhItems(@RequestParam("catId")Integer catId,
                                      @RequestParam("sort")String sort,
                                      @RequestParam("page")Integer page,
                                      @RequestParam("pageSize")Integer pageSize);

    /**
     * 根据规格ids查询最新的购物车中商品数据（用于刷新渲染购物车中的商品数据）
     * @param specIds
     * @return
     */
    @PostMapping("/items/item/queryItemsBySpecIds")
    public List<ShopcartVO> queryItemsBySpecIds(@RequestParam("specIds")String specIds);

    /**
     * 根据商品规格id获取规格对象的具体信息
     * @param specId
     * @return
     */
    @PostMapping("/items/item/queryItemSpecById")
    public ItemsSpec queryItemSpecById(@RequestParam("specId")String specId);

    /**
     * 根据商品id获得商品图片主图url
     * @param itemId
     * @return
     */
    @PostMapping("/items/item/queryItemMainImgById")
    public String queryItemMainImgById(@RequestParam("itemId")String itemId);

    /**
     * 减少库存
     * @param specId
     * @param buyCounts
     */
    @PostMapping("/items/item/decreaseItemSpecStock")
    public void decreaseItemSpecStock(@RequestParam("buyCounts")String specId, int buyCounts);
}
