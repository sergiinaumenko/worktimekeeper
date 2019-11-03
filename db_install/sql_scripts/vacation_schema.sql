\c timekeeper;
DROP TABLE IF EXISTS user_info;
CREATE TABLE user_info (
	user_id int8 NOT NULL,
	user_name varchar(150) NOT NULL,
	user_email varchar(150) NOT NULL,
	user_role varchar(50) NOT NULL,
	CONSTRAINT user_info_pk PRIMARY KEY (user_id)
);
DROP TABLE IF EXISTS vacation_request_type;
CREATE TABLE vacation_request_type (
	vrt_id int8 NOT NULL,
	vrt_type varchar(50) NOT NULL,
	vrt_description varchar NULL,
	CONSTRAINT vacation_request_type_pk PRIMARY KEY (vrt_id)
);
DROP TABLE IF EXISTS vacation_request;
CREATE TABLE vacation_request (
	vr_id int8 NOT NULL,
	vr_user_id int8 NOT NULL,
	vr_status varchar(50) NOT NULL,
	vr_start_date timestamp NOT NULL,
	vr_end_date timestamp NOT NULL,
	vr_type_id int8 NOT NULL,
	CONSTRAINT vacation_request_pk PRIMARY KEY (vr_id),
	CONSTRAINT vacation_request_fk FOREIGN KEY (vr_type_id) REFERENCES vacation_request_type(vrt_id)
);
DROP TABLE IF EXISTS holidays;
CREATE TABLE holidays (
	h_id bigint NOT NULL,
	h_date date NOT NULL,
	h_name varchar NOT NULL,
	h_description varchar NULL,
	CONSTRAINT holidays_pk PRIMARY KEY (h_id)
);
DROP TABLE IF EXISTS user_manager_mapping;
CREATE TABLE user_manager_mapping (
	um_manager_id int8 NOT NULL,
	um_user_id int8 NOT NULL,
	CONSTRAINT user_manager_mapping_pk PRIMARY KEY (um_manager_id, um_user_id),
	CONSTRAINT um_manager_mapping_fk FOREIGN KEY (um_manager_id) REFERENCES user_info(user_id),
	CONSTRAINT um_user_mapping_fk FOREIGN KEY (um_user_id) REFERENCES user_info(user_id)
);
DROP SEQUENCE IF EXISTS user_info_seq;
CREATE SEQUENCE user_info_seq
    START 1
    INCREMENT 1
    NO MAXVALUE
    CACHE 1;
DROP SEQUENCE IF EXISTS vacation_request_type_seq;
CREATE SEQUENCE vacation_request_type_seq
    START 1
    INCREMENT 1
    NO MAXVALUE
    CACHE 1;
DROP SEQUENCE IF EXISTS vacation_request_seq;
CREATE SEQUENCE vacation_request_seq
    START 1
    INCREMENT 1
    NO MAXVALUE
    CACHE 1;
DROP SEQUENCE IF EXISTS holidays_seq;
CREATE SEQUENCE holidays_seq
    START 1
    INCREMENT 1
    NO MAXVALUE
    CACHE 1;