package com.tosad.brm.web.hibernate.taskSpecific;

import javax.persistence.*;

@Entity
@javax.persistence.Table(name = "TABLES")
public class Table {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @SequenceGenerator(name = "TABLES_SEQUENCE", sequenceName = "TABLES_SEQUENCE", allocationSize = 1)
    public int id;

    @javax.persistence.Column(name = "name")
    String name;

    @ManyToOne
    @JoinColumn(name = "project_id", nullable = false)
    private Project project;

    public Table(Project project, String name) {
        this.project = project;
        this.name = name;
    }
}
