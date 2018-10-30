package com.spring.bookkeep.service.impl;

import com.spring.bookkeep.common.utils.StringUtils;
import com.spring.bookkeep.dao.ItemDao;
import com.spring.bookkeep.entity.Item;
import com.spring.bookkeep.entity.QueryItem;
import com.spring.bookkeep.service.ItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
public class ItemServiceImpl implements ItemService {

    @Autowired
    private ItemDao itemDao;

    @Override
    public List<Item> listAllItem() {
        return itemDao.queryItemList();
    }

    @Override
    public List<Item> listItemByQuery(QueryItem queryItem) {
        if(queryItem == null ){
            return null;
        }
        String beginDate = queryItem.getBeginDate();
        String endDate = queryItem.getEndDate();
        String dateMonth = queryItem.getDateMonth();
        if(StringUtils.isBlank(beginDate) && StringUtils.isBlank(endDate) && StringUtils.isBlank(dateMonth)){
            return null;
        }
        if(!StringUtils.isBlank(beginDate) || !StringUtils.isBlank(endDate)){//表示有起止时间中任意一个
            return itemDao.queryItemByItemDate(queryItem);
        }
        if(!StringUtils.isBlank(dateMonth)){ //有按月查询
            return itemDao.queryItemByMonth(queryItem);
        }

        return null;
    }

    @Override
    public boolean addItem(Item item) {
        if(item == null){
            return false;
        }
        int addNum = 0;
        if(item.getItemName() != null && item.getItemDate() != null){
            try{
                item.setCreateTime(new Date());
                item.setUpdateTime(new Date());
                addNum = itemDao.addItem(item);
                if(addNum > 0){
                    return true;
                }else {
                    throw new RuntimeException("插入记录失败");
                }
            }catch (Exception e){
                throw new RuntimeException("新增记录失败" + e.getMessage());
            }

        }else{
            throw new RuntimeException("消费记录信息有误");
        }
    }

    @Override
    public boolean modifyItem(Item item) {
        if(item == null){
            return false;
        }
        int modifyNum = 0;
        if(item.getItemId() != null){
            try{
                item.setUpdateTime(new Date());
                modifyNum = itemDao.updateItem(item);
                if(modifyNum > 0){
                    return true;
                }else {
                    throw new RuntimeException("更新记录失败");
                }
            }catch (Exception e){
                throw new RuntimeException("更新记录失败" + e.getMessage());
            }
        }else{
            throw new RuntimeException("消费记录信息有误");
        }
    }

    @Override
    public boolean deleteItem(Item item) {
        if(item == null){
            return false;
        }
        int deleteNum = 0;
        Item checkItem = new Item();
        if(item.getItemId() != null){
            checkItem.setItemId(item.getItemId());
            checkItem = itemDao.getItemById(checkItem.getItemId());
            if(checkItem != null){

                deleteNum = itemDao.removeItem(item.getItemId());
            }
            if(deleteNum > 0){
                return true;
            }else {
                throw new RuntimeException("删除记录失败");
            }

        }else{
            throw new RuntimeException("消费记录信息有误");
        }
    }
}
