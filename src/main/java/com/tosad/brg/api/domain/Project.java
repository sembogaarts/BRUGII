package com.tosad.brg.api.domain;

public class Project {
    private String name;
    private String host;
    private String username;
    private String passsword;
    private int port;

    public Project(String name, String host, String username, String passsword, int port) {
        this.name = name;
        this.host = host;
        this.username = username;
        this.passsword = passsword;
        this.port = port;
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

    public String getPasssword() {
        return passsword;
    }

    public void setPasssword(String passsword) {
        this.passsword = passsword;
    }

    public int getPort() {
        return port;
    }

    public void setPort(int port) {
        this.port = port;
    }
}
