package com.zh.models;

/**
 * time: 16-4-27.
 * author: han
 */
public class User {
    private Integer id;
    private String nikname;
    private String username;
    private String password;
    private int del_status;

    public User() {

    }

    public User(String nikname, String username, String password) {
        this.nikname = nikname;
        this.username = username;
        this.password = password;
    }

    public User(int del_status) {
        this.del_status = del_status;
    }

    /*********    getter and setter    ********/
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNikname() {
        return nikname;
    }

    public void setNikname(String nikname) {
        this.nikname = nikname;
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

    public int getDel_status() {
        return del_status;
    }

    public void setDel_status(int del_status) {
        this.del_status = del_status;
    }

    @Override
    public String toString() {
        return "id:" + this.id + " username:"+this.username;
    }
}
