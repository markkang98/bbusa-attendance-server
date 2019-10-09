package com.bbusa.bbusa;

import com.bbusa.bbusa.Entity.AttendanceEntity;
import org.junit.Assert;
import org.junit.Test;
import java.sql.Date;

public class AttendanceEntityTests {
    @Test
    public void testAttendanceEntity(){
        AttendanceEntity attendanceEntity = new AttendanceEntity();
        attendanceEntity.setFirst_name("Mark");
        attendanceEntity.setLast_name("Kang");
        Date date = new Date(04,26,1998);

        attendanceEntity.setAttendance_date(date);
        Assert.assertEquals(attendanceEntity.getFirst_name(), "Mark");
        Assert.assertEquals(attendanceEntity.getLast_name(), "Kang");

    }
}
