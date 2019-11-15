package com.bbusa.bbusa.Controller;

import com.bbusa.bbusa.APIResponse.ClassListAPIResponse;
import com.bbusa.bbusa.Entity.ClassesEntity;
import com.bbusa.bbusa.Entity.InstructorEntity;
import com.bbusa.bbusa.Entity.StudentEntity;
import com.bbusa.bbusa.Repository.ClassesRepository;
import com.bbusa.bbusa.Repository.InstructorRepository;
import com.bbusa.bbusa.Repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletResponse;
import java.util.ArrayList;
import java.util.List;

@RestController
public class StudentController {
    @Value("${cors.host}")
    private String corsHost;

    @Autowired
    private ClassesRepository classesRepository;

    @Autowired
    private StudentRepository studentRepository;

    @Autowired
    private InstructorRepository instructorRepository;

    @GetMapping("/getClassList")
    public List<ClassListAPIResponse> getClassList(HttpServletResponse httpServletResponse, @RequestParam String student_email){
        addCrossOrigins(httpServletResponse);
        List<ClassListAPIResponse> classList = new ArrayList<>();
        List<ClassesEntity> classesEntities =  classesRepository.getListOfClassesOfStudent(student_email);

        for(ClassesEntity classesEntity: classesEntities){
            ClassListAPIResponse classListAPIResponse = new ClassListAPIResponse();
            int CID = classesEntity.getCID();
            List<InstructorEntity> instructorEntities = instructorRepository.getClassProfile(CID);
            classListAPIResponse.setClassesEntity(classesEntity);
            classListAPIResponse.setInstructorEntities(instructorEntities);
            classList.add(classListAPIResponse);
        }

        return classList;
    }

    @GetMapping("/getStudentProfile")
    public List<StudentEntity> getStudentEntity(HttpServletResponse httpServletResponse, @RequestParam String student_email){
        addCrossOrigins(httpServletResponse);
        return studentRepository.getStudentProfile(student_email);
    }
    private void addCrossOrigins(HttpServletResponse httpServletResponse){
        httpServletResponse.addHeader("Access-Control-Allow-Origin", corsHost);
        httpServletResponse.addHeader("Access-Control-Allow-Credentials", "true");
    }
}
