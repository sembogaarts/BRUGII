package com.tosad.brg.api.taskSpecific;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.Set;

@Entity
@javax.persistence.Table(name = "TABLES")
public class Table {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @SequenceGenerator(name = "TABLES_SEQUENCE", sequenceName = "TABLES_SEQUENCE", allocationSize = 1)
    public int id;

    @OneToMany(mappedBy = "tables")
    Set<Column> columns;

    @ManyToOne
    @JoinColumn(name = "project_id", nullable = false)
    private Project project;

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
