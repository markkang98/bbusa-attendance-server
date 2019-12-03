package com.bbusa.bbusa.Controller;

import com.bbusa.bbusa.Authentication.PasswordHash;
import com.bbusa.bbusa.Entity.RegisteredUserEntity;
import com.bbusa.bbusa.Entity.CookieEntity;
import com.bbusa.bbusa.Repository.CookieRepository;
import com.bbusa.bbusa.Repository.RegisteredUserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.Cookie;

import javax.servlet.http.HttpServletResponse;
import java.security.NoSuchAlgorithmException;

@RestController("/authentication")
public class AuthenticationController {
    private static final String USERID_PARAM = "userid";

    private static final String PASSWORD_PARAM = "password";

    private static final String FIRST_NAME = "firstName";

    private static final String LAST_NAME = "lastName";

    private static final String COOKIE_KEY = "CURRENTUSER";

    private static final String EMPTY_VALUE = "";

    @Autowired
    private PasswordHash passwordHasher;

    @Autowired
    private RegisteredUserRepository registeredUserRepository;

    @Autowired
    private CookieRepository cookieRepository;

    @Value("${cors.host}")
    private String corsHost;

    @PostMapping("{contextPath}/registration")
    public RegisteredUserEntity createUser(HttpServletResponse httpServletResponse,
                                           @RequestParam(value = USERID_PARAM) String user_email,
                                           @RequestParam(value = PASSWORD_PARAM) String password,
                                            @RequestParam(value = FIRST_NAME) String first_name,
                                            @RequestParam(value = LAST_NAME) String last_name)

    {
        addCrossOrigins(httpServletResponse);
        try {
            passwordHasher.hashPassword(password);
        } catch (NoSuchAlgorithmException ex) {
            throw new RuntimeException();
        }
        String securePassword = passwordHasher.getSecurePassword();
        byte[] salt = passwordHasher.getSalt();
        RegisteredUserEntity authenticationEntity = new RegisteredUserEntity();
        authenticationEntity.setEmail(user_email);
        authenticationEntity.setSalt(salt);
        authenticationEntity.setHashed_password(securePassword);
        authenticationEntity.setFirst_name(first_name.toLowerCase());
        authenticationEntity.setLast_name(last_name.toLowerCase());
        return registeredUserRepository.save(authenticationEntity);
    }

    @PostMapping("{contextPath}/login")
    public ResponseEntity verifyUser(HttpServletResponse httpServletResponse, @RequestParam(value = USERID_PARAM) String user_id, @RequestParam(value = PASSWORD_PARAM) String password) throws NoSuchAlgorithmException{
        addCrossOrigins(httpServletResponse);
        byte [] salt = registeredUserRepository.getSalt(user_id);
        if(registeredUserRepository.getHashedPassword(user_id).equals(passwordHasher.checkPassword(password, salt))) {
            passwordHasher.hashPassword(user_id + password);
            byte [] cookieSalt = passwordHasher.getSalt();
            String hashedCookie = passwordHasher.getSecurePassword();
            Cookie cookie = new Cookie(COOKIE_KEY,  hashedCookie);
            cookie.setMaxAge(Integer.MAX_VALUE);
            CookieEntity cookieEntity = new CookieEntity(user_id, hashedCookie, cookieSalt);
            cookieRepository.save(cookieEntity);
            httpServletResponse.addCookie(cookie);
            return ResponseEntity.status(HttpStatus.ACCEPTED).build();
        }else{
            return ResponseEntity.status(HttpStatus.PRECONDITION_FAILED).build();
        }
    }

    @GetMapping("{contextPath}/getCurrentUser")
    public String getCurrentUser(HttpServletResponse httpServletResponse, @CookieValue(name = COOKIE_KEY, defaultValue = "not working") String cookie){
        //TODO: MAKE LOGIC FOR CHECKING IF COOKIE IS VERIFIED
        addCrossOrigins(httpServletResponse);
        try{
            return cookieRepository.findLoggedInUser(cookie).getUser_id();
        }catch(NullPointerException ex){
            return EMPTY_VALUE;
        }
    }

    @PostMapping("{contextPath}/logOut")
    public ResponseEntity logOut(HttpServletResponse httpServletResponse, @CookieValue(name = COOKIE_KEY, defaultValue = "not working") String cookie){
        Cookie emptyCookie = new Cookie(COOKIE_KEY, EMPTY_VALUE);
        addCrossOrigins(httpServletResponse);
        emptyCookie.setMaxAge(0);
        httpServletResponse.addCookie(emptyCookie);
        CookieEntity currentCookie = cookieRepository.findLoggedInUser(cookie);
        cookieRepository.delete(currentCookie);
        return ResponseEntity.status(HttpStatus.ACCEPTED).build();
    }

    private void addCrossOrigins(HttpServletResponse httpServletResponse){
        httpServletResponse.addHeader("Access-Control-Allow-Origin", corsHost);
        httpServletResponse.addHeader("Access-Control-Allow-Credentials", "true");
    }
}
