package com.tosad.brg.api.taskSpecific;

import javax.persistence.*;
import javax.persistence.Table;

@Entity
@Table(name = "COLUMN")
public class Column {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    public int id;

    @ManyToOne
    @JoinColumn(name="table_id", nullable=false)
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
