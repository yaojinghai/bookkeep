package com.spring.bookkeep.web;


import com.spring.bookkeep.entity.Item;
import com.spring.bookkeep.entity.QueryItem;
import com.spring.bookkeep.service.ItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/item")
public class ItemController {

    @Autowired
    private ItemService itemService;

    @RequestMapping(value = "/add", method = RequestMethod.POST)
    public Map<String, Object> addItem(@RequestBody Item item){
        Map<String, Object> modleMap = new HashMap<String, Object>();
        boolean isSuccess = itemService.addItem(item);
        modleMap.put("isAdd", isSuccess);
        return modleMap;
    }

    @RequestMapping(value = "/update", method = RequestMethod.POST)
    public Map<String, Object> update(@RequestBody Item item){
        Map<String, Object> modleMap = new HashMap<String, Object>();
        boolean isSuccess = itemService.modifyItem(item);
        modleMap.put("isUpdate", isSuccess);
        return modleMap;
    }

    @RequestMapping(value = "/delete", method = RequestMethod.GET)
    public Map<String, Object> delete(Integer itemId){
        Map<String, Object> modleMap = new HashMap<String, Object>();
        Item item = new Item();
        item.setItemId(itemId);
        boolean isSuccess = itemService.deleteItem(item);
        modleMap.put("isDelete", isSuccess);
        return modleMap;
    }

    @RequestMapping(value = "/listall", method = RequestMethod.GET)
    public Map<String, Object> listAll(){
        Map<String, Object> modleMap = new HashMap<String, Object>();
        List<Item> itemList = itemService.listAllItem();
        modleMap.put("itemAll", itemList);
        return modleMap;
    }

    @RequestMapping(value = "/listbymonth", method = RequestMethod.GET)
    public Map<String, Object> listByMonth(@RequestParam String dateMonth){  //dateMonth=201810

        Map<String, Object> modleMap = new HashMap<String, Object>();
        QueryItem queryItem = new QueryItem();
        if(dateMonth.length() == 6){
            queryItem.setDateMonth(dateMonth);
        }
        List<Item> itemList = itemService.listItemByQuery(queryItem);
        modleMap.put("itemList", itemList);
        return modleMap;
    }

    @RequestMapping(value = "/listbydate", method = RequestMethod.GET)
    public Map<String, Object> listByDate(String beginDate, String endDate){  //beginDate=20181028 endDate=20181029

        Map<String, Object> modleMap = new HashMap<String, Object>();
        QueryItem queryItem = new QueryItem();
        queryItem.setBeginDate(beginDate);
        queryItem.setEndDate(endDate);
        List<Item> itemList = itemService.listItemByQuery(queryItem);
        modleMap.put("itemList", itemList);
        return modleMap;
    }

}
