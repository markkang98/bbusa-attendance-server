package com.bbusa.bbusa.Entity;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.IdClass;
import javax.persistence.Table;
import java.io.Serializable;

@Entity
@Table(name = "Parent")
@IdClass(ParentEntity.class)
public class ParentEntity implements Serializable {
    @Id
    private int PID;

    private String parent_email;

    private String phone_number;

    public int getPID() {
        return PID;
    }

    public void setPID(int PID) {
        this.PID = PID;
    }

    public String getParentEmail() {
        return parent_email;
    }

    public void setParentEmail(String parentEmail) {
        this.parent_email = parent_email;
    }

    public String getPhone_number() {
        return phone_number;
    }

    public void setPhone_number(String phone_number) {
        this.phone_number = phone_number;
    }


}
