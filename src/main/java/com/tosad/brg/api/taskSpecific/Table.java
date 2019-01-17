package com.tosad.brg.api.taskSpecific;

import java.util.ArrayList;

public class Table {
    ArrayList<Column> columns;

    public Table(ArrayList<Column> columns) {
        this.columns = columns;
    }

    public ArrayList<Column> getColumns() {
        return columns;
    }

    public void setColumns(ArrayList<Column> columns) {
        this.columns = columns;
    }
}
