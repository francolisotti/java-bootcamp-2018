

CREATE DATABASE IF NOT EXISTS highschool;

use highschool;

CREATE TABLE teachers (id INT AUTO_INCREMENT, first_name CHAR(50), last_name CHAR(50), date_of_birth DATE, PRIMARY KEY (id));

CREATE TABLE students (id INT AUTO_INCREMENT, first_name CHAR(50), last_name CHAR(50), registration_number INT UNIQUE, date_of_birth DATE,  PRIMARY KEY(id));

CREATE TABLE courses (id INT AUTO_INCREMENT,name CHAR(50), hours_by_week INT, fk_teacher_id INT, fk_schedule
	PRIMARY KEY(id),
	FOREIGN KEY(fk_teacher_id) REFERENCES teachers(id));

CREATE TABLE courses_x_students (pfk_course_id INT, pfk_student_id INT, partial1 INT, partial2 INT, partial3 INT, final INT,
    PRIMARY KEY(pfk_course_id,pfk_student_id),
    FOREIGN KEY(pfk_course_id) REFERENCES courses(id),
    FOREIGN KEY(pfk_student_id) REFERENCES students(id));


INSERT INTO teachers (first_name, last_name, date_of_birth) VALUES
  ("Jorge","Sampaoli","1990-05-01"),
  ("Josep","Guardiola","1990-05-01"),
  ("Marcelo","Gallardo","1990-05-01");
INSERT INTO students (first_name, last_name, registration_number, date_of_birth) VALUES
  ("Lionel","Messi",3254, "1985-04-06"),
  ("Eden","Hazard",4875, "1985-04-06"),
  ("Gonzalo","Martinez",1238, "1990-05-01"),
  ("Johan","Cryuff",1236, "1985-04-06"),
  ("Andres","Iniesta",1348, "1985-04-06"),
  ("Luis","Suarez",6854, "1990-05-01"),
  ("Gerard","Pique",4236, "1985-04-06"),
  ("Franco","Armani",4452, "1985-04-06"),
  ("Leonardo","Ponzio",4487, "1985-04-06"),
  ("Matias","Kranevitter",1123, "1985-04-06");
INSERT INTO courses (name, hours_by_week, fk_teacher_id) VALUES
  ("Matematica",4,1),
  ("Estadistica",4,2),
  ("Laboratorio",4,3);
INSERT INTO courses_x_students (pfk_course_id, pfk_student_id, partial1, partial2, partial3) VALUES
  (2,1,10,10,10),
  (2,2,7,5,8),
  (2,3,1,3,7),
  (1,4,2,8,10),
  (1,5,8,9,7),
  (3,6,3,2,1),
  (3,7,10,5,6),
  (3,8,10,7,4),
  (3,9,3,3,1),
  (1,10,1,4,3);

DROP PROCEDURE IF EXISTS list_by_course;
DELIMITER //
CREATE PROCEDURE list_by_course(vcourse_name VARCHAR(50))
BEGIN
  
  DECLARE vteacher_id INT;
  DECLARE vcourse_id INT default 0;
  SELECT fk_teacher_id, id INTO vteacher_id, vcourse_id FROM courses WHERE name = vcourse_name;
  IF (vcourse_id!=0) THEN
  
  SELECT vcourse_name AS "Course";
  
  SELECT CONCAT(last_name," ",first_name) AS teacher FROM teachers WHERE id = vteacher_id;

  SELECT CONCAT(s.last_name," ",s.first_name) AS "Students"
    FROM students s
    INNER JOIN courses_x_students cs ON cs.pfk_student_id = s.id
    WHERE cs.pfk_course_id = vcourse_id
    ORDER BY s.last_name,s.first_name;
  ELSE
    SIGNAL SQLSTATE "45000" SET MESSAGE_TEXT = "Non-existent course";
  END IF;
END
//
call list_by_course("Matematica");

DROP PROCEDURE IF EXISTS calculate_final_note;
DELIMITER //
CREATE PROCEDURE calculate_final_note()
BEGIN
  
	DECLARE vpartial1 INT;
	DECLARE vpartial2 INT;
	DECLARE vpartial3 INT;
	DECLARE vcourse_id INT;
	DECLARE vstudent_id INT;
	DECLARE done INT DEFAULT 0;
	DECLARE read_student CURSOR FOR SELECT pfk_student_id,pfk_course_id,partial1,partial2,partial3 FROM courses_x_students;
	DECLARE CONTINUE HANDLER FOR NOT FOUND SET done = TRUE;

	OPEN read_student;

		read_loop: LOOP
			FETCH read_student INTO vstudent_id,vcourse_id,vpartial1,vpartial2,vpartial3;
			
			IF done THEN
				LEAVE read_loop;
			END IF;
			
			UPDATE courses_x_students SET final = (vpartial1+vpartial2+vpartial3)/3 where pfk_student_id=vstudent_id AND pfk_course_id=vcourse_id;

		END LOOP;
	CLOSE read_student;
END
//

call calculate_final_note();


DROP PROCEDURE IF EXISTS percentage_of_passed_failed;
DELIMITER //
CREATE PROCEDURE percentage_of_passed_failed()
BEGIN
  
  DECLARE vpassed INT default 0;
  DECLARE vfailed INT default 0;
  DECLARE vtotal INT default 0;
  
  SET vpassed = (SELECT COUNT(cs.pfk_student_id) FROM courses_x_students cs WHERE cs.final>=4);

  SET vfailed = (SELECT COUNT(cs.pfk_student_id) FROM courses_x_students cs WHERE cs.final<4);

  SET vtotal = vfailed+vpassed;

  SELECT TRUNCATE((vpassed * 100/vtotal),2) as "Passed",TRUNCATE((vfailed * 100/vtotal),2) as "Failed";
END
//

call percentage_of_passed_failed();



CREATE TABLE week_days	(id INT AUTO_INCREMENT, day CHAR(30), PRIMARY KEY(id));

INSERT INTO week_days (day) VALUES
	("Monday"),
	("Tuesday"),
	("Wednesday"),
	("Thursday"),
	("Friday");

CREATE TABLE schedules (id INT AUTO_INCREMENT, start TIME, finish TIME, fk_week_day_id INT, PRIMARY KEY(id),
		FOREIGN KEY(fk_week_day_id) REFERENCES week_days(id));

INSERT INTO schedules (start, finish, fk_week_day_id) VALUES
	("7:00","8:00",1),
	("9:00","10:00",1),
	("7:00","8:00",2),
	("9:00","10:00",2),
	("7:00","8:00",3),
	("9:00","10:00",3),
	("7:00","8:00",4),
	("9:00","10:00",4),
	("7:00","8:00",5),
	("9:00","10:00",5);

CREATE TABLE course_x_schedule (pfk_course_id INT, pfk_schedule_id INT, PRIMARY KEY(pfk_course_id,pfk_schedule_id),
		FOREIGN KEY(pfk_course_id) REFERENCES courses(id),
		FOREIGN KEY(pfk_schedule_id) REFERENCES schedules(id));

	INSERT INTO courses_x_schedule (pfk_course_id, pfk_schedule_id) VALUES
	(1,1),
	(2,2),
	(1,3),
	(2,4),
	(3,5),
	(3,6),
	(1,7),
	(3,8),
	(2,9),
	(3,10);


DROP PROCEDURE IF EXISTS teacher_timeline;
DELIMITER //
CREATE PROCEDURE teacher_timeline(vteacher_id INT)
BEGIN
  
  SELECT CONCAT(last_name," ",first_name) AS teacher FROM teachers WHERE id = vteacher_id;
  SELECT wd.day,s.start,s.finish,c.name FROM course_x_schedule cs
    INNER JOIN schedules s ON cs.pfk_schedule_id = s.id
    INNER JOIN courses c ON cs.pfk_course_id = c.id
    INNER JOIN week_days wd ON s.fk_week_day_id = wd.id
    WHERE c.fk_teacher_id = vteacher_id
    ORDER BY wd.day,s.start;
END
//

call teacher_timeline(1);