-- Table: iuser.social_media

DROP TABLE IF EXISTS iuser.social_media;

CREATE TABLE IF NOT EXISTS iuser.social_media
(
    user_id bigint NOT NULL,
    social_media_details jsonb NOT NULL,
    created_by text COLLATE pg_catalog."default" NOT NULL,
    created_at timestamp with time zone NOT NULL DEFAULT CURRENT_TIMESTAMP,
    updated_by text COLLATE pg_catalog."default" NOT NULL,
    updated_at timestamp with time zone NOT NULL DEFAULT CURRENT_TIMESTAMP,
    version bigint NOT NULL,
    CONSTRAINT social_media_pkey PRIMARY KEY (user_id),
    CONSTRAINT social_media_user_id_fkey FOREIGN KEY (user_id)
        REFERENCES iuser.user_account (user_id) MATCH SIMPLE
        ON UPDATE NO ACTION
        ON DELETE NO ACTION
)

TABLESPACE pg_default;

COMMENT ON TABLE iuser.social_media
    IS 'User Social Media Table';

COMMENT ON COLUMN iuser.social_media.user_id
    IS 'The user userId.';

COMMENT ON COLUMN iuser.social_media.social_media_details
    IS 'Socail Media details of the users in json format';

COMMENT ON COLUMN iuser.social_media.created_by
    IS 'User Id or User Identified of who created the record.';

COMMENT ON COLUMN iuser.social_media.created_at
    IS 'Created time of the record.';

COMMENT ON COLUMN iuser.social_media.updated_by
    IS 'User Id or User Identified of who updated the record.';

COMMENT ON COLUMN iuser.social_media.updated_at
    IS 'Updated time of the record.';
