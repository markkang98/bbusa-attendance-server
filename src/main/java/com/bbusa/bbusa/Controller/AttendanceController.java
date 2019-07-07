package com.bbusa.bbusa.Controller;

import com.bbusa.bbusa.Entity.AttendanceEntity;
import com.bbusa.bbusa.Entity.StudentAPIResponse;
import com.bbusa.bbusa.Entity.StudentEntity;
import com.bbusa.bbusa.Entity.StudentListAPIResponse;
import com.bbusa.bbusa.Repository.AttendanceRepository;
import com.bbusa.bbusa.Repository.AuthenticationRepository;
import com.bbusa.bbusa.Repository.StudentInformationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.sql.Date;
import java.time.Instant;
import java.time.LocalDate;
import java.util.List;

@RestController
public class AttendanceController {
    @Autowired
    private StudentInformationRepository studentInformationRepository;

    @Autowired
    private AttendanceRepository attendanceRepository;

    @Autowired
    private StudentAPIResponse studentAPIResponse;
    private static final String BELT_COLOR = "beltColor";

    @PostMapping("/submitAttendance")
    @CrossOrigin
    public AttendanceEntity submitAttendance(@RequestParam() String first_name, @RequestParam() String last_name){
        LocalDate localDate = LocalDate.now();
        Date sqlDate = Date.valueOf(localDate);
        AttendanceEntity attendanceEntity = new AttendanceEntity();
        attendanceEntity.setFirst_name(first_name);
        attendanceEntity.setLast_name(last_name);
        attendanceEntity.setAttendance_date(sqlDate);
        return attendanceRepository.save(attendanceEntity);
    }

    @GetMapping("/getStudentByBelt")
    @CrossOrigin
    public StudentAPIResponse getStudent(@RequestParam(value = BELT_COLOR) String belt_color) {
        studentAPIResponse.setAllUsers(studentInformationRepository.findByBelt(belt_color.toUpperCase()));
        return studentAPIResponse;
    }

    @GetMapping("/getAllStudents")
    @CrossOrigin
    public StudentAPIResponse getAllStudents(){
        studentAPIResponse.setAllUsers(studentInformationRepository.findAll());
        return studentAPIResponse;
    }
}
