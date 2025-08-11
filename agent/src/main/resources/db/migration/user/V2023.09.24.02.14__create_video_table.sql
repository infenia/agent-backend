-- Table: iuser.video

DROP TABLE IF EXISTS iuser.video;

CREATE TABLE IF NOT EXISTS iuser.video
(
    user_id bigint NOT NULL,
    video_details jsonb NOT NULL,
    created_by text COLLATE pg_catalog."default" NOT NULL,
    created_at timestamp with time zone NOT NULL DEFAULT CURRENT_TIMESTAMP,
    updated_by text COLLATE pg_catalog."default" NOT NULL,
    updated_at timestamp with time zone NOT NULL DEFAULT CURRENT_TIMESTAMP,
    version bigint NOT NULL,
    CONSTRAINT video_pkey PRIMARY KEY (user_id),
    CONSTRAINT video_user_id_fkey FOREIGN KEY (user_id)
        REFERENCES iuser.user_account (user_id) MATCH SIMPLE
        ON UPDATE NO ACTION
        ON DELETE NO ACTION
)

TABLESPACE pg_default;

COMMENT ON TABLE iuser.video
    IS 'User Video Table';

COMMENT ON COLUMN iuser.video.user_id
    IS 'The user userId.';

COMMENT ON COLUMN iuser.video.video_details
    IS 'Video details of the users in json format. All videos are stored outside the database and this field only contains links and other details of the videos';

COMMENT ON COLUMN iuser.video.created_by
    IS 'User Id or User Identified of who created the record.';

COMMENT ON COLUMN iuser.video.created_at
    IS 'Created time of the record.';

COMMENT ON COLUMN iuser.video.updated_by
    IS 'User Id or User Identified of who updated the record.';

COMMENT ON COLUMN iuser.video.updated_at
    IS 'Updated time of the record.';
