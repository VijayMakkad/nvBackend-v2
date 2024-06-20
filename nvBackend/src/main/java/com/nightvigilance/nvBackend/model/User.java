package com.nightvigilance.nvBackend.model;

import jakarta.persistence.*;

@Entity
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String userName;
    private String userMail;
    private String role = "USER";  // Default role

    @ManyToOne
    @JoinColumn(name = "dept_id", referencedColumnName = "id")
    private Dept dept;

    @ManyToOne
    @JoinColumn(name = "location_id", referencedColumnName = "id")
    private LOC location;

    @ManyToOne
    @JoinColumn(name = "designation_id", referencedColumnName = "id")
    private Desig designation;

    // Getters and Setters
    // ...
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getUserMail() {
        return userMail;
    }

    public void setUserMail(String userMail) {
        this.userMail = userMail;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public Dept getDept() {
        return dept;
    }

    public void setDept(Dept dept) {
        this.dept = dept;
    }

    public LOC getLocation() {
        return location;
    }

    public void setLocation(LOC location) {
        this.location = location;
    }

    public Desig getDesignation() {
        return designation;
    }

    public void setDesignation(Desig designation) {
        this.designation = designation;
    }
}
