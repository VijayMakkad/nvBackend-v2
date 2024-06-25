package com.nightvigilance.nvBackend.model;

import jakarta.persistence.*;

//import javax.persistence.*;
import java.sql.Timestamp;
import java.util.List;

@Entity
@Table(name = "roaster")
public class Roaster {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;


    private Timestamp dateTime;

    @OneToMany(mappedBy = "roaster", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private List<Members> members;


    private String createdBy;
    private Timestamp createdOn;

    private String updatedBy;
    private Timestamp updatedOn;
    private boolean deleteFlag = false;

    public String getCreatedBy() {
        return createdBy;
    }

    public void setCreatedBy(String createdBy) {
        this.createdBy = createdBy;
    }

    public Timestamp getCreatedOn() {
        return createdOn;
    }

    public void setCreatedOn(Timestamp createdOn) {
        this.createdOn = createdOn;
    }

    public String getUpdatedBy() {
        return updatedBy;
    }

    public void setUpdatedBy(String updatedBy) {
        this.updatedBy = updatedBy;
    }

    public Timestamp getUpdatedOn() {
        return updatedOn;
    }

    public void setUpdatedOn(Timestamp updatedOn) {
        this.updatedOn = updatedOn;
    }

    public boolean isDeleteFlag() {
        return deleteFlag;
    }

    public void setDeleteFlag(boolean deleteFlag) {
        this.deleteFlag = deleteFlag;
    }


    // Getters and Setters

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }


    public Timestamp getDateTime() {
        return dateTime;
    }

    public void setDateTime(Timestamp dateTime) {
        this.dateTime = dateTime;
    }

    public List<Members> getMembers() {
        return members;
    }

    public void setMembers(List<Members> members) {
        this.members = members;
    }
}
