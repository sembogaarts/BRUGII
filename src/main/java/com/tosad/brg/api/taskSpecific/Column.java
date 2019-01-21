package com.tosad.brg.api.taskSpecific;

import javax.persistence.*;

@Entity
@javax.persistence.Table(name = "COLUMNS")
public class Column {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @SequenceGenerator(name="COLUMN_SEQUENCE", sequenceName="COLUMN_SEQUENCE", allocationSize=1)
    public int id;

    @ManyToOne
    @JoinColumn(name = "tables_id", nullable = false)
    private Table tables;

    public Column(Table table) {
        this.tables = table;
    }

    public Table getTable() {
        return tables;
    }

    public void setTable(Table table) {
        this.tables = table;
    }
}
