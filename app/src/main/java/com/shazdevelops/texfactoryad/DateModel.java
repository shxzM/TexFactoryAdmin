package com.shazdevelops.texfactoryad;

public class DateModel {

    int year,month,day;
    String duid;

    public DateModel() {
    }

    public DateModel(int year, int month, int day,String duid) {
        this.year = year;
        this.month = month;
        this.day = day;
        this.duid=duid;
    }

    public String getDuid() {
        return duid;
    }

    public void setDuid(String duid) {
        this.duid = duid;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public int getMonth() {
        return month;
    }

    public void setMonth(int month) {
        this.month = month;
    }

    public int getDay() {
        return day;
    }

    public void setDay(int day) {
        this.day = day;
    }
}
