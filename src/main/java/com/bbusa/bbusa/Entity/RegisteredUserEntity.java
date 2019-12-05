package com.bbusa.bbusa.Entity;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "RegisteredUser")
@IdClass(RegisteredUserEntity.class)

public class RegisteredUserEntity implements Serializable {

    @Id
    private String email;

    private String first_name;

    private String last_name;

//    private String password;

    private String hashed_password;

    private byte[] salt;

    public RegisteredUserEntity(){

    }

    public String getHashed_password() {
        return hashed_password;
    }

    public void setHashed_password(String hashed_password) {
        this.hashed_password = hashed_password;
    }

    public byte[] getSalt() {
        return salt;
    }

    public void setSalt(byte[] salt) {
        this.salt = salt;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

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

//    public String getPassword() {
//        return password;
//    }
//
//    public void setPassword(String password) {
//        this.password = password;
//    }



}
