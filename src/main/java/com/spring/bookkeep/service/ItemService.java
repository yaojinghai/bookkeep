package com.spring.bookkeep.service;

import com.spring.bookkeep.entity.Item;
import com.spring.bookkeep.entity.QueryItem;

import java.util.List;

public interface ItemService {

    List<Item> listAllItem();

    List<Item> listItemByQuery(QueryItem queryItem);

    boolean addItem(Item item);

    boolean modifyItem(Item item);

    boolean deleteItem(Item item);
}
