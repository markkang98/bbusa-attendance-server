package com.bbusa.bbusa.Authentication;

import java.security.NoSuchAlgorithmException;

public interface PasswordHash {
    void hashPassword(String password) throws NoSuchAlgorithmException;

    String getSecurePassword();

    byte[] getSalt();

    String checkPassword(String password, byte [] salt);
}
