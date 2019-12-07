package com.bbusa.bbusa.Controller;

import com.bbusa.bbusa.APIResponse.ClassListAPIResponse;
import com.bbusa.bbusa.APIResponse.FullClassInfoAPIResponse;
import com.bbusa.bbusa.Entity.*;
import com.bbusa.bbusa.Repository.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletResponse;
import java.sql.Time;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

@RestController("/student")
public class StudentController {

    private static final String STUDENT_EMAIL = "studentEmail";

    private static final String AGE = "age";

    private static final String EMERGENCY_CONTACT_NAME = "emergencyContactName";

    private static final String EMERGENCY_CONTACT_NUMBER = "emergencyContactNumber";

    private static final String GENDER = "gender";

    private static final String BELT = "belt";

    private static final String CID = "cid";

    private static final String SID = "sid";

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

    @Autowired
    private RegisteredUserRepository registeredUserRepository;

    @Autowired
    private TakesRepository takesRepository;

    @GetMapping("{contextPath}/getClassList")
    public List<ClassListAPIResponse> getClassList(HttpServletResponse httpServletResponse, @RequestParam String student_email){
        addCrossOrigins(httpServletResponse);
        List<ClassListAPIResponse> classList = new ArrayList<>();
        List<ClassesEntity> classesEntities =  classesRepository.getListOfClassesOfStudent(student_email);
        List<StudentEntity> studentEntities = studentRepository.getStudentProfile(student_email);
        int SID = studentEntities.get(0).getSID();
        for(ClassesEntity classesEntity: classesEntities){
            ClassListAPIResponse classListAPIResponse = new ClassListAPIResponse();
            int CID = classesEntity.getCID();
            List<InstructorEntity> instructorEntities = instructorRepository.getClassProfile(CID);
            classListAPIResponse.setSID(SID);
            classListAPIResponse.setClassesEntity(classesEntity);
            classListAPIResponse.setInstructorEntities(instructorEntities);
            classListAPIResponse.setInstructor_firstName(registeredUserRepository.getFirstName(instructorEntities.get(0).getInstructorEmail()));
            classListAPIResponse.setInstructor_lastName(registeredUserRepository.getLastName(instructorEntities.get(0).getInstructorEmail()));
            classList.add(classListAPIResponse);
        }

        return classList;
    }

    @GetMapping("/getAllClasses")
    @CrossOrigin(origins = "http://localhost:3000", allowCredentials = "true")
    public List<FullClassInfoAPIResponse> getAllClasses(@RequestParam String student_email){
        List<String> stringList =  classesRepository.getAllClasses();
        List<FullClassInfoAPIResponse> fullClassInfoEntities = new ArrayList<>();
        for(String row: stringList){
            String [] columns = row.split(",");
            FullClassInfoAPIResponse fullClassInfoAPIResponse = new FullClassInfoAPIResponse();
            fullClassInfoAPIResponse.setEmail(columns[0]);
            fullClassInfoAPIResponse.setFirst_name(columns[1]);
            fullClassInfoAPIResponse.setLast_name(columns[2]);
            fullClassInfoAPIResponse.setBelt(columns[3]);
            fullClassInfoAPIResponse.setStart_time(Time.valueOf(columns[4]));
            fullClassInfoAPIResponse.setEnd_time(Time.valueOf(columns[5]));
            fullClassInfoAPIResponse.setTarget_start_age(Integer.parseInt(columns[6]));
            fullClassInfoAPIResponse.setTarget_end_age(Integer.parseInt(columns[7]));
            fullClassInfoAPIResponse.setDescription(columns[8]);
            fullClassInfoAPIResponse.setCID(Integer.parseInt(columns[9]));
            fullClassInfoAPIResponse.setSID(studentRepository.getStudentProfile(student_email).get(0).getSID());
            fullClassInfoEntities.add(fullClassInfoAPIResponse);
        }
        return fullClassInfoEntities;
    }

    @PutMapping("/registerClass")
    @CrossOrigin(origins = "http://localhost:3000", allowCredentials = "true")
    public TakesEntity registerClass(@RequestParam int CID,
                              @RequestParam int SID){
        TakesEntity takesEntity = new TakesEntity();
        takesEntity.setCID(CID);
        takesEntity.setSID(SID);
        java.sql.Date date = new java.sql.Date(Calendar.getInstance().getTime().getTime());
        takesEntity.setStart_date(date);
        takesEntity.setVerified(false);
        return takesRepository.save(takesEntity);
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
    @CrossOrigin(origins = "http://localhost:3000", allowCredentials = "true")
    public List<StudentEntity> getStudentEntity(@RequestParam String student_email){
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
