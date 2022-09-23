-- DROP SCHEMA public;

CREATE SCHEMA public AUTHORIZATION postgres;

-- DROP SEQUENCE public.rocra_id;

CREATE SEQUENCE public.rocra_id
	INCREMENT BY 1
	MINVALUE 1
	MAXVALUE 9223372036854775807
	START 1
	CACHE 1
	NO CYCLE;-- public.obligor_detail definition

-- Drop table

-- DROP TABLE public.obligor_detail;

CREATE TABLE public.obligor_detail (
	id int4 NULL,
	sec_category text NULL,
	industry_group text NULL,
	obligor_name text NULL,
	legal_entity_identifier text NULL,
	central_index_key text NULL,
	obligor_identifier text NULL,
	obligor_identifier_scheme text NULL,
	obligor_identifier_other_scheme text NULL,
	rocra_id int4 NULL
);


-- public.obligor_rating_detail definition

-- Drop table

-- DROP TABLE public.obligor_rating_detail;

CREATE TABLE public.obligor_rating_detail (
	id int4 NULL,
	issuer_paid text NULL,
	rating text NULL,
	rating_action_date date NULL,
	rating_action_class text NULL,
	watch_status text NULL,
	rating_outlook text NULL,
	other_announcement text NULL,
	rating_type text NULL,
	rating_subtype_scheme text NULL,
	rating_type_term text NULL
);


-- public.record_of_credit_rating_action definition

-- Drop table

-- DROP TABLE public.record_of_credit_rating_action;

CREATE TABLE public.record_of_credit_rating_action (
	id int4 NULL,
	rating_agency_name text NULL,
	file_creation_dt text NULL
);
