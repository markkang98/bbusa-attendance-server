package com.bbusa.bbusa.Controller;

import com.bbusa.bbusa.APIResponse.ClassListAPIResponse;
import com.bbusa.bbusa.Entity.AttendsEntity;
import com.bbusa.bbusa.Entity.ClassesEntity;
import com.bbusa.bbusa.Entity.InstructorEntity;
import com.bbusa.bbusa.Entity.StudentEntity;
import com.bbusa.bbusa.Repository.AttendsRepository;
import com.bbusa.bbusa.Repository.ClassesRepository;
import com.bbusa.bbusa.Repository.InstructorRepository;
import com.bbusa.bbusa.Repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletResponse;
import java.util.ArrayList;
import java.util.List;

@RestController("/student")
public class StudentController {

    private static final String STUDENT_EMAIL = "studentEmail";

    private static final String AGE = "age";

    private static final String EMERGENCY_CONTACT_NAME = "emergencyContactName";

    private static final String EMERGENCY_CONTACT_NUMBER = "emergencyContactNumber";

    private static final String GENDER = "gender";

    private static final String BELT = "belt";

    @Value("${cors.host}")
    private String corsHost;

    @Autowired
    private ClassesRepository classesRepository;

    @Autowired
    private StudentRepository studentRepository;

    @Autowired
    private InstructorRepository instructorRepository;

    @Autowired
    private AttendsRepository attendsRepository;


    @GetMapping("{contextPath}/getClassList")
    public List<ClassListAPIResponse> getClassList(HttpServletResponse httpServletResponse, @RequestParam String student_email){
        addCrossOrigins(httpServletResponse);
        List<ClassListAPIResponse> classList = new ArrayList<>();
        List<ClassesEntity> classesEntities =  classesRepository.getListOfClassesOfStudent(student_email);

        for(ClassesEntity classesEntity: classesEntities){
            ClassListAPIResponse classListAPIResponse = new ClassListAPIResponse();
            int CID = classesEntity.getCID();
            List<InstructorEntity> instructorEntities = instructorRepository.getClassProfile(CID);
            List<AttendsEntity> attendsEntities = attendsRepository.getClassAttends(student_email, CID);
            classListAPIResponse.setAttendsEntities(attendsEntities);
            classListAPIResponse.setClassesEntity(classesEntity);
            classListAPIResponse.setInstructorEntities(instructorEntities);
            classList.add(classListAPIResponse);
        }

        return classList;
    }

    @PutMapping("/addNewStudent")
    @CrossOrigin(origins = "http://localhost:3000", allowCredentials = "true")
    public StudentEntity addNewStudent(@RequestParam(value = STUDENT_EMAIL) String student_email,
                              @RequestParam(value = AGE) int age,
                              @RequestParam(value = EMERGENCY_CONTACT_NAME) String emergency_contact_name,
                              @RequestParam(value = EMERGENCY_CONTACT_NUMBER) String emergency_contact_number,
                              @RequestParam(value = GENDER) String  gender,
                              @RequestParam(value = BELT) String belt){
        StudentEntity studentEntity = new StudentEntity();
        studentEntity.setAge(age);
        studentEntity.setBelt(belt);
        studentEntity.setEmergency_contact_name(emergency_contact_name);
        studentEntity.setEmergency_contact_number(emergency_contact_number);
        studentEntity.setGender(gender);
        studentEntity.setStudent_email(student_email);
        return studentRepository.save(studentEntity);
    }

    @GetMapping("{contextPath}/getStudentProfile")
    public List<StudentEntity> getStudentEntity(HttpServletResponse httpServletResponse, @RequestParam String student_email){
        addCrossOrigins(httpServletResponse);
        return studentRepository.getStudentProfile(student_email);
    }

    //TODO: We need to create a way to edit a student's profile
    //TODO: EMAIL
    //TODO: BELT
    //TODO: AGE
    //TODO: EMERGENCY CONTACT NAME
    //TODO: EMERGENCY CONTACT NUMBER
    private void addCrossOrigins(HttpServletResponse httpServletResponse){
        httpServletResponse.addHeader("Access-Control-Allow-Origin", corsHost);
        httpServletResponse.addHeader("Access-Control-Allow-Credentials", "true");
    }
}
