package com.tosad.brg.api.taskSpecific;

public class Column {
    private Table table;

    public Column(Table table) {
        this.table = table;
    }

    public Table getTable() {
        return table;
    }

    public void setTable(Table table) {
        this.table = table;
    }
}
