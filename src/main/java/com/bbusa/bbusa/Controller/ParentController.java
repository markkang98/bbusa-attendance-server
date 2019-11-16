package com.bbusa.bbusa.Controller;

import com.bbusa.bbusa.Entity.ParentEntity;
import com.bbusa.bbusa.Entity.StudentEntity;
import com.bbusa.bbusa.Repository.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpServletResponse;
import java.util.ArrayList;
import java.util.List;

public class ParentController {
    @Value("{cors.host}")
    private String corsHost;

    @Autowired
    private ClassesRepository classesRepository;

    @Autowired
    private StudentRepository studentRepository;

    @Autowired
    private InstructorRepository instructorRepository;

    @Autowired
    private AttendsRepository attendsRepository;

    @Autowired
    private ParentRepository parentRepository;

    @GetMapping("{contextPath}/getParentProfile")
    public List<ParentEntity> getParentEntity(HttpServletResponse httpServletResponse, @RequestParam String parent_email){
        addCrossOrigins(httpServletResponse);
        return parentRepository.getParentProfile(parent_email);
    }

    private void addCrossOrigins(HttpServletResponse httpServletResponse){
        httpServletResponse.addHeader("Access-Control-Allow-Origin", corsHost);
        httpServletResponse.addHeader("Access-Control-Allow-Credentials", "true");
        httpServletResponse.addHeader("Access-Control-Allow-Headers", "Authorization");
    }


}
