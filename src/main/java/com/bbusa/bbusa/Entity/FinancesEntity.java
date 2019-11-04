package com.bbusa.bbusa.Entity;


import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.IdClass;
import javax.persistence.Table;
import java.io.Serializable;

@Entity
@Table(name = "Finances")
@IdClass(FinancesEntity.class)
public class FinancesEntity implements Serializable {

    @Id
    private int SID;

    @Id
    private int PID;


    public int getSID() {
        return SID;
    }

    public void setSID(int SID) {
        this.SID = SID;
    }

    public int getPID() {
        return PID;
    }

    public void setPID(int PID) {
        this.PID = PID;
    }


}
