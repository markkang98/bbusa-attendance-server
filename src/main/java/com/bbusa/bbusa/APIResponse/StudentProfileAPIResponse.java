package com.bbusa.bbusa.APIResponse;

import com.bbusa.bbusa.Entity.StudentEntity;

import java.io.Serializable;

public class StudentProfileAPIResponse implements Serializable {

    private String first_name;

    private String last_name;

    private StudentEntity studentEntity;

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

    public StudentEntity getStudentEntity() {
        return studentEntity;
    }

    public void setStudentEntity(StudentEntity studentEntity) {
        this.studentEntity = studentEntity;
    }
}
