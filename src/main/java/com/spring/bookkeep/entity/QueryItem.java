package com.spring.bookkeep.entity;

public class QueryItem {

    private String beginDate;
    private String endDate;
    private String dateMonth; //"201810"
    public String getBeginDate() {
        return beginDate;
    }

    public void setBeginDate(String beginDate) {
        this.beginDate = beginDate;
    }

    public String getEndDate() {
        return endDate;
    }

    public void setEndDate(String endDate) {
        this.endDate = endDate;
    }

    public String getDateMonth() {
        return dateMonth;
    }

    public void setDateMonth(String dateMonth) {
        this.dateMonth = dateMonth;
    }
}
