/* Show all student emails who are taking a class taught by Cheng */
Select distinct studentEmail, innodb.Takes.CID, innodb.Student.belt
from innodb.Takes, innodb.Student,innodb.Teaches, innodb.Instructor
where innodb.Takes.SID = innodb.Student.SID 
and innodb.Takes.CID = innodb.Teaches.CID 
and innodb.Teaches.IID = innodb.Instructor.IID
and innodb.Instructor.instructoremail = 'lcheng@yahoo.ca'
limit 10;

/* Shows a user (in this case 1) which classes they are not in but could take */
Select CID, target_start_age, target_older_age
from innodb.Classes 
where innodb.Classes.CID not in 
	(Select t.CID
		from innodb.Takes as t join innodb.Student as s
		where s.SID = t.SID and s.SID = 1);
  
/* Shows a user (in this case 1) which classes they attended on time */
Select CID, attendDate
from innodb.Attends as a 
where a.SID = 1 and a.attendance = 'attended';

/* Shows a user (in this case 1) which classes they missed */
Select CID, attendDate
from innodb.Attends as a 
where a.SID = 1 and a.attendance = 'absent';

/* Shows for a teacher (in this case 6) which students have missed a class */
Select distinct SID, t.CID, a.attendDate, a.attendance 
From innodb.Attends as a Join innodb.Teaches as t
on a.CID = t.CID
where t.IID = 6 and a.attendance = 'absent'
order by a.attendDate
limit 10;

/* Update user's password */
UPDATE innodb.RegisteredUser SET password = 'reddevils' WHERE email = 'aaribaud@me.com';