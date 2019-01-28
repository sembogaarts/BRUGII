package com.tosad.brg.domain.project;

import javax.persistence.*;

@Entity
@javax.persistence.Table(name = "TABLES")
public class Table {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @SequenceGenerator(name = "TABLES_SEQUENCE", sequenceName = "TABLES_SEQUENCE", allocationSize = 1)
    public int id;

    @javax.persistence.Column(name = "name")
    public String name;

    @ManyToOne
    @JoinColumn(name = "project_id", nullable = false)
    public Project project;

    public Table(Project project, String name) {
        this.project = project;
        this.name = name;
    }

    public Table() {
    }
}
