package com.bbusa.bbusa.Controller;

import com.bbusa.bbusa.Entity.AttendsEntity;
import com.bbusa.bbusa.Repository.AttendsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletResponse;
import java.util.Calendar;
import java.util.List;

@RestController("/attendance")
public class AttendanceController {

    @Autowired
    private AttendsRepository attendsRepository;

    @PutMapping("/submitAttendance")
    @CrossOrigin(origins = "http://localhost:3000", allowCredentials = "true")
    public AttendsEntity submitAttendance(@RequestParam int SID, @RequestParam int CID, @RequestParam String attendance_type){

        java.sql.Date date = new java.sql.Date(Calendar.getInstance().getTime().getTime());
        AttendsEntity attendsEntity = new AttendsEntity();
        attendsEntity.setAttendDate(date);
        attendsEntity.setAttendance(attendance_type);
        attendsEntity.setCID(CID);
        attendsEntity.setSID(SID);
        return attendsRepository.save(attendsEntity);
    }

    @GetMapping("/{contextPath}/getAttendance")
    @CrossOrigin(origins = "http://localhost:3000", allowCredentials = "true")
    public List<AttendsEntity> getAttendanceForStudent(HttpServletResponse httpServletResponse, @RequestParam int SID, @RequestParam int CID){
        return attendsRepository.getClassAttends(SID, CID);
    }
}
