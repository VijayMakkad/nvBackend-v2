package com.nightvigilance.nvBackend.model;

import jakarta.persistence.*;
import java.time.LocalDateTime;
import java.util.List;

@Entity
public class Action {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String empName;
    private int empId;

    @Column(name = "dept", nullable = false)
    private String dept;

    @Column(name = "desig", nullable = false)
    private String desig;

    private String email;
    private String actionName;

    @ManyToOne
    @JoinColumn(name = "roaster_id")
    private Roaster roaster;

    @OneToMany(mappedBy = "action", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Img> images;
    private String contactNo;
    private String reportingOfficer;
    private String createdBy;

    @Column(name = "created_on", nullable = false)
    private LocalDateTime createdOn;

    private String updatedBy;

    @Column(name = "updated_on", nullable = false)
    private LocalDateTime updatedOn;

    private boolean deleteFlag;

    // Getters and Setters

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getEmpName() {
        return empName;
    }

    public void setEmpName(String empName) {
        this.empName = empName;
    }

    public int getEmpId() {
        return empId;
    }

    public void setEmpId(int empId) {
        this.empId = empId;
    }

    public String getDept() {
        return dept;
    }

    public void setDept(String dept) {
        this.dept = dept;
    }

    public String getDesig() {
        return desig;
    }

    public void setDesig(String desig) {
        this.desig = desig;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getActionName() {
        return actionName;
    }

    public void setActionName(String actionName) {
        this.actionName = actionName;
    }

    public Roaster getRoaster() {
        return roaster;
    }

    public void setRoaster(Roaster roaster) {
        this.roaster = roaster;
    }

    public List<Img> getImages() {
        return images;
    }

    public void setImages(List<Img> images) {
        this.images = images;
    }

    public String getContactNo() {
        return contactNo;
    }

    public void setContactNo(String contactNo) {
        this.contactNo = contactNo;
    }

    public String getReportingOfficer() {
        return reportingOfficer;
    }

    public void setReportingOfficer(String reportingOfficer) {
        this.reportingOfficer = reportingOfficer;
    }

    public String getCreatedBy() {
        return createdBy;
    }

    public void setCreatedBy(String createdBy) {
        this.createdBy = createdBy;
    }

    public LocalDateTime getCreatedOn() {
        return createdOn;
    }

    public void setCreatedOn(LocalDateTime createdOn) {
        this.createdOn = createdOn;
    }

    public String getUpdatedBy() {
        return updatedBy;
    }

    public void setUpdatedBy(String updatedBy) {
        this.updatedBy = updatedBy;
    }

    public LocalDateTime getUpdatedOn() {
        return updatedOn;
    }

    public void setUpdatedOn(LocalDateTime updatedOn) {
        this.updatedOn = updatedOn;
    }

    public boolean isDeleteFlag() {
        return deleteFlag;
    }

    public void setDeleteFlag(boolean deleteFlag) {
        this.deleteFlag = deleteFlag;
    }
}