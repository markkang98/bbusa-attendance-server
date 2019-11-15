package com.bbusa.bbusa.Entity;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.IdClass;
import javax.persistence.Table;
import java.io.Serializable;
import java.sql.Date;
import java.sql.Time;

@Entity
@Table(name = "Classes")
//@IdClass(ClassesEntity.class)
public class ClassesEntity implements Serializable {
    @Id
    private int CID;

    private Time start_time;

    private Time end_time;

    private int target_start_age;

    private int target_older_age;

    private String description;

    public int getCID() {
        return CID;
    }

    public void setCID(int CID) {
        this.CID = CID;
    }

    public Time getStart_date() {
        return start_time;
    }

    public void setStart_date(Time start_date) {
        this.start_time = start_date;
    }

    public Time getEnd_date() {
        return end_time;
    }

    public void setEnd_date(Time end_date) {
        this.end_time = end_date;
    }

    public int getTarget_start_age() {
        return target_start_age;
    }

    public void setTarget_start_age(int target_start_age) {
        this.target_start_age = target_start_age;
    }

    public int getTarget_older_age() {
        return target_older_age;
    }

    public void setTarget_older_age(int target_older_age) {
        this.target_older_age = target_older_age;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }



}
