package com.bbusa.bbusa.Controller;

import com.bbusa.bbusa.Authentication.PasswordHash;
import com.bbusa.bbusa.Entity.AuthenticationEntity;
import com.bbusa.bbusa.Entity.BeltColor;
import com.bbusa.bbusa.Entity.ContractType;
import com.bbusa.bbusa.Entity.StudentEntity;
import com.bbusa.bbusa.Repository.AuthenticationRepository;
import com.bbusa.bbusa.Repository.StudentInformationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletResponse;
import java.security.NoSuchAlgorithmException;

@RestController
public class AuthenticationController {

    @Autowired
    private StudentInformationRepository studentInformationRepository;

    @Autowired
    private AuthenticationRepository authenticationRepository;

    @Autowired
    private PasswordHash passwordHasher;

    private static final String USERID_PARAM = "userid";

    private static final String PASSWORD_PARAM = "password";

    private static final String FIRST_NAME = "firstName";

    private static final String LAST_NAME = "lastName";

    private static final String BELT_COLOR = "beltColor";

    private static final String CONTRACT_TYPE = "contractType";

    private static final String COOKIE_KEY = "CURRENTUSER";

    @PostMapping("/registration")
    @CrossOrigin
    public AuthenticationEntity createUser(@RequestParam(value = USERID_PARAM) String user_id, @RequestParam(value = PASSWORD_PARAM) String password) {
        try {
            passwordHasher.hashPassword(password);
        } catch (NoSuchAlgorithmException ex) {
            //TODO: ADD HTTP EXCEPTION
        }
        String securePassword = passwordHasher.getSecurePassword();
        byte[] salt = passwordHasher.getSalt();
        AuthenticationEntity authenticationEntity = new AuthenticationEntity(user_id, securePassword, salt);
        return authenticationRepository.save(authenticationEntity);
    }

    @GetMapping("/login")
    @CrossOrigin(origins = "http://attendance.trial.com:3000/")
    public ResponseEntity verifyUser(HttpServletResponse httpServletResponse, @RequestParam(value = USERID_PARAM) String user_id, @RequestParam(value = PASSWORD_PARAM) String password){
        byte [] salt = authenticationRepository.getSalt(user_id);
        if(authenticationRepository.getHashedPassword(user_id).equals(passwordHasher.checkPassword(password, salt))) {
            try {
               passwordHasher.hashPassword(user_id + password);
               byte [] cookieSalt = passwordHasher.getSalt();
               String hashedCookie = passwordHasher.getSecurePassword();
               httpServletResponse.addCookie(new Cookie(COOKIE_KEY,  hashedCookie));
               //TODO: MAKE AN ENETITY TO STORE THE HASHED COOKIE AND SALT
               System.out.println(hashedCookie);
            }catch (NoSuchAlgorithmException ex){
                return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
            }
            return ResponseEntity.status(HttpStatus.OK).build();
        }else{
            return ResponseEntity.status(HttpStatus.PRECONDITION_FAILED).build();
        }
    }
    @GetMapping("/getCurrentUser")
    @CrossOrigin(origins = "http://attendance.trial.com:3000/")
    public String getCurrentUser(@CookieValue(name = COOKIE_KEY, defaultValue = "not working") String cookie){
        //TODO: MAKE LOGIC FOR CHECKING IF COOKIE IS VERIFIED
        System.out.println(cookie);
        return cookie;

    }

    @PostMapping("/enterStudentInformation")
    @CrossOrigin
    public StudentEntity addUserInformation(@RequestParam(value = USERID_PARAM) String instructor_id, @RequestParam(value = BELT_COLOR) String belt_color,
                                            @RequestParam(value = CONTRACT_TYPE) String contract_type,
                                            @RequestParam(value = FIRST_NAME) String first_name, @RequestParam(value = LAST_NAME) String last_name) {

        StudentEntity studentEntity = new StudentEntity(instructor_id, BeltColor.valueOf(belt_color.toUpperCase()), ContractType.valueOf(contract_type.toUpperCase()), first_name, last_name);
        return studentInformationRepository.save(studentEntity);
    }
}