insert into users (id,pwd,uname,surname,email) 
values (1000,'123','Taner',' TEMEL','tanertemel@outlook.com');

insert into project(id,created_at,status,project_code,project_name,manager_user_id)
values (1000,now(),true,'ISMAN','Issue Management System',1000);

insert into issue (id,created_at,status,date,description,details,issue_status,assignee_user_id,project_id)
values (1000,now(),true,now(),'Username should be unique','User registration step, username should be checked for unique username','IN_PROGRESS',1000,1000);

insert into issue (id,created_at,status,date,description,details,issue_status,assignee_user_id,project_id)
values (1001,now(),true,now(),'API throwing an exception for null values','API throwing an exception for null values','IN_REVIEW',1000,1000);

insert into issue_history (id,created_at,status,date,description,details,issue_status,assignee_user_id,issue_id)
values (1000,now(),true,now(),'Username should be unique','User registration step, username should be checked for unique username','OPEN',1000,1000);


-- insert into users (id,pwd,uname,surname,email) 
-- values (1001,'123','Mehmet',' KÜRE','mehmet.k@outlook.com');

-- insert into project(id,created_at,status,project_code,project_name,manager_user_id)
-- values (1001,now(),true,'TFF-MAN','TFF Management System',1001);

-- insert into issue (id,created_at,status,date,description,details,issue_status,assignee_user_id,project_id)
-- values (1002,now(),true,now(),'Players should be perfect','Players registration step, Players should be checked for Mehmet Küre','IN_PROGRESS',1001,1001);

-- insert into issue (id,created_at,status,date,description,details,issue_status,assignee_user_id,project_id)
-- values (1003,now(),true,now(),'All of team throwing stone','All of team throwing stone for players','IN_REVIEW',1001,1001);

-- insert into issue_history (id,created_at,status,date,description,details,issue_status,assignee_user_id,issue_id)
-- values (1001,now(),true,now(),'Players should be unique','All of team throwing stone, Players should be checked for Captain','OPEN',1001,1002);

-- insert into issue_history (id,created_at,status,date,description,details,issue_status,assignee_user_id,issue_id)
-- values (1002,now(),true,now(),'Players should be perfect','This team throwing stone, Players should not be allowed to throw stones','OPEN',1001,1002);