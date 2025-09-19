package com.RestApi.LMS.module;


import jakarta.persistence.*;

@Entity
@Table(name = "members")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "member_id")
    private int id;
    @Column(name = "full_name")
    private String UserName;

    public User() {
    }

    public User(int id, String userName) {
        this.id = id;
        UserName = userName;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getUserName() {
        return UserName;
    }

    public void setUserName(String userName) {
        UserName = userName;
    }
}
