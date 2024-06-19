package com.nightvigilance.nvBackend.model;

import jakarta.persistence.*;

//import javax.persistence.*;
import java.sql.Timestamp;
import java.util.List;

@Entity
public class Roaster {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @ManyToOne
    @JoinColumn(name = "action_id")
    private Action action;

    private Timestamp dateTime;

    @OneToMany(mappedBy = "roaster", cascade = CascadeType.ALL)
    private List<Members> members;

    // Getters and Setters

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Action getAction() {
        return action;
    }

    public void setAction(Action action) {
        this.action = action;
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
