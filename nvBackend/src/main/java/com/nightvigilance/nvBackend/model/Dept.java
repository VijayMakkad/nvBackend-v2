package com.nightvigilance.nvBackend.model;


import jakarta.persistence.*;

@Entity
public class Dept {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    public String getDeptName() {
        return deptName;
    }

    public void setDeptName(String deptName) {
        this.deptName = deptName;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public LOC getLoc() {
        return loc;
    }

    public void setLoc(LOC loc) {
        this.loc = loc;
    }

    @ManyToOne
    @JoinColumn(name = "LOC_id", referencedColumnName = "id")
    private LOC loc;

    private String deptName;


}