package com.bbusa.bbusa.Entity;


import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.IdClass;
import javax.persistence.Table;
import java.io.Serializable;

@Entity
@Table(name = "authentication")
@IdClass(AuthenticationEntity.class)
public class AuthenticationEntity implements Serializable {

    @Id
    private String user_id;

    private String hashed_password;

    private byte[] salt;

    public AuthenticationEntity(){

    }
    public AuthenticationEntity(String user_id, String hashed_password, byte [] salt){
        this.user_id = user_id;
        this.hashed_password = hashed_password;
        this.salt = salt;
    }

    public String getUser_id() {
        return user_id;
    }

    public void setUser_id(String user_id) {
        this.user_id = user_id;
    }

    public String getHashed_password() {
        return hashed_password;
    }

    public void setHashed_password(String hashed_password) {
        this.hashed_password = hashed_password;
    }

    public byte [] getSalt() {
        return salt;
    }

    public void setSalt(byte [] salt) {
        this.salt = salt;
    }


}
