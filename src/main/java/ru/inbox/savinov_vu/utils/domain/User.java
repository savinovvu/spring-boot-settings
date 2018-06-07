package ru.inbox.savinov_vu.utils.domain;

public class User {

    public Integer id;

    public String name;

    public String email;


    public Integer getId() {
        return id;
    }


    public User() {
    }


    public User(Integer id, String name, String email) {
        this.id = id;
        this.name = name;
        this.email = email;
    }


    public void setId(Integer id) {
        this.id = id;
    }


    public String getName() {
        return name;
    }


    public void setName(String name) {
        this.name = name;
    }


    public String getEmail() {
        return email;
    }


    public void setEmail(String email) {
        this.email = email;
    }
}
