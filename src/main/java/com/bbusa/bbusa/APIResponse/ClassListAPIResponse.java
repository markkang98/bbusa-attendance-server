package com.bbusa.bbusa.APIResponse;

import com.bbusa.bbusa.Entity.AttendsEntity;
import com.bbusa.bbusa.Entity.ClassesEntity;
import com.bbusa.bbusa.Entity.InstructorEntity;

import java.io.Serializable;
import java.util.List;

public class ClassListAPIResponse implements Serializable {


    private List<InstructorEntity> instructorEntities;

    private ClassesEntity classesEntity;

    private String instructor_firstName;

    private String instructor_lastName;

    private int SID;

    public int getSID() {
        return SID;
    }

    public void setSID(int SID) {
        this.SID = SID;
    }

    public String getInstructor_firstName() {
        return instructor_firstName;
    }

    public void setInstructor_firstName(String instructor_firstName) {
        this.instructor_firstName = instructor_firstName;
    }

    public String getInstructor_lastName() {
        return instructor_lastName;
    }

    public void setInstructor_lastName(String instructor_lastName) {
        this.instructor_lastName = instructor_lastName;
    }

    public List<InstructorEntity> getInstructorEntities() {
        return instructorEntities;
    }

    public void setInstructorEntities(List<InstructorEntity> instructorEntities) {
        this.instructorEntities = instructorEntities;
    }

    public ClassesEntity getClassesEntity() {
        return classesEntity;
    }

    public void setClassesEntity(ClassesEntity classesEntity) {
        this.classesEntity = classesEntity;
    }


}
