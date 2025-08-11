-- Table: iuser.education

DROP TABLE IF EXISTS iuser.education;

CREATE TABLE IF NOT EXISTS iuser.education
(
    user_id bigint NOT NULL,
    highest_qualification text COLLATE pg_catalog."default",
    qualifications jsonb,
    created_by text COLLATE pg_catalog."default" NOT NULL,
    created_at timestamp with time zone NOT NULL DEFAULT CURRENT_TIMESTAMP,
    updated_by text COLLATE pg_catalog."default" NOT NULL,
    updated_at timestamp with time zone NOT NULL DEFAULT CURRENT_TIMESTAMP,
    version bigint NOT NULL,
    CONSTRAINT education_pkey PRIMARY KEY (user_id),
    CONSTRAINT education_user_id_fkey FOREIGN KEY (user_id)
        REFERENCES iuser.user_account (user_id) MATCH SIMPLE
        ON UPDATE NO ACTION
        ON DELETE NO ACTION
)

TABLESPACE pg_default;

COMMENT ON TABLE iuser.education
    IS 'User Education Details Table';

COMMENT ON COLUMN iuser.education.user_id
    IS 'The User Id.';

COMMENT ON COLUMN iuser.education.highest_qualification
    IS 'Highest qualification of the user.';

COMMENT ON COLUMN iuser.education.qualifications
    IS 'Qualifications of a user in json format.';

COMMENT ON COLUMN iuser.education.created_by
    IS 'User Id or User Identified of who created the record.';

COMMENT ON COLUMN iuser.education.created_at
    IS 'Created time of the user record.';

COMMENT ON COLUMN iuser.education.updated_by
    IS 'User Id or User Identified of who updated the record.';

COMMENT ON COLUMN iuser.education.updated_at
    IS 'Last updated time of the user record';
