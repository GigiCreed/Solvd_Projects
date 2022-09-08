Use University;
--                                                      INSERT

-- I am using tables : faculties, vice_rectors, reqtors, university and students.

-- insert into reqtors(name,surname,age,phone_number,address,email) values ("Gigi","Mamaladze",'2002/08/19',599111111,"batumi","gigimama@gmai.com");
-- insert into vice_rectors(name,surname,age,phone_number,addres,email) values ("nika","fartenadze",'2002/02/19',59904444,"batumi","nikafart@gmail.com");
-- insert into universities(name,address,site_addres,email,Reqtors_id,Vice_Rectors_ID)values("Bsu","Batumi","bsu.portal","Bsu@gmail.com",1,1);
-- insert into faculties(name,Universities_id) values("Computer science",1);
--    insert into faculties(name,Universities_id) values("Business",1);
--    insert into faculties(name,Universities_id) values("Economic",1);
--    insert into faculties(name,Universities_id) values("tourism",1);
-- insert into students(name,surname,age,phone_number,course,email,Universities_id,Faculties_id)values("rezo","xuchua",'2002/02/19',44323231,3,"rezos@gmail.com",1,1);
-- insert into students(name,surname,age,phone_number,course,email,Universities_id,Faculties_id)values("sandro","pachkoicha",'2002/02/19',5555555,3,"sandro@gmail.com",1,1);
-- insert into students(name,surname,age,phone_number,course,email,Universities_id,Faculties_id)values("kosta","pitona",'2002/05/19',3432131,3,"kost@gmail.com",1,1);
-- insert into students(name,surname,age,phone_number,course,email,Universities_id,Faculties_id)values("dima","solvd",'2000/02/19',32323,4,"dim@gmail.com",1,1);
-- insert into students(name,surname,age,phone_number,course,email,Universities_id,Faculties_id)values("leo","vasadze",'2002/11/19',566666,3,"leo@gmail.com",1,1);
-- insert into students(name,surname,age,phone_number,course,email,Universities_id,Faculties_id)values("ia","inwkriveli",'2003/02/19',3333333,2,"ia@gmail.com",1,1);
-- insert into students(name,surname,age,phone_number,course,email,Universities_id,Faculties_id)values("nika","beridze",'2003/02/19',44444444,2,"nika@gmail.com",1,1);
-- insert into students(name,surname,age,phone_number,course,email,Universities_id,Faculties_id)values("luka","cxomelidze",'2003/05/23',54321,2,"luka@gmail.com",1,1);
-- insert into students(name,surname,age,phone_number,course,email,Universities_id,Faculties_id)values("luka","bejo",'2003/02/19',1232123,2,"bejo@gmail.com",1,1);
-- insert into students(name,surname,age,phone_number,course,email,Universities_id,Faculties_id)values("dato","mjave",'2004/11/23',455123123,1,"dato@gmail.com",1,1);
-- insert into students(name,surname,age,phone_number,course,email,Universities_id,Faculties_id)values("irakli","qebuladze",'2002/01/02',11111111,3,"ika@gmail.com",1,1);
-- insert into students(name,surname,age,phone_number,course,email,Universities_id,Faculties_id)values("tinatin","rodinadze",'2002/08/09',22222,3,"tiniko@gmail.com",1,1);
-- insert into students(name,surname,age,phone_number,course,email,Universities_id,Faculties_id)values("nia","danelia",'2004/02/04',7777777,1,"nia@gmail.com",1,1);
-- insert into students(name,surname,age,phone_number,course,email,Universities_id,Faculties_id)values("mari","kvachadze",'2004/02/05',8888888,1,"mari@gmail.com",1,1);
-- insert into students(name,surname,age,phone_number,course,email,Universities_id,Faculties_id)values("giorgi","kurshubadze",'2004/02/06',9999999,1,"rezos@gmail.com",1,1);
-- insert into students(name,surname,age,phone_number,course,email,Universities_id,Faculties_id)values("madara","uchicha",'2000/02/19',44323231,5,"madara@gmail.com",1,1);
-- insert into students(name,surname,age,phone_number,course,email,Universities_id,Faculties_id)values("jekson","mick",'2000/02/19',99999999,5,"jek@gmail.com",1,1);
-- insert into students(name,surname,age,phone_number,course,email,Universities_id,Faculties_id)values("katia","surma",'2000/02/19',00000000,5,"katia@gmail.com",1,1);
-- insert into students(name,surname,age,phone_number,course,email,Universities_id,Faculties_id)values("giorgi","siradze",'2000/02/19',125,5,"giorgi@gmail.com",1,1);
-- insert into students(name,surname,age,phone_number,course,email,Universities_id,Faculties_id)values("nika","moqia",'2000/02/19',345,5,"nika@gmail.com",1,1);
-- insert into students(name,surname,age,phone_number,course,email,Universities_id,Faculties_id)values("rezo","xuchua",'2002/02/5',44323231,3,"rezos@gmail.com",1,1)


--                                                                 UPDATE

-- For second update comand I disable safe update. Tap Edit, next Preferences after this Sql Editor and Disable safe update and Refresh your connection;

-- UPDATE students SET course = 2 WHERE id =21;
-- UPDATE students SET course = 2 WHERE course = 1;
-- UPDATE reqtors SET email ="gigimamaladze13@gmail.com" WHERE id =1;
-- UPDATE reqtors SET surname = "Mamo" WHERE id >2 AND id<4;
-- UPDATE vice_rectors SET name = "Nikolz" WHERE surname="fartenadze";
-- UPDATE students SET course =3 WHERE name like "%ri";
-- UPDATE vice_rectors SET phone_number =555 Where age like '____-02%';
-- Update students SET course =4 WHERE age Like '2002%';
-- Update students SET course =3 WHERE age like '2002%';
-- UPDATE faculties SET name = "Faculty of Exact Sciences" Where id = 1;
-- Update students set Faculties_id= 2 where name like 'tin%';




--                                                               DELETE

-- in first comand i will delate reqtors that i created sudenly;

-- DELETE FROM reqtors WHERE id>1;
-- DELETE FROM students WHERE name like "madara";
-- DELETE FROM students where course = 5;
-- DELETE FROM students where phone_number like '555%';
-- DELETE from students Where phone_number like '%8';
-- DELETE from students where age LIKE '2004%';
-- DELETE FROM students Where id >15 AND id<=21;
-- DELETE FROM students where id >0 AND id<3;
-- DELETE FROM students where course >0 and course <3;
-- DELETE FROM students where name  REGEXP '^[klidm]';



--                                                          JOINS
-- Insert into students(name,surname,age,phone_number,course,email,Universities_id,Faculties_id) values ("gigi","mamaladze",'2002/11/28',599041208,3,"gigimamaladze13@gmail.com",1,1);


-- Select students.name,faculties.name From students Left join faculties ON students.Faculties_id=faculties.id;
-- Select faculties.name, students.name From students Right join faculties  ON students.Faculties_id=faculties.id;
-- Select faculties.name, students.name From students inner join faculties ON students.Faculties_id=faculties.id;
-- SELECT students.name, faculties.name FROM students
-- LEFT JOIN faculties ON students.Faculties_id=faculties.id
-- UNION
-- SELECT students.name, faculties.name FROM students
-- RIGHT JOIN faculties ON students.Faculties_id=faculties.id