-- insert into contact_type (id, type) values (1, 'HOME' );
insert into contact_type (type) values ('HOME' );
-- insert into contact_type (id, type) values (2, 'WORK' );
insert into contact_type (type) values ('WORK' );
-- insert into contact_type (id, type) values (3, 'CELL' );
insert into contact_type (type) values ('CELL' );

-- insert into person
insert into person (first_name, last_name, middle_name, position) values ( 'Ivan', 'Ivanov', 'Ivanovich', 'developer');

-- insert into contact
insert into contacts (person_id, contact_type_id, number) values ( 1, 1, '123' );
insert into contacts (person_id, contact_type_id, number) values ( 1, 2, '456' );
insert into contacts (person_id, contact_type_id, number) values ( 1, 3, '789' );