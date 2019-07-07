package com.bbusa.bbusa.Authentication;

import org.springframework.stereotype.Service;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;

@Service
public class SHA256Hasher implements PasswordHash {

    private String securePassword;
    private byte [] salt;

    public void hashPassword(String password) throws NoSuchAlgorithmException{
        salt = createSalt();
        securePassword = get_SHA_256_SecurePassword(password, salt);
    }
    public String checkPassword(String password, byte [] salt){
        return get_SHA_256_SecurePassword(password, salt);
    }
    public String getSecurePassword(){
        return securePassword;
    }

    public byte[] getSalt(){
        return salt;
    }
    private static byte[] createSalt() throws NoSuchAlgorithmException {
        SecureRandom sr = SecureRandom.getInstance("SHA1PRNG");
        byte[] newSalt = new byte[16];
        sr.nextBytes(newSalt);
        return newSalt;
    }

    private static String get_SHA_256_SecurePassword(String passwordToHash, byte[] salt) {
        String generatedPassword = null;
        try {
            MessageDigest md = MessageDigest.getInstance("SHA-256");
            md.update(salt);
            byte[] bytes = md.digest(passwordToHash.getBytes());
            StringBuilder sb = new StringBuilder();
            for(int i=0; i< bytes.length ;i++)
            {
                sb.append(Integer.toString((bytes[i] & 0xff) + 0x100, 16).substring(1));
            }
            generatedPassword = sb.toString();
        }
        catch (NoSuchAlgorithmException e)
        {
            e.printStackTrace();
        }
        return generatedPassword;
    }
}
