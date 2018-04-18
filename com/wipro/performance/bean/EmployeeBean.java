package com.wipro.performance.bean;

import java.util.Date;

/**
 * Created by MU391764 on 18-Apr-18.
 */
public class EmployeeBean {
    private String ADID;
    private String empName;
    private String businessUnit;
    private Date dateOfJoining;
    private float currentSalary;
    private float totalAttendance;
    private float managerRating;

    public String getADID() {
        return ADID;
    }

    public void setADID(String ADID) {
        this.ADID = ADID;
    }

    public String getEmpName() {
        return empName;
    }

    public void setEmpName(String empName) {
        this.empName = empName;
    }

    public String getBusinessUnit() {
        return businessUnit;
    }

    public void setBusinessUnit(String businessUnit) {
        this.businessUnit = businessUnit;
    }

    public Date getDateOfJoining() {
        return dateOfJoining;
    }

    public void setDateOfJoining(Date dateOfJoining) {
        this.dateOfJoining = dateOfJoining;
    }

    public float getCurrentSalary() {
        return currentSalary;
    }

    public void setCurrentSalary(float currentSalary) {
        this.currentSalary = currentSalary;
    }

    public float getTotalAttendance() {
        return totalAttendance;
    }

    public void setTotalAttendance(float totalAttendance) {
        this.totalAttendance = totalAttendance;
    }

    public float getManagerRating() {
        return managerRating;
    }

    public void setManagerRating(float managerRating) {
        this.managerRating = managerRating;
    }
}
