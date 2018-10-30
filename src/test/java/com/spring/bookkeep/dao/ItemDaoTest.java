package com.spring.bookkeep.dao;

import com.spring.bookkeep.BookkeepApplication;
import com.spring.bookkeep.BookkeepApplicationTests;
import com.spring.bookkeep.entity.Item;
import com.spring.bookkeep.entity.QueryItem;
import org.junit.Assert;
import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Date;
import java.util.List;



public class ItemDaoTest extends BookkeepApplicationTests {

    @Autowired
    private ItemDao itemDao;

    @Test
    @Ignore
    public void queryItemList() {
        List<Item> items = itemDao.queryItemList();
        Assert.assertEquals(2,items.size());
    }

    @Test
    @Ignore
    public void queryItemByItemDate() {
        String beginDate = "20181029";
        String endDate = "20181030";
        QueryItem qitem = new QueryItem();
        qitem.setBeginDate(beginDate);
        qitem.setEndDate(endDate);
        List<Item> items = itemDao.queryItemByItemDate(qitem);
        Assert.assertEquals(2,items.size());

    }

    @Test
    @Ignore
    public void queryItemByMonth(){
        String dateMonth = "201810";
        QueryItem queryItem = new QueryItem();
        queryItem.setDateMonth(dateMonth);
        List<Item> items = itemDao.queryItemByMonth(queryItem);
        Assert.assertEquals(3,items.size());
    }

    @Test
    @Ignore
    public void updateItem(){
        Item item = new Item();
        item.setItemId(4);
        item.setItemName("汽车");
        item.setIncomeType(2);
        item.setItemDate("20181026");
        item.setItemIncome(1000.50f);
        item.setCreateTime(new Date());
        int addNum = itemDao.updateItem(item);
        Assert.assertEquals(1,addNum);
    }

    @Test
    public void removeItem(){

        int removeNum = itemDao.removeItem(4);
        Assert.assertEquals(1,removeNum);
    }


}