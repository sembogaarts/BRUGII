package com.tosad.brg.api.taskSpecific;

import javax.persistence.*;

@Entity
@javax.persistence.Table(name = "COLUMN")
public class Column {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @SequenceGenerator(name="COLUMN_SEQUENCE", sequenceName="COLUMN_SEQUENCE", allocationSize=1)
    public int id;

    @ManyToOne
    @JoinColumn(name = "tables_id", nullable = false)
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
