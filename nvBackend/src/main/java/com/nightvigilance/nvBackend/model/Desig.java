package com.nightvigilance.nvBackend.model;

import jakarta.persistence.*;

@Entity
public class Desig {
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getDesigName() {
        return desigName;
    }

    public void setDesigName(String desigName) {
        this.desigName = desigName;
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

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String desigName;

    @ManyToOne
    @JoinColumn(name = "dept_id", referencedColumnName = "id")
    private Dept dept;

    @ManyToOne
    @JoinColumn(name = "location_id", referencedColumnName = "id")
    private LOC location;

    // Getters and Setters
}
