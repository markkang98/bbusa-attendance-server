package com.bbusa.bbusa.Entity;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.IdClass;
import javax.persistence.Table;
import java.io.Serializable;
import java.sql.Date;

@Entity
@Table(name = "Attends")
@IdClass(AttendsEntity.class)
public class AttendsEntity implements Serializable {
    @Id
    private int SID;

    @Id
    private int CID;

    @Id
    private Date attend_date;

    private String attendance;

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

    public Date getAttendDate() {
        return attend_date;
    }

    public void setAttendDate(Date attendDate) {
        this.attend_date = attendDate;
    }

    public String getAttendance() {
        return attendance;
    }

    public void setAttendance(String attendance) {
        this.attendance = attendance;
    }



}
