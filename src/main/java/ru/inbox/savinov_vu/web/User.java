package ru.inbox.savinov_vu.web;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;



public class User {

    private Integer id;

    @NotNull
    @Size(min = 3, max = 50)
    private String name;

    @NotNull
    @Email(message = "{invalid.email}")
    private String email;

    @NotNull
    @Size(min = 6, max = 50)
    private String password;


    public User() {
    }


    public User(Integer id, @NotNull @Size(min = 3, max = 50) String name, @NotNull @Email(message = "{invalid.email}") String email, @NotNull @Size(min = 6, max = 50) String password) {
        this.id = id;
        this.name = name;
        this.email = email;
        this.password = password;
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


    public String getEmail() {
        return email;
    }


    public void setEmail(String email) {
        this.email = email;
    }


    public String getPassword() {
        return password;
    }


    public void setPassword(String password) {
        this.password = password;
    }
}
