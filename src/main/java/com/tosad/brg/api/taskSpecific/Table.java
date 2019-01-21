package com.tosad.brg.api.taskSpecific;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.Set;

@Entity
@javax.persistence.Table(name = "TABLE")
public class Table {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    public int id;

    @OneToMany(mappedBy="table")
    Set<Column> columns;

    public Table(Set<Column> columns) {
        this.columns = columns;
    }

    public Set<Column> getColumns() {
        return columns;
    }

    public void setColumns(Set<Column> columns) {
        this.columns = columns;
    }
}
