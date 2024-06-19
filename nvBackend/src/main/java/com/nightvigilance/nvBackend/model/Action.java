package com.nightvigilance.nvBackend.model;

import jakarta.persistence.*;

@Entity
public class Action {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String empName;
    private int empId;

    @ManyToOne
    @JoinColumn(name = "desig", referencedColumnName = "id")
    private Desig desig;

    @ManyToOne
    @JoinColumn(name = "dept", referencedColumnName = "id")
    private Dept dept;

    @ManyToOne
    @JoinColumn(name = "loc_id", referencedColumnName = "id")
    private LOC loc;

    private String email;

    @ManyToOne
    @JoinColumn(name = "action_img_id", referencedColumnName = "id")
    private Img actionImg;

    private String actionName;
}