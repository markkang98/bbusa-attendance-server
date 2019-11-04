package com.bbusa.bbusa.Entity;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.IdClass;
import javax.persistence.Table;
import java.io.Serializable;
import java.sql.Date;

@Entity
@Table(name = "Classes")
@IdClass(ClassesEntity.class)
public class ClassesEntity implements Serializable {
    @Id
    private int CID;

    private Date start_date;

    private Date end_date;

    private int target_start_age;

    private int target_older_age;

    private String description;

    public int getCID() {
        return CID;
    }

    public void setCID(int CID) {
        this.CID = CID;
    }

    public Date getStart_date() {
        return start_date;
    }

    public void setStart_date(Date start_date) {
        this.start_date = start_date;
    }

    public Date getEnd_date() {
        return end_date;
    }

    public void setEnd_date(Date end_date) {
        this.end_date = end_date;
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
