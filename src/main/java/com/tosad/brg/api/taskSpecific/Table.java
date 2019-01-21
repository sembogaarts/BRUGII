package com.tosad.brg.api.taskSpecific;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.util.ArrayList;

@Entity
@javax.persistence.Table(name = "TABLE")
public class Table {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    public int id;
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
