package com.bbusa.bbusa.Entity;

import org.springframework.stereotype.Component;

import java.io.Serializable;
import java.util.List;

@Component
public class StudentAPIResponse implements Serializable {
    private List<StudentEntity> allUsers;

    public List<StudentEntity> getAllUsers() {
        return allUsers;
    }

    public void setAllUsers(List<StudentEntity> allUsers) {
        this.allUsers = allUsers;
    }
}
