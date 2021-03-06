package com.bbusa.bbusa.Entity;


import org.springframework.lang.Nullable;

import javax.persistence.*;
import java.io.Serializable;
import java.sql.Date;

@Entity
@Table(name = "Takes")
@IdClass(TakesEntity.class)
public class TakesEntity implements Serializable {

    @Id
    private int SID;

    @Id
    private int CID;

    private Date start_date;

//    @Nullable
//    private Date end_date;

    private boolean verified;

    public boolean isVerified() {
        return verified;
    }

    public void setVerified(boolean verified) {
        this.verified = verified;
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

    public Date getStart_date() {
        return start_date;
    }

    public void setStart_date(Date start_date) {
        this.start_date = start_date;
    }

//    public Date getEnd_date() {
//        return end_date;
//    }
//
//    public void setEnd_date(Date end_date) {
//        this.end_date = end_date;
//    }
}
