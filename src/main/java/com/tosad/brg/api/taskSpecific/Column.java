package com.tosad.brg.api.taskSpecific;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
@javax.persistence.Table(name = "COLUMN")
public class Column {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    public int id;

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
