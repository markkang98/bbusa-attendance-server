package com.bbusa.bbusa.Repository;

import com.bbusa.bbusa.Entity.StudentEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface StudentRepository extends JpaRepository<StudentEntity, String> {
    @Query(value = "Select distinct studentEmail, CID, belt\n" +
            "from Takes, Student, Teaches, Instructor\n" +
            "where Takes.SID = Student.SID \n" +
            "and Takes.CID = Teaches.CID \n" +
            "and Teaches.IID = Instructor.IID\n" +
            "and Instructor.instructoremail = 'lcheng@yahoo.ca'", nativeQuery = true)
    List<StudentEntity> getStudentsTaughtByCheng(String user_id);

    @Query(value = "Select CID, target_start_age, target_older_age\n" +
            "from innodb.Classes \n" +
            "where innodb.Classes.CID not in \n" +
            "\t(Select t.CID\n" +
            "\t\tfrom innodb.Takes as t join innodb.Student as s\n" +
            "\t\twhere s.SID = t.SID and s.SID = 1)", nativeQuery = true)
    List<StudentEntity> couldTake(String user_id);

    @Query(value = "Select CID, attendDate\n" +
            "from innodb.Attends as a \n" +
            "where a.SID = 1 and a.attendance = 'attended'", nativeQuery = true)
    List<StudentEntity> attendedOnTime(String user_id);

    @Query(value = "Select CID, attendDate\n" +
            "from innodb.Attends as a \n" +
            "where a.SID = 1 and a.attendance = 'absent'", nativeQuery = true)
    List<StudentEntity> absent(String user_id);


}