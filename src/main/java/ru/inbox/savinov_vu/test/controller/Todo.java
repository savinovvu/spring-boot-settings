package ru.inbox.savinov_vu.test.controller;

import javax.persistence.Entity;
import javax.persistence.Id;



@Entity
public class Todo {

    @Id
    Integer id;

    String name;

    Boolean enabled;


    public Todo(int i, String todo1, boolean b) {

    }


    public Todo() {
    }


    public Integer getId() {
        return id;
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


    public Boolean getEnabled() {
        return enabled;
    }


    public void setEnabled(Boolean enabled) {
        this.enabled = enabled;
    }
}
