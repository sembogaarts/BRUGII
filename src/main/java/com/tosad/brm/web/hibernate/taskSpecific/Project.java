package com.tosad.brm.web.hibernate.taskSpecific;


import com.tosad.brm.web.hibernate.domain.template.DatabaseType;

import javax.persistence.*;
import java.util.Set;

@Entity
@javax.persistence.Table(name = "PROJECT")
public class Project {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @SequenceGenerator(name = "PROJECT_SEQUENCE", sequenceName = "PROJECT_SEQUENCE", allocationSize = 1)
    public int id;

//    private final DatabaseConnection databaseConnection;

    @javax.persistence.Column(name = "databasetype")
    private String databaseType;

    @javax.persistence.Column(name = "name")
    private String name;

    @javax.persistence.Column(name = "host")
    private String host;

    @javax.persistence.Column(name = "username")
    private String username;

    @javax.persistence.Column(name = "password")
    private String password;

    @javax.persistence.Column(name = "port")
    private int port;

//    private DatabaseType databaseType;

//    @OneToMany(mappedBy = "project")
//    private Set<Table> table;

    public Project(int id, String name, String host, String username, String password, int port, DatabaseType databaseType, Set<Table> tables) {
        this.id = id;
        this.name = name;
        this.host = host;
        this.username = username;
        this.password = password;
        this.port = port;
        this.databaseType = databaseType.toString();
//        this.table = tables;
//        this.databaseConnection = databaseType.createConnection(host, username, password, port);
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getHost() {
        return host;
    }

    public void setHost(String host) {
        this.host = host;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public int getPort() {
        return port;
    }

    public void setPort(int port) {
        this.port = port;
    }

//    public Set<Table> getTables() {
//        return table;
//    }
}
