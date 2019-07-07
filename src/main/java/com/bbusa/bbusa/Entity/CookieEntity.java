package com.bbusa.bbusa.Entity;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.IdClass;
import javax.persistence.Table;
import java.io.Serializable;

@Entity
@Table(name = "cookie")
@IdClass(CookieEntity.class)
public class CookieEntity implements Serializable {

    @Id
    private String cookie;

    private byte [] cookie_salt;

    private String user_id;

    public CookieEntity(){

    }

    public CookieEntity(String user_id, String cookie, byte [] cookieSalt){
        this.user_id = user_id;
        this.cookie = cookie;
        this.cookie_salt = cookieSalt;
    }

    public byte[] getCookieSalt() {
        return cookie_salt;
    }

    public void setCookieSalt(byte[] cookieSalt) {
        this.cookie_salt = cookieSalt;
    }

    public String getCookie() {
        return cookie;
    }

    public void setCookie(String cookie) {
        this.cookie = cookie;
    }

    public String getUser_id() {
        return user_id;
    }

    public void setUser_id(String user_id) {
        this.user_id = user_id;
    }
}
