package com.spring.bookkeep.entity;

import java.util.Date;

public class Item {
    private Integer itemId;
    private String itemName;
    private Float itemIncome;
    private String itemDate;
    private Integer incomeType; //1收入 2支出
    private Date createTime;
    private Date updateTime;

    public Integer getItemId() {
        return itemId;
    }

    public String getItemDate() {
        return itemDate;
    }

    public void setItemDate(String itemDate) {
        this.itemDate = itemDate;
    }

    public void setItemId(Integer itemId) {
        this.itemId = itemId;
    }

    public String getItemName() {
        return itemName;
    }

    public void setItemName(String itemName) {
        this.itemName = itemName;
    }

    public float getItemIncome() {
        return itemIncome;
    }

    public void setItemIncome(Float itemIncome) {
        this.itemIncome = itemIncome;
    }

    public Integer getIncomeType() {
        return incomeType;
    }

    public void setIncomeType(Integer incomeType) {
        this.incomeType = incomeType;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public Date getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }

    @Override
    public String toString() {
        return "Item{" +
                "itemId=" + itemId +
                ", itemName='" + itemName + '\'' +
                ", itemIncome=" + itemIncome +
                ", itemDate='" + itemDate + '\'' +
                ", incomeType=" + incomeType +
                ", createTime=" + createTime +
                ", updateTime=" + updateTime +
                '}';
    }
}
