create table goal (
id bigint not null auto_increment, 
name varchar(150) not null, 
description longtext not null, 
actual_value float(10,2) not null default '0.00', 
goal_value float(10,2) not null default '0.00',  
created_date datetime not null default current_timestamp, 
primary key (id)
)
