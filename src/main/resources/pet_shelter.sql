CREATE TYPE public.gender AS ENUM
    ('MALE', 'FEMALE');

ALTER TYPE public.gender
    OWNER TO postgres;
	
CREATE TYPE public.species AS ENUM
    ('CAT', 'DOG');

ALTER TYPE public.species
    OWNER TO postgres;

CREATE TABLE public.animal
(
    animal_id integer NOT NULL GENERATED ALWAYS AS IDENTITY ( CYCLE INCREMENT 1 START 1 MINVALUE 1 MAXVALUE 2147483647 CACHE 1 ),
    species species NOT NULL,
    animal_gender gender NOT NULL,
    animal_age integer NOT NULL,
    animal_name character varying(20) COLLATE pg_catalog."default" NOT NULL,
    CONSTRAINT animal_pkey PRIMARY KEY (animal_id)
)

TABLESPACE pg_default;

ALTER TABLE public.animal
    OWNER to postgres;
	
CREATE TABLE public.person
(
    person_id integer NOT NULL GENERATED ALWAYS AS IDENTITY ( CYCLE INCREMENT 1 START 1 MINVALUE 1 MAXVALUE 2147483647 CACHE 1 ),
    person_name character varying(20) COLLATE pg_catalog."default" NOT NULL,
    person_surname character varying(20) COLLATE pg_catalog."default" NOT NULL,
    person_age integer NOT NULL,
    person_gender gender NOT NULL,
    CONSTRAINT person_pkey PRIMARY KEY (person_id)
)

TABLESPACE pg_default;

ALTER TABLE public.person
    OWNER to postgres;
	
INSERT INTO public.animal(
	species, animal_gender, animal_age, animal_name)
	VALUES ('DOG', 'FEMALE', 2, 'Willow');
	
INSERT INTO public.animal(
	species, animal_gender, animal_age, animal_name)
	VALUES ('DOG', 'FEMALE', 3, 'Snow White');
	
INSERT INTO public.animal(
	species, animal_gender, animal_age, animal_name)
	VALUES ('DOG', 'MALE', 6, 'Ryder');
	
INSERT INTO public.animal(
	species, animal_gender, animal_age, animal_name)
	VALUES ('DOG', 'MALE', 3, 'Remi');
	
INSERT INTO public.animal(
	species, animal_gender, animal_age, animal_name)
	VALUES ('DOG', 'MALE', 0, 'Brad');
	
INSERT INTO public.animal(
	species, animal_gender, animal_age, animal_name)
	VALUES ('CAT', 'FEMALE', 0, 'Cad Bane');
	
INSERT INTO public.animal(
	species, animal_gender, animal_age, animal_name)
	VALUES ('CAT', 'FEMALE', 3, 'Sakura');
	
INSERT INTO public.animal(
	species, animal_gender, animal_age, animal_name)
	VALUES ('CAT', 'FEMALE', 0, 'Asajj');
	
INSERT INTO public.animal(
	species, animal_gender, animal_age, animal_name)
	VALUES ('CAT', 'FEMALE', 0, 'MIla');
	
INSERT INTO public.animal(
	species, animal_gender, animal_age, animal_name)
	VALUES ('CAT', 'MALE', 0, 'Michael');
	
INSERT INTO public.person(
	person_name, person_surname, person_age, person_gender)
	VALUES ('Joseph', 'Frank', 27, 'MALE');
	
INSERT INTO public.person(
	person_name, person_surname, person_age, person_gender)
	VALUES ('David', 'Ray', 32, 'MALE');
	
INSERT INTO public.person(
	person_name, person_surname, person_age, person_gender)
	VALUES ('Joseph', 'Vaughn', 41, 'MALE');
	
INSERT INTO public.person(
	person_name, person_surname, person_age, person_gender)
	VALUES ('Linda', 'Thomas', 25, 'FEMALE');
	
INSERT INTO public.person(
	person_name, person_surname, person_age, person_gender)
	VALUES ('John', 'Jones', 28, 'MALE');