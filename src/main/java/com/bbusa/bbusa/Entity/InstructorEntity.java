package com.bbusa.bbusa.Entity;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.IdClass;
import javax.persistence.Table;
import java.io.Serializable;

@Entity
@Table(name = "Instructor")
@IdClass(InstructorEntity.class)
public class InstructorEntity implements Serializable {

    @Id
    private int IID;

    private String instructor_email;

    private String belt;

    public int getIID() {
        return IID;
    }

    public void setIID(int IID) {
        this.IID = IID;
    }

    public String getInstructorEmail() {
        return instructor_email;
    }

    public void setInstructorEmail(String instructorEmail) {
        this.instructor_email = instructorEmail;
    }

    public String getBelt() {
        return belt;
    }

    public void setBelt(String belt) {
        this.belt = belt;
    }
}
