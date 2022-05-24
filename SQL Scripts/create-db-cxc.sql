DROP DATABASE IF EXISTS 'cxc';
CREATE DATABASE 'cxc';
USE 'cxc';

CREATE TABLE 'employees' (
'employee_id' int(11) NOT NULL,
'first_name' varchar(50) NOT NULL,
'last_name' varchar(50) NOT NULL,
'job_title' varchar(50) NOT NULL,
'salary' varchar(50) NOT NULL,
'reports_to' int(11) DEFAULT NULL,);

INSERT INTO 'employees' VALUES (1000,‘Addison', 'Bond', ‘Relations Director’, 65831,NULL,10);
INSERT INTO 'employees' VALUES (2273,‘Dennis','Thompson’,‘Financial Administrator, 65822,1000,1);
INSERT INTO 'employees' VALUES (4274,‘Jessica', 'Snow', ‘Case Manager’, 121009,1000,2);
INSERT INTO 'employees' VALUES (4680,‘Dennis', 'Kim’, ‘Patient Advocate’, 89654,1000,2);
INSERT INTO 'employees' VALUES (1851,‘Todd', 'Gallagher’, ‘Service Coordinator’, 102010,1000,1);
INSERT INTO 'employees' VALUES (4824,‘Sally', 'You’, ‘ER Pain Support’, 45323,1000,2);
INSERT INTO 'employees' VALUES (4272,‘Memphis', 'Gallagher’, ‘ER Call Support’, 42623,1000,2);
INSERT INTO 'employees' VALUES (3325,‘Tomoko','Young’, ‘Data Detective’, 102533,1000,3);
INSERT INTO 'employees' VALUES (5208,‘William','Brown’, ‘Software Engineer’, 98956,1000,3);
INSERT INTO 'employees' VALUES (4559,‘Josie','Perez’, ‘Data Epidemiologist’, 98566,1000,3);
INSERT INTO 'employees' VALUES (5168,‘Michelle','Zhang’, ‘Network Engineer’, 89567,1000,3);







