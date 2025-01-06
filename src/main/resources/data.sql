INSERT INTO `holidays` (`day`,`reason`,`type`,`created_at`, `created_by`)
VALUES (' Jan 1 ','New Year''s Day','FESTIVAL',CURDATE(),'DBA');

INSERT INTO `holidays` (`day`,`reason`,`type`,`created_at`, `created_by`)
VALUES (' Oct 31 ','Halloween','FESTIVAL',CURDATE(),'DBA');

INSERT INTO `holidays` (`day`,`reason`,`type`,`created_at`, `created_by`)
VALUES (' Nov 24 ','Thanksgiving Day','FESTIVAL',CURDATE(),'DBA');

INSERT INTO `holidays` (`day`,`reason`,`type`,`created_at`, `created_by`)
VALUES (' Dec 25 ','Christmas','FESTIVAL',CURDATE(),'DBA');

INSERT INTO `holidays` (`day`,`reason`,`type`,`created_at`, `created_by`)
VALUES (' Jan 17 ','Martin Luther King Jr. Day','FEDERAL',CURDATE(),'DBA');

INSERT INTO `holidays` (`day`,`reason`,`type`,`created_at`, `created_by`)
VALUES (' July 4 ','Independence Day','FEDERAL',CURDATE(),'DBA');

INSERT INTO `holidays` (`day`,`reason`,`type`,`created_at`, `created_by`)
VALUES (' Sep 5 ','Labor Day','FEDERAL',CURDATE(),'DBA');

INSERT INTO `holidays` (`day`,`reason`,`type`,`created_at`, `created_by`)
VALUES (' Nov 11 ','Veterans Day','FEDERAL',CURDATE(),'DBA');

INSERT INTO `roles` (`role_name`,`created_at`, `created_by`)
VALUES ('ADMIN',CURDATE(),'DBA');

INSERT INTO `roles` (`role_name`,`created_at`, `created_by`)
VALUES ('STUDENT',CURDATE(),'DBA');

INSERT INTO `person` (`name`,`email`,`mobile_number`,`pwd`,`role_id`,`created_at`, `created_by`)
VALUES ('Admin','admin','3443434343','admin', 1 ,CURDATE(),'DBA');

DELETE FROM person where email='admin';

INSERT INTO `person` (`name`,`email`,`mobile_number`,`pwd`,`role_id`,`created_at`, `created_by`)
VALUES ('Admin','admin','3443434343','$2a$10$XhU4UcSxDPb5G0I0fT/CZ.Lfj2VW2fkLkUP5cOEM.xM8EzyUQXaD2', 1 ,CURDATE(),'DBA');

INSERT INTO `person` (`name`,`email`,`mobile_number`,`pwd`,`role_id`,`created_at`, `created_by`)
VALUES ('Admin','admin','3443434343','$2a$12$JdYOAVM/34thYCdz6W1/Iudlg1bJbsaw/w7fNx64XOSZ64WFItN8W', 1 ,CURDATE(),'DBA');


INSERT INTO `contact_msg` (`name`,`mobile_num`,`email`,`subject`,`message`,`status`,`created_at`, `created_by`)
VALUES ('Adam','2176436587','zadam@gmail.com','Regarding a job','Wanted to join as teacher','Open',CURDATE(),'DBA');

INSERT INTO `contact_msg` (`name`,`mobile_num`,`email`,`subject`,`message`,`status`,`created_at`, `created_by`)
VALUES ('Zara','3412654387','zarabaig@hotmail.com','Course Admission','Wanted to join a course','Open',CURDATE(),'DBA');

INSERT INTO `contact_msg` (`name`,`mobile_num`,`email`,`subject`,`message`,`status`,`created_at`, `created_by`)
VALUES ('Marques','8547643673','kmarques@yahoo.com','Course Review','Review of Development course','Open',CURDATE(),'DBA');

INSERT INTO `contact_msg` (`name`,`mobile_num`,`email`,`subject`,`message`,`status`,`created_at`, `created_by`)
VALUES ('Shyam','4365328776','gshyam@gmail.com','Admission Query','Need to talk about admission','Open',CURDATE(),'DBA');

INSERT INTO `contact_msg` (`name`,`mobile_num`,`email`,`subject`,`message`,`status`,`created_at`, `created_by`)
VALUES ('John','5465765453','doejohn@gmail.com','Holiday Query','Query on upcoming holidays','Open',CURDATE(),'DBA');

INSERT INTO `contact_msg` (`name`,`mobile_num`,`email`,`subject`,`message`,`status`,`created_at`, `created_by`)
VALUES ('Taniya Bell','3987463827','belltaniya@gmail.com','Child Scholarship','Can my child get scholarship?','Open',CURDATE(),'DBA');

INSERT INTO `contact_msg` (`name`,`mobile_num`,`email`,`subject`,`message`,`status`,`created_at`, `created_by`)
VALUES ('Willie Lara','4568764801','476lara@gmail.com','Need Admission','My son need an admission','Open',CURDATE(),'DBA');

INSERT INTO `contact_msg` (`name`,`mobile_num`,`email`,`subject`,`message`,`status`,`created_at`, `created_by`)
VALUES ('Jonathan Parsons','4321768902','jonathan.parsons@gmail.com','Course feedback','Music course is good','Open',CURDATE(),'DBA');

INSERT INTO `contact_msg` (`name`,`mobile_num`,`email`,`subject`,`message`,`status`,`created_at`, `created_by`)
VALUES ('Cloe Rubio','9854438719','rubio987@gmail.com','Correct Date of Birth','My Child DOB needs to be corrected','Open',CURDATE(),'DBA');

INSERT INTO `contact_msg` (`name`,`mobile_num`,`email`,`subject`,`message`,`status`,`created_at`, `created_by`)
VALUES ('Camilla Stein','6545433254','camillas@gmail.com','Transport Query','Is Transport provided?','Open',CURDATE(),'DBA');

INSERT INTO `contact_msg` (`name`,`mobile_num`,`email`,`subject`,`message`,`status`,`created_at`, `created_by`)
VALUES ('Lizeth Gross','4678783434','grossliz@yahoo.com','Progress report','Please send progress report','Open',CURDATE(),'DBA');

INSERT INTO `contact_msg` (`name`,`mobile_num`,`email`,`subject`,`message`,`status`,`created_at`, `created_by`)
VALUES ('Yael Howe','1243563254','howeyael@gmail.com','Certificate Query','Need Certificate hard copy','Open',CURDATE(),'DBA');

INSERT INTO `contact_msg` (`name`,`mobile_num`,`email`,`subject`,`message`,`status`,`created_at`, `created_by`)
VALUES ('Ian Moreno','2312231223','moreno.ian@gmail.com','Food feedback','Food quality can be improved','Open',CURDATE(),'DBA');

INSERT INTO `contact_msg` (`name`,`mobile_num`,`email`,`subject`,`message`,`status`,`created_at`, `created_by`)
VALUES ('Desirae Ibarra','3445235667','ibarrades@gmail.com','Traffic Complaint','Traffic around school can be controlled','Open',CURDATE(),'DBA');

INSERT INTO `contact_msg` (`name`,`mobile_num`,`email`,`subject`,`message`,`status`,`created_at`, `created_by`)
VALUES ('Oswaldo Jarvis','4556121265','jarvissmile@hotmail.com','Study Tour','Study tour details needed','Open',CURDATE(),'DBA');

INSERT INTO `contact_msg` (`name`,`mobile_num`,`email`,`subject`,`message`,`status`,`created_at`, `created_by`)
VALUES ('Miah Perkins','2367784512','perkinsmiah@hotmail.com','Vaccination Support','Vaccination center in the school','Open',CURDATE(),'DBA');

INSERT INTO `contact_msg` (`name`,`mobile_num`,`email`,`subject`,`message`,`status`,`created_at`, `created_by`)
VALUES ('Zion Bolton','8990678900','boltzion@gmail.com','Course fees','Pls share fees of music course','Open',CURDATE(),'DBA');

INSERT INTO `contact_msg` (`name`,`mobile_num`,`email`,`subject`,`message`,`status`,`created_at`, `created_by`)
VALUES ('Dominik Tanner','4556127834','tannerdominik@gmail.com','Games schedule','Provide Summer games schedule','Open',CURDATE(),'DBA');




INSERT INTO `contact_msg` (`name`,`mobile_num`,`email`,`subject`,`message`,`status`,`created_at`, `created_by`)
VALUES ('Rahul','4378297634','rahul123@gmail.com','Course Details','Interested in course details','Open',CURDATE(),'DBA');

INSERT INTO `contact_msg` (`name`,`mobile_num`,`email`,`subject`,`message`,`status`,`created_at`, `created_by`)
VALUES ('Priya','4398765321','priya.kumar@yahoo.com','Fee Structure','Want to know the fee structure','Open',CURDATE(),'DBA');

INSERT INTO `contact_msg` (`name`,`mobile_num`,`email`,`subject`,`message`,`status`,`created_at`, `created_by`)
VALUES ('Amit','4356789345','amit.singh@hotmail.com','Class Timings','Query about class timings','Open',CURDATE(),'DBA');

INSERT INTO `contact_msg` (`name`,`mobile_num`,`email`,`subject`,`message`,`status`,`created_at`, `created_by`)
VALUES ('Sonia','4321897634','sonia.mishra@gmail.com','Hostel Facility','Enquiry about hostel facilities','Open',CURDATE(),'DBA');

INSERT INTO `contact_msg` (`name`,`mobile_num`,`email`,`subject`,`message`,`status`,`created_at`, `created_by`)
VALUES ('Vijay','4365987321','vijay.raj@gmail.com','Scholarship','Information on scholarships','Open',CURDATE(),'DBA');

INSERT INTO `contact_msg` (`name`,`mobile_num`,`email`,`subject`,`message`,`status`,`created_at`, `created_by`)
VALUES ('Kiran','4387653219','kiran.batra@yahoo.com','Transport','Details on transport facilities','Open',CURDATE(),'DBA');

INSERT INTO `contact_msg` (`name`,`mobile_num`,`email`,`subject`,`message`,`status`,`created_at`, `created_by`)
VALUES ('Anita','4398723456','anita.verma@gmail.com','Library','Information about library hours','Open',CURDATE(),'DBA');

INSERT INTO `contact_msg` (`name`,`mobile_num`,`email`,`subject`,`message`,`status`,`created_at`, `created_by`)
VALUES ('Rohit','4321098765','rohit.sharma@hotmail.com','Placement','Details on placement records','Open',CURDATE(),'DBA');

INSERT INTO `contact_msg` (`name`,`mobile_num`,`email`,`subject`,`message`,`status`,`created_at`, `created_by`)
VALUES ('Meera','4312345678','meera.das@gmail.com','Admission Criteria','Query on admission criteria','Open',CURDATE(),'DBA');

INSERT INTO `contact_msg` (`name`,`mobile_num`,`email`,`subject`,`message`,`status`,`created_at`, `created_by`)
VALUES ('Arjun','4378923456','arjun.patel@yahoo.com','Campus Tour','Request for campus tour','Open',CURDATE(),'DBA');

INSERT INTO `contact_msg` (`name`,`mobile_num`,`email`,`subject`,`message`,`status`,`created_at`, `created_by`)
VALUES ('Sneha','4367543210','sneha.kapoor@gmail.com','Application Process','Details on application process','Open',CURDATE(),'DBA');

INSERT INTO `contact_msg` (`name`,`mobile_num`,`email`,`subject`,`message`,`status`,`created_at`, `created_by`)
VALUES ('Gaurav','4356781234','gaurav.mehra@hotmail.com','Internship','Information about internships','Open',CURDATE(),'DBA');

INSERT INTO `contact_msg` (`name`,`mobile_num`,`email`,`subject`,`message`,`status`,`created_at`, `created_by`)
VALUES ('Reema','4321456789','reema.singh@gmail.com','Curriculum','Details on course curriculum','Open',CURDATE(),'DBA');

INSERT INTO `contact_msg` (`name`,`mobile_num`,`email`,`subject`,`message`,`status`,`created_at`, `created_by`)
VALUES ('Nikhil','4312897654','nikhil.kumar@yahoo.com','Examination','Query about examination dates','Open',CURDATE(),'DBA');

INSERT INTO `contact_msg` (`name`,`mobile_num`,`email`,`subject`,`message`,`status`,`created_at`, `created_by`)
VALUES ('Jaya','4398765432','jaya.verma@gmail.com','Faculty','Information about faculty','Open',CURDATE(),'DBA');

INSERT INTO `contact_msg` (`name`,`mobile_num`,`email`,`subject`,`message`,`status`,`created_at`, `created_by`)
VALUES ('Rakesh','4378965432','rakesh.pandey@hotmail.com','Sports','Details on sports facilities','Open',CURDATE(),'DBA');

INSERT INTO `contact_msg` (`name`,`mobile_num`,`email`,`subject`,`message`,`status`,`created_at`, `created_by`)
VALUES ('Lakshmi','4356123789','lakshmi.menon@gmail.com','Events','Query about campus events','Open',CURDATE(),'DBA');

INSERT INTO `contact_msg` (`name`,`mobile_num`,`email`,`subject`,`message`,`status`,`created_at`, `created_by`)
VALUES ('Deepak','4321678901','deepak.kumar@yahoo.com','Workshops','Information about workshops','Open',CURDATE(),'DBA');

INSERT INTO `contact_msg` (`name`,`mobile_num`,`email`,`subject`,`message`,`status`,`created_at`, `created_by`)
VALUES ('Swati','4312789654','swati.mishra@gmail.com','Attendance','Query on attendance policy','Open',CURDATE(),'DBA');

INSERT INTO `contact_msg` (`name`,`mobile_num`,`email`,`subject`,`message`,`status`,`created_at`, `created_by`)
VALUES ('Anil','4378291654','anil.sharma@hotmail.com','Alumni','Details about alumni network','Open',CURDATE(),'DBA');

INSERT INTO `contact_msg` (`name`,`mobile_num`,`email`,`subject`,`message`,`status`,`created_at`, `created_by`)
VALUES ('Lila James','8991234567','lila.james@example.com','Admission Process','Need details on admission process','Open',CURDATE(),'DBA');

INSERT INTO `contact_msg` (`name`,`mobile_num`,`email`,`subject`,`message`,`status`,`created_at`, `created_by`)
VALUES ('Oliver Smith','8992345678','oliver.smith@example.com','Scholarship Information','Query about available scholarships','Open',CURDATE(),'DBA');

INSERT INTO `contact_msg` (`name`,`mobile_num`,`email`,`subject`,`message`,`status`,`created_at`, `created_by`)
VALUES ('Sophia Lee','8993456789','sophia.lee@example.com','Course Curriculum','Need to know about the course curriculum','Open',CURDATE(),'DBA');

INSERT INTO `contact_msg` (`name`,`mobile_num`,`email`,`subject`,`message`,`status`,`created_at`, `created_by`)
VALUES ('Ethan Brown','8994567890','ethan.brown@example.com','Hostel Accommodation','Query about hostel accommodation','Open',CURDATE(),'DBA');

INSERT INTO `contact_msg` (`name`,`mobile_num`,`email`,`subject`,`message`,`status`,`created_at`, `created_by`)
VALUES ('Emma Davis','8995678901','emma.davis@example.com','Transport Facilities','Need information on transport facilities','Open',CURDATE(),'DBA');

INSERT INTO `contact_msg` (`name`,`mobile_num`,`email`,`subject`,`message`,`status`,`created_at`, `created_by`)
VALUES ('Liam Wilson','8996789012','liam.wilson@example.com','Library Access','Query about library access','Open',CURDATE(),'DBA');

INSERT INTO `contact_msg` (`name`,`mobile_num`,`email`,`subject`,`message`,`status`,`created_at`, `created_by`)
VALUES ('Mia Miller','8997890123','mia.miller@example.com','Internship Opportunities','Need details on internship opportunities','Open',CURDATE(),'DBA');

INSERT INTO `contact_msg` (`name`,`mobile_num`,`email`,`subject`,`message`,`status`,`created_at`, `created_by`)
VALUES ('Noah Moore','8998901234','noah.moore@example.com','Examination Schedule','Query about examination schedule','Open',CURDATE(),'DBA');

INSERT INTO `contact_msg` (`name`,`mobile_num`,`email`,`subject`,`message`,`status`,`created_at`, `created_by`)
VALUES ('Ava Taylor','8999012345','ava.taylor@example.com','Campus Life','Information on campus life','Open',CURDATE(),'DBA');

INSERT INTO `contact_msg` (`name`,`mobile_num`,`email`,`subject`,`message`,`status`,`created_at`, `created_by`)
VALUES ('Lucas Anderson','8990123456','lucas.anderson@example.com','Faculty Details','Query about faculty details','Open',CURDATE(),'DBA');

INSERT INTO `contact_msg` (`name`,`mobile_num`,`email`,`subject`,`message`,`status`,`created_at`, `created_by`)
VALUES ('Amelia Thomas','8990234567','amelia.thomas@example.com','Fee Structure','Need to know the fee structure','Open',CURDATE(),'DBA');

INSERT INTO `contact_msg` (`name`,`mobile_num`,`email`,`subject`,`message`,`status`,`created_at`, `created_by`)
VALUES ('Mason Jackson','8990345678','mason.jackson@example.com','Class Timings','Query about class timings','Open',CURDATE(),'DBA');

INSERT INTO `contact_msg` (`name`,`mobile_num`,`email`,`subject`,`message`,`status`,`created_at`, `created_by`)
VALUES ('Isabella White','8990456789','isabella.white@example.com','Placement Record','Need information on placement record','Open',CURDATE(),'DBA');

INSERT INTO `contact_msg` (`name`,`mobile_num`,`email`,`subject`,`message`,`status`,`created_at`, `created_by`)
VALUES ('James Harris','8990567890','james.harris@example.com','Sports Facilities','Query about sports facilities','Open',CURDATE(),'DBA');

INSERT INTO `contact_msg` (`name`,`mobile_num`,`email`,`subject`,`message`,`status`,`created_at`, `created_by`)
VALUES ('Charlotte Martin','8990678901','charlotte.martin@example.com','Event Calendar','Need details on the event calendar','Open',CURDATE(),'DBA');

INSERT INTO `contact_msg` (`name`,`mobile_num`,`email`,`subject`,`message`,`status`,`created_at`, `created_by`)
VALUES ('Benjamin Garcia','8990789012','benjamin.garcia@example.com','Workshop Details','Query about upcoming workshops','Open',CURDATE(),'DBA');

INSERT INTO `contact_msg` (`name`,`mobile_num`,`email`,`subject`,`message`,`status`,`created_at`, `created_by`)
VALUES ('Elijah Martinez','8990890123','elijah.martinez@example.com','Attendance Policy','Need information on attendance policy','Open',CURDATE(),'DBA');

INSERT INTO `contact_msg` (`name`,`mobile_num`,`email`,`subject`,`message`,`status`,`created_at`, `created_by`)
VALUES ('Avery Rodriguez','8990901234','avery.rodriguez@example.com','Alumni Network','Query about the alumni network','Open',CURDATE(),'DBA');

INSERT INTO `contact_msg` (`name`,`mobile_num`,`email`,`subject`,`message`,`status`,`created_at`, `created_by`)
VALUES ('Evelyn Lopez','8990912345','evelyn.lopez@example.com','Research Opportunities','Need details on research opportunities','Open',CURDATE(),'DBA');

INSERT INTO `contact_msg` (`name`,`mobile_num`,`email`,`subject`,`message`,`status`,`created_at`, `created_by`)
VALUES ('Henry Gonzalez','8990923456','henry.gonzalez@example.com','Library Hours','Query about library hours','Open',CURDATE(),'DBA');
