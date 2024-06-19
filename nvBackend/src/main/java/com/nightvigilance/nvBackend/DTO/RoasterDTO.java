package com.nightvigilance.nvBackend.DTO;

import java.util.List;

public class RoasterDTO {
    private String dateTime;
    private int actionId;
    private List<MemberDTO> members;

    // Getters and Setters
    public String getDateTime() {
        return dateTime;
    }

    public void setDateTime(String dateTime) {
        this.dateTime = dateTime;
    }

    public int getActionId() {
        return actionId;
    }

    public void setActionId(int actionId) {
        this.actionId = actionId;
    }

    public List<MemberDTO> getMembers() {
        return members;
    }

    public void setMembers(List<MemberDTO> members) {
        this.members = members;
    }
}
