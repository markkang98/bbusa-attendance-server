package com.bbusa.bbusa.Entity.curr;


import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.IdClass;
import javax.persistence.Table;
import java.sql.Date;

@Entity
@Table(name = "Teaches")
@IdClass(TeachesEntity.class)
public class TeachesEntity {

    @Id
    private int IID;

    @Id
    private int CID;

    private Date start_date;

    private Date end_date;

    public int getIID() {
        return IID;
    }

    public void setIID(int IID) {
        this.IID = IID;
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

    public Date getEnd_date() {
        return end_date;
    }

    public void setEnd_date(Date end_date) {
        this.end_date = end_date;
    }
}
