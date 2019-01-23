package com.tosad.brm.web.hibernate.taskSpecific;

import javax.persistence.*;

@Entity
@javax.persistence.Table(name = "COLUMNS")
public class Column {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @SequenceGenerator(name = "COLUMN_SEQUENCE", sequenceName = "COLUMN_SEQUENCE", allocationSize = 1)
    public int id;

    @javax.persistence.Column(name = "name")
    String name;

    @ManyToOne
    @JoinColumn(name = "tables_id", nullable = false)
    public Table tables;

    public Column(String name, Table tables) {
        this.name = name;
        this.tables = tables;
    }

    public Table getTable() {
        return tables;
    }

    public void setTable(Table table) {
        this.tables = table;
    }
}
