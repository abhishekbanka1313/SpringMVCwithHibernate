package com.stackroute.domain;

//user defined classes
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;


@Entity(name = "User")
@Table(name = "Login")
public class User {
    @Id
    @Column(nullable = false,name = "username",unique = true)
    private String name;
    @Column(nullable = false,name = "password")
    private String password;



    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }



    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public User() {

    }

    public User(String name,String password) {
        this.name = name;
        this.password = password;
    }
}
