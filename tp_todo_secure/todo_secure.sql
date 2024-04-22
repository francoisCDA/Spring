
drop DATABASE IF EXISTS todosecure;

use todosecure;

INSERT INTO role (id,role) values (1,"ROLE_ADMIN") ;
INSERT INTO role (id,role) values (2,"ROLE_USER") ;
INSERT INTO role (id,role) values (3,"ROLE_TEST") ;

select * FROM users;

select * FROM role;