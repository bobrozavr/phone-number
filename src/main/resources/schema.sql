-- create contact_type table
create table contact_type (
    id numeric auto_increment not null,
    type varchar(255) not null
);

create unique index contact_type_id_uindex
    on contact_type (id);

alter table contact_type
    add constraint contact_type_pk
        primary key (id);

-- create person table
create table person (
	id numeric auto_increment not null,
	first_name varchar(80) not null,
	last_name varchar(80) not null,
	middle_name varchar(80) not null,
	position varchar(255) not null
);

create unique index person_id_uindex
	on person (id);

alter table person
	add constraint person_pk
		primary key (id);

-- create contacts table
create table contacts
(
	id numeric(19) auto_increment,
	person_id numeric(19) not null,
	contact_type_id numeric(19) not null,
	number varchar(20) not null,
	constraint contacts_CONTACT_TYPE_ID_fk
		foreign key (contact_type_id) references CONTACT_TYPE,
	constraint contacts_PERSON_ID_fk
		foreign key (person_id) references PERSON
);

create unique index contacts_id_uindex
	on contacts (id);

alter table contacts
	add constraint contacts_pk
		primary key (id);