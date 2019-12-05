package com.bbusa.bbusa.APIResponse;

import javax.persistence.Entity;
import javax.persistence.Id;
import java.io.Serializable;
import java.sql.Time;

public class FullClassInfoAPIResponse implements Serializable {

    private Time start_time;

    private Time end_time;

    private int target_start_age;

    private int target_end_age;

    private String description;

    private String belt;

    private String email;

    private String first_name;

    private String last_name;
    private int SID;

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

    private int CID;
    public Time getStart_time() {
        return start_time;
    }

    public void setStart_time(Time start_time) {
        this.start_time = start_time;
    }

    public Time getEnd_time() {
        return end_time;
    }

    public void setEnd_time(Time end_time) {
        this.end_time = end_time;
    }

    public int getTarget_start_age() {
        return target_start_age;
    }

    public void setTarget_start_age(int target_start_age) {
        this.target_start_age = target_start_age;
    }

    public int getTarget_end_age() {
        return target_end_age;
    }

    public void setTarget_end_age(int target_end_age) {
        this.target_end_age = target_end_age;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getBelt() {
        return belt;
    }

    public void setBelt(String belt) {
        this.belt = belt;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getFirst_name() {
        return first_name;
    }

    public void setFirst_name(String first_name) {
        this.first_name = first_name;
    }

    public String getLast_name() {
        return last_name;
    }

    public void setLast_name(String last_name) {
        this.last_name = last_name;
    }
}
