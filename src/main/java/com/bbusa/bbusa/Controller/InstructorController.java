package com.bbusa.bbusa.Controller;

import com.bbusa.bbusa.APIResponse.ClassListAPIResponse;
import com.bbusa.bbusa.APIResponse.InstructorProfileAPIResponse;
import com.bbusa.bbusa.Entity.ClassesEntity;
import com.bbusa.bbusa.Entity.InstructorEntity;
import com.bbusa.bbusa.Entity.RegisteredUserEntity;
import com.bbusa.bbusa.Entity.TeachesEntity;
import com.bbusa.bbusa.Repository.ClassesRepository;
import com.bbusa.bbusa.Repository.InstructorRepository;
import com.bbusa.bbusa.Repository.RegisteredUserRepository;
import com.bbusa.bbusa.Repository.TeachesRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletResponse;
import java.sql.Date;
import java.sql.Time;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;



@RestController
public class InstructorController {

    @Value("${cors.host}")
    private static String corsHost;

    private static final String INSTRUCTOR = "instructor";

    private static final String DESCRIPTION = "description";

    private static final String START_AGE = "start_age";

    private static final String OLDER_AGE = "old_age";

    private static final String START_TIME = "start_time";

    private static final String END_TIME = "end_time";

    private static final String BELT = "belt";

    private static final String FIRST_NAME = "firstName";

    private static final String LAST_NAME = "lastName";

    private static final String ORIGINAL_INSTRUCTOR = "originalInstructor";
    @Autowired
    private ClassesRepository classesRepository;

    @Autowired
    private InstructorRepository instructorRepository;

    @Autowired
    private TeachesRepository teachesRepository;

    @Autowired
    private RegisteredUserRepository registeredUserRepository;

    @PutMapping("/createInstructor")
    @CrossOrigin(origins = "http://localhost:3000", allowCredentials = "true")
    public InstructorEntity createInstructor(@RequestParam(value = INSTRUCTOR) String instructor_email,
                                             @RequestParam(value = BELT) String belt){
        InstructorEntity instructorEntity = new InstructorEntity();
        instructorEntity.setBelt(belt);
        instructorEntity.setInstructorEmail(instructor_email);
        return instructorRepository.save(instructorEntity);
    }

    @GetMapping("/instructorClasses")
    @CrossOrigin(origins = "http://localhost:3000", allowCredentials = "true")
    public List<ClassesEntity> getInstructorClasses(@RequestParam(value = INSTRUCTOR) String instructor_email){
        List<ClassesEntity> classesEntities = classesRepository.getListOfClassesOfInstructor(instructor_email);
        return classesEntities;
    }

    @PutMapping("/addNewClass")
    @CrossOrigin(origins = "http://localhost:3000", allowCredentials = "true")
    public void addNewClass(@RequestParam(value = DESCRIPTION) String description,
                            @RequestParam(value = START_AGE) int start_age,
                            @RequestParam(value = OLDER_AGE) int older_age,
                            @RequestParam(value = START_TIME) String start_time_str,
                            @RequestParam(value = END_TIME) String  end_time_str,
                            @RequestParam(value = INSTRUCTOR) String instructor_email){
        Time start_time = Time.valueOf(start_time_str + ":00");
        Time end_time = Time.valueOf(end_time_str+ ":00");
        ClassesEntity classesEntity = new ClassesEntity();
        classesEntity.setCID(classesRepository.getMaxCID() + 1);
        classesEntity.setDescription(description);
        classesEntity.setTarget_start_age(start_age);
        classesEntity.setTarget_older_age(older_age);
        classesEntity.setStart_date(start_time);
        classesEntity.setEnd_date(end_time);
        classesRepository.save(classesEntity);

        TeachesEntity teachesEntity= new TeachesEntity();
        int IID =  instructorRepository.getInstructor(instructor_email).get(0).getIID();
        teachesEntity.setIID(IID);
        teachesEntity.setCID(classesEntity.getCID());
        java.sql.Date date = new java.sql.Date(Calendar.getInstance().getTime().getTime());
        teachesEntity.setStart_date(date);
        teachesRepository.save(teachesEntity);
    }

    @GetMapping("/getInstructorProfile")
    @CrossOrigin(origins = "http://localhost:3000", allowCredentials = "true")
    public InstructorProfileAPIResponse getInstructorProfile(@RequestParam(value = INSTRUCTOR) String instructor_email){
        InstructorProfileAPIResponse instructorProfileAPIResponse = new InstructorProfileAPIResponse();
        List<InstructorEntity> instructorEntities = instructorRepository.getInstructor(instructor_email);
        instructorProfileAPIResponse.setBelt(instructorEntities.get(0).getBelt());
        instructorProfileAPIResponse.setEmail(instructor_email);
        instructorProfileAPIResponse.setFirst_name(registeredUserRepository.getInstructorFirstName(instructor_email));
        instructorProfileAPIResponse.setLast_name(registeredUserRepository.getInstructorLastName(instructor_email));
        return instructorProfileAPIResponse;
    }

    @PutMapping("/updateInstructorProfile")
    @CrossOrigin(origins = "http://localhost:3000", allowCredentials = "true")
    public ResponseEntity updateInstructorProfile(@RequestParam(value = INSTRUCTOR) String instructor_email,
                                                  @RequestParam(value = BELT) String belt,
                                                  @RequestParam(value = FIRST_NAME) String first_name,
                                                  @RequestParam(value = LAST_NAME) String last_name,
                                                  @RequestParam(value = ORIGINAL_INSTRUCTOR) String original_instructor_email
                                        ){

        instructorRepository.update(instructor_email, belt, original_instructor_email);
        registeredUserRepository.update(instructor_email, first_name, last_name, original_instructor_email);
        return ResponseEntity.status(HttpStatus.ACCEPTED).build();
    }

    @GetMapping("getlistOfStudentsForClass")
    @CrossOrigin(origins = "http://localhost:3000", allowCredentials = "true")
    public List<RegisteredUserEntity>  getListOfStudentsForClass(@RequestParam int CID){
        return registeredUserRepository.listOfStudentsTakingClass(CID);
    }

    //TODO: add instructor
    //TODO: add student and parent

}
