DROP TABLE IF EXISTS ers_users CASCADE;
DROP TABLE IF EXISTS ers_reimbursements CASCADE;


create type role as ENUM ('Employee', 'Manager');
create type type as ENUM ('Food', 'Lodging', 'Travel', 'Conference', 'Education', 'Tool', 'Other');
create type status as ENUM ('Pending', 'Approved', 'Denied');


CREATE TABLE ers_users (
    ID SERIAL PRIMARY KEY,
    USERNAME VARCHAR (250) UNIQUE NOT NULL,
    PASSWORD VARCHAR (250) NOT NULL,
    ROLE VARCHAR (250) NOT NULL
);
CREATE TABLE ers_reimbursements (
    id SERIAL PRIMARY KEY,
    author INT NOT NULL,
    resolver INT,
    description VARCHAR(250) NOT NULL,
    type VARCHAR (250) NOT NULL,
    status VARCHAR (250) NOT NULL,
    amount FLOAT NOT NULL,
    CONSTRAINT fk_author
        FOREIGN KEY (author)
            REFERENCES ers_users(id),
    CONSTRAINT fk_resolver
        FOREIGN KEY (resolver)
            REFERENCES ers_users(id)
);
INSERT INTO ers_users (USERNAME, PASSWORD, ROLE)
VALUES('Lola', 'nofreepass', 'Employee'),('BSpringsteen', 'nofreepass', 'Manager'),
('Clane', 'nofreepass', 'Manager'),('Ggaldot', 'crossword', 'Manager'),
('lalaland', 'password', 'Employee'),('ShaylaW', 'password', 'Manager'),
('Bugs', 'password', 'Employee');
INSERT INTO ers_reimbursements (author, resolver, description, "type" ,"status" , amount) values(1,2,'defcon','Conference','Pending', '10000.00');

SELECT * FROM ers_users;