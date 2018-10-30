package com.spring.bookkeep.dao;

import com.spring.bookkeep.entity.Item;
import com.spring.bookkeep.entity.QueryItem;

import java.util.List;

public interface ItemDao {

    /**
     * 获取所有账单信息
     * @return
     */
    List<Item> queryItemList();

    /**
     * 获取日期之间的账期信息
     * @param queryItem
     * @return
     */
    List<Item> queryItemByItemDate(QueryItem queryItem);

    /**
     * 获取某个月的账期
     * @param queryItem
     * @return
     */
    List<Item> queryItemByMonth(QueryItem queryItem);

    /**
     * 增加一条账期
     * @param item
     * @return
     */
    Integer addItem(Item item);

    /**
     * 更新某条账期
     * @param item
     * @return
     */
    Integer updateItem(Item item);

    /**
     * 删除某条账期
     * @param itemId
     * @return
     */
    Integer removeItem(Integer itemId);

    /**
     *
     * @param itemId
     * @return
     */
    Item getItemById(Integer itemId);

}
