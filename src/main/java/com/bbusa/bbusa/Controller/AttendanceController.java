package com.bbusa.bbusa.Controller;

import com.bbusa.bbusa.Entity.AttendanceEntity;
import com.bbusa.bbusa.APIResponse.StudentAPIResponse;
import com.bbusa.bbusa.Repository.AttendanceRepository;
import com.bbusa.bbusa.Repository.StudentInformationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletResponse;
import java.sql.Date;
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

    @Value("${cors.host}")
    private String corsHost;

    private static final String BELT_COLOR = "beltColor";

    @PostMapping("/submitAttendance")
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
    public StudentAPIResponse getStudent(@RequestParam(value = BELT_COLOR) String belt_color) {
        studentAPIResponse.setAllUsers(studentInformationRepository.findByBelt(belt_color.toUpperCase()));
        return studentAPIResponse;
    }

    @GetMapping("/findAttendanceDates")
    public List<AttendanceEntity> getDates(HttpServletResponse httpServletResponse,@RequestParam String first_name, @RequestParam String last_name){
        addCrossOrigins(httpServletResponse);
        return attendanceRepository.findAttendanceDatesForStudent(first_name, last_name);
    }

    @GetMapping("/getAllStudents")
    public StudentAPIResponse getAllStudents(HttpServletResponse httpServletResponse, @RequestParam String user_id){
        addCrossOrigins(httpServletResponse);
        studentAPIResponse.setAllUsers(studentInformationRepository.findAllForUser(user_id));
        return studentAPIResponse;
    }
    private void addCrossOrigins(HttpServletResponse httpServletResponse){
        httpServletResponse.addHeader("Access-Control-Allow-Origin", corsHost);
        httpServletResponse.addHeader("Access-Control-Allow-Credentials", "true");
    }
}
