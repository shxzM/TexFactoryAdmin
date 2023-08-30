package com.shazdevelops.texfactoryad;

public class TableInfo {
    String tableName;
    String tableNumber;
    String uid;
    String kw;

    public TableInfo() {
    }

    public TableInfo(String tableName, String tableNumber, String uid, String kw) {
        this.tableName = tableName;
        this.tableNumber = tableNumber;
        this.uid = uid;
        this.kw=kw;
    }

    public String getKw() {
        return kw;
    }

    public void setKw(String kw) {
        this.kw = kw;
    }

    public String getUid() {
        return uid;
    }

    public void setUid(String uid) {
        this.uid = uid;
    }

    public String getTableName() {
        return tableName;
    }

    public void setTableName(String tableName) {
        this.tableName = tableName;
    }

    public String getTableNumber() {
        return tableNumber;
    }

    public void setTableNumber(String tableNumber) {
        this.tableNumber = tableNumber;
    }
}

