package com.nightvigilance.nvBackend.model;

import jakarta.persistence.*;

@Entity
@Table(name = "members")
public class Members {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @ManyToOne
    @JoinColumn(name = "roaster_id", nullable = false)
    private Roaster roaster;

    private String memberName;
    private String mail;
    private int empCode;
    private String department;
    private String desig;
    private String contact;
    private String hod;
    private String reportingOfficer;

    @Column(name="is_team_head", columnDefinition = "BIT(1)")
    private Boolean isTeamHead;

    @Column(name="is_shift_incharge", columnDefinition = "BIT(1)")
    private Boolean isShiftIncharge;

    @Column(name="is_sec_staff", columnDefinition = "BIT(1)")
    private Boolean isSecStaff;



    // Getters and Setters
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Roaster getRoaster() {
        return roaster;
    }

    public void setRoaster(Roaster roaster) {
        this.roaster = roaster;
    }

    public String getMemberName() {
        return memberName;
    }

    public void setMemberName(String memberName) {
        this.memberName = memberName;
    }

    public String getMail() {
        return mail;
    }

    public void setMail(String mail) {
        this.mail = mail;
    }

    public int getEmpCode() {
        return empCode;
    }

    public void setEmpCode(int empCode) {
        this.empCode = empCode;
    }

    public String getDepartment() {
        return department;
    }

    public void setDepartment(String department) {
        this.department = department;
    }

    public String getDesig() {
        return desig;
    }

    public void setDesig(String desig) {
        this.desig = desig;
    }

    public String getContact() {
        return contact;
    }

    public void setContact(String contact) {
        this.contact = contact;
    }

    public String getHod() {
        return hod;
    }

    public void setHod(String hod) {
        this.hod = hod;
    }

    public String getReportingOfficer() {
        return reportingOfficer;
    }

    public void setReportingOfficer(String reportingOfficer) {
        this.reportingOfficer = reportingOfficer;
    }

    public Boolean getIsTeamHead() {
        return isTeamHead;
    }

    public void setIsTeamHead(Boolean isTeamHead) {
        this.isTeamHead = isTeamHead;
    }

    public Boolean getIsShiftIncharge() {
        return isShiftIncharge;
    }

    public void setIsShiftIncharge(Boolean isShiftIncharge) {
        this.isShiftIncharge = isShiftIncharge;
    }

    public Boolean getIsSecStaff() {
        return isSecStaff;
    }

    public void setIsSecStaff(Boolean isSecStaff) {
        this.isSecStaff = isSecStaff;
    }
}
