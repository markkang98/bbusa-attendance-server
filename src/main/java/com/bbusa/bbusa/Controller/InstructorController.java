package com.bbusa.bbusa.Controller;

import com.bbusa.bbusa.APIResponse.ClassListAPIResponse;
import com.bbusa.bbusa.Entity.ClassesEntity;
import com.bbusa.bbusa.Entity.InstructorEntity;
import com.bbusa.bbusa.Repository.ClassesRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletResponse;
import java.util.ArrayList;
import java.util.List;



@RestController
public class InstructorController {

    @Value("${cors.host}")
    private static String corsHost;

    private static final String INSTRUCTOR = "instructor";

    @Autowired
    private ClassesRepository classesRepository;

    @GetMapping("/instructorClasses")
    @CrossOrigin(origins = "http://localhost:3000", allowCredentials = "true")
    public List<ClassesEntity> getInstructorClasses(@RequestParam(value = INSTRUCTOR) String instructor_email){
        List<ClassesEntity> classesEntities = classesRepository.getListOfClassesOfInstructor(instructor_email);
        return classesEntities;
    }

    //TODO: get profile
    //TODO: add instructor
    //TODO: add student and parent

}
