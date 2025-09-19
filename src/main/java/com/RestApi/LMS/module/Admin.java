package com.RestApi.LMS.module;


import jakarta.persistence.*;

@Entity
@Table(name = "admin")
public class Admin {

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "admin_name")
    private String AdminName;

    @Column(name = "mail_id")
    private String mailId;

    @Column(name = "password")
    private String password;

    public Admin() {
    }

    public Admin(int id, String adminName, String mailId, String password) {
        this.id = id;
        AdminName = adminName;
        this.mailId = mailId;
        this.password = password;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getAdminName() {
        return AdminName;
    }

    public void setAdminName(String adminName) {
        AdminName = adminName;
    }

    public String getMailId() {
        return mailId;
    }

    public void setMailId(String mailId) {
        this.mailId = mailId;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
