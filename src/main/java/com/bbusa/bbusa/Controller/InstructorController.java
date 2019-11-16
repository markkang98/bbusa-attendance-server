package com.bbusa.bbusa.Controller;

import com.bbusa.bbusa.APIResponse.ClassListAPIResponse;
import com.bbusa.bbusa.Entity.ClassesEntity;
import com.bbusa.bbusa.Entity.InstructorEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletResponse;
import java.util.ArrayList;
import java.util.List;

@RestController
public class InstructorController {

    //get profile
    //get list of classes

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
    //add instructor
    //add student and parent

}
