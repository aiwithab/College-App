package com.aiwithab.collegeapp.model;

public class UserInformation {
    private String name,email,branches,year;
    private long rollno;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getBranches() {
        return branches;
    }

    public void setBranches(String branches) {
        this.branches = branches;
    }

    public String getYear() {
        return year;
    }

    public void setYear(String year) {
        this.year = year;
    }

    public long getRollno() {
        return rollno;
    }

    public void setRollno(long rollno) {
        this.rollno = rollno;
    }
}
