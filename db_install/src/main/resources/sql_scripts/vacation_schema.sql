drop table IF EXISTS user_manager_mapping;
drop table IF EXISTS user_group_mapping;
drop table IF EXISTS user_details;
drop table IF EXISTS request;
drop table IF EXISTS request_type;
drop table IF EXISTS holidays;
drop table IF EXISTS user_groups;
drop sequence IF EXISTS user_details_seq;
drop sequence IF EXISTS request_seq;
drop sequence IF EXISTS request_type_seq;
drop sequence IF EXISTS holidays_seq;
drop sequence IF EXISTS user_groups_seq;
create TABLE user_details (
	user_id int8 NOT NULL,
	user_name varchar(150) NOT NULL,
	user_email varchar(150) NOT NULL,
	user_role varchar(50) NOT NULL,
	user_working_day_duration int8 NOT NULL,
	user_start_date date NULL,
	CONSTRAINT user_details_pk PRIMARY KEY (user_id)
);
create TABLE request_type (
	rt_id int8 NOT NULL,
	rt_type varchar(50) NOT NULL,
	rt_description varchar NULL,
	CONSTRAINT request_type_pk PRIMARY KEY (rt_id)
);
create TABLE request (
	r_id int8 NOT NULL,
	r_user_id int8 NOT NULL,
	r_status varchar(50) NOT NULL,
	r_start_date timestamp NOT NULL,
	r_end_date timestamp NOT NULL,
	r_type_id int8 NOT NULL,
	CONSTRAINT request_pk PRIMARY KEY (r_id),
	CONSTRAINT request_fk FOREIGN KEY (r_type_id) REFERENCES request_type(rt_id)
);
create TABLE holidays (
	h_id bigint NOT NULL,
	h_date date NOT NULL,
	h_name varchar NOT NULL,
	h_description varchar NULL,
	CONSTRAINT holidays_pk PRIMARY KEY (h_id)
);
create TABLE user_manager_mapping (
	um_manager_id int8 NOT NULL,
	um_user_id int8 NOT NULL,
	CONSTRAINT user_manager_mapping_pk PRIMARY KEY (um_manager_id, um_user_id),
	CONSTRAINT um_manager_mapping_fk FOREIGN KEY (um_manager_id) REFERENCES user_details(user_id),
	CONSTRAINT um_user_mapping_fk FOREIGN KEY (um_user_id) REFERENCES user_details(user_id)
);
create TABLE user_groups (
	group_id int8 NOT NULL,
	group_name varchar(150) NOT NULL,
	group_description varchar NULL,
	CONSTRAINT groups_pk PRIMARY KEY (group_id)
);
create TABLE user_group_mapping (
	ugm_user_id int8 NOT NULL,
	ugm_group_id int8 NOT NULL,
	CONSTRAINT user_group_mapping_pk PRIMARY KEY (ugm_user_id, ugm_group_id),
	CONSTRAINT ugm_group_fk FOREIGN KEY (ugm_group_id) REFERENCES user_groups(group_id),
	CONSTRAINT ugm_user_fk FOREIGN KEY (ugm_user_id) REFERENCES user_details(user_id)
);
create sequence user_details_seq
    start 1
    increment 1
    NO MAXVALUE
    CACHE 1;
create sequence request_type_seq
    start 1
    increment 1
    NO MAXVALUE
    CACHE 1;
create sequence request_seq
    start 1
    increment 1
    NO MAXVALUE
    CACHE 1;
create sequence holidays_seq
    start 1
    increment 1
    NO MAXVALUE
    CACHE 1;
create sequence user_groups_seq
    start 1
    increment 1
    NO MAXVALUE
    CACHE 1;