package com.tosad.brg.domain.project;

import javax.persistence.*;

@Entity
@javax.persistence.Table(name = "COLUMNS")
public class Column {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @SequenceGenerator(name = "COLUMN_SEQUENCE", sequenceName = "COLUMN_SEQUENCE", allocationSize = 1)
    public int id;

    public String type;

    @javax.persistence.Column(name = "name")
    public String name;

    @ManyToOne
    @JoinColumn(name = "tables_id", nullable = false)
    public Table tables;

    public Column(String name, String type, Table tables) {
        this.name = name;
        this.type = type;
        this.tables = tables;
    }

    public Column() {
        
    }

    public Table getTable() {
        return tables;
    }

    public void setTable(Table table) {
        this.tables = table;
    }
}
