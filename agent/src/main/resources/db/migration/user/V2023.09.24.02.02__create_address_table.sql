-- Table: iuser.address

DROP TABLE IF EXISTS iuser.address;

CREATE TABLE IF NOT EXISTS iuser.address
(
    user_id bigint NOT NULL,
    address_details jsonb NOT NULL,
    created_by text COLLATE pg_catalog."default" NOT NULL,
    created_at timestamp with time zone NOT NULL DEFAULT CURRENT_TIMESTAMP,
    updated_by text COLLATE pg_catalog."default" NOT NULL,
    updated_at timestamp with time zone NOT NULL DEFAULT CURRENT_TIMESTAMP,
    version bigint NOT NULL,
    CONSTRAINT address_pkey PRIMARY KEY (user_id),
    CONSTRAINT address_user_type_key UNIQUE (user_id),
    CONSTRAINT address_user_fkey FOREIGN KEY (user_id)
        REFERENCES iuser.user_account (user_id) MATCH SIMPLE
        ON UPDATE NO ACTION
        ON DELETE NO ACTION
)

TABLESPACE pg_default;

COMMENT ON TABLE iuser.address
    IS 'User Address Table';

COMMENT ON COLUMN iuser.address.user_id
    IS 'The User Id.';

COMMENT ON COLUMN iuser.address.address_details
    IS 'Address details as json array.';

COMMENT ON COLUMN iuser.address.created_by
    IS 'User Id or User Identified of who created the record.';

COMMENT ON COLUMN iuser.address.created_at
    IS 'Created time of the record.';

COMMENT ON COLUMN iuser.address.updated_by
    IS 'User Id or User Identified of who updated the record.';

COMMENT ON COLUMN iuser.address.updated_at
    IS 'Updated time of the record.';
