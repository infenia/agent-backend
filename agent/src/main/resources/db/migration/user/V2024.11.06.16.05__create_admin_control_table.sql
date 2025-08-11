BEGIN;

-- Table: iuser.admin_control

DROP TABLE IF EXISTS iuser.admin_control;

CREATE TABLE IF NOT EXISTS iuser.admin_control
(
    user_id bigint NOT NULL,
    admin_control_details jsonb NOT NULL,
    created_by text COLLATE pg_catalog."default" NOT NULL,
    created_at timestamp with time zone NOT NULL DEFAULT CURRENT_TIMESTAMP,
    updated_by text COLLATE pg_catalog."default" NOT NULL,
    updated_at timestamp with time zone NOT NULL DEFAULT CURRENT_TIMESTAMP,
    version bigint NOT NULL,
    CONSTRAINT admin_control_pkey PRIMARY KEY (user_id),
    CONSTRAINT admin_control_user_id_fkey FOREIGN KEY (user_id)
        REFERENCES iuser.user_account (user_id) MATCH SIMPLE
        ON UPDATE NO ACTION
        ON DELETE NO ACTION
)

TABLESPACE pg_default;

COMMENT ON TABLE iuser.admin_control
    IS 'User Admin Control Table';

COMMENT ON COLUMN iuser.admin_control.user_id
    IS 'The user Id.';

COMMENT ON COLUMN iuser.admin_control.admin_control_details
    IS 'Admin Control details of the user as json object.';

COMMENT ON COLUMN iuser.admin_control.created_by
    IS 'User Id or User Identified of who created the record.';

COMMENT ON COLUMN iuser.admin_control.created_at
    IS 'Created time of the record.';

COMMENT ON COLUMN iuser.admin_control.updated_by
    IS 'User Id or User Identified of who updated the record.';

COMMENT ON COLUMN iuser.admin_control.updated_at
    IS 'Updated time of the record.';
