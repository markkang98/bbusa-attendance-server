package com.bbusa.bbusa.APIResponse;

import java.io.Serializable;
import java.sql.Time;

public class ClassRequestAPIResponse implements Serializable {

    private String studentFirstName;

    private String studentLastName;

    private int SID;

    private int CID;

    private String description;

    private Time startTime;

    private Time endTime;

    private int startAge;

    private int olderAge;

    public String getStudentFirstName() {
        return studentFirstName;
    }

    public void setStudentFirstName(String studentFirstName) {
        this.studentFirstName = studentFirstName;
    }

    public String getStudentLastName() {
        return studentLastName;
    }

    public void setStudentLastName(String studentLastName) {
        this.studentLastName = studentLastName;
    }

    public int getSID() {
        return SID;
    }

    public void setSID(int SID) {
        this.SID = SID;
    }

    public int getCID() {
        return CID;
    }

    public void setCID(int CID) {
        this.CID = CID;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Time getStartTime() {
        return startTime;
    }

    public void setStartTime(Time startTime) {
        this.startTime = startTime;
    }

    public Time getEndTime() {
        return endTime;
    }

    public void setEndTime(Time endTime) {
        this.endTime = endTime;
    }

    public int getStartAge() {
        return startAge;
    }

    public void setStartAge(int startAge) {
        this.startAge = startAge;
    }

    public int getOlderAge() {
        return olderAge;
    }

    public void setOlderAge(int olderAge) {
        this.olderAge = olderAge;
    }
}
