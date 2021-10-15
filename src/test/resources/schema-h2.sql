CREATE TABLE IF NOT exists profiles (
	id serial NOT NULL,
	your_passion varchar(100) NOT NULL,
	monthly_salary_min numeric(19,4) NOT NULL,
	monthly_salary_max numeric(19,4) NOT NULL,
	age_min int4 NOT NULL,
	age_max int4 NOT NULL,
	credit_cards text NULL,
	CONSTRAINT pk_profiles PRIMARY KEY (id)
);
