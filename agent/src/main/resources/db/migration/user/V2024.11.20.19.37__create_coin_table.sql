BEGIN;

-- Table: iuser.coin

DROP TABLE IF EXISTS iuser.coin;

CREATE TABLE IF NOT EXISTS iuser.coin
(
    user_id bigint NOT NULL,
    coin_details jsonb NOT NULL,
    created_by text COLLATE pg_catalog."default" NOT NULL,
    created_at timestamp with time zone NOT NULL DEFAULT CURRENT_TIMESTAMP,
    updated_by text COLLATE pg_catalog."default" NOT NULL,
    updated_at timestamp with time zone NOT NULL DEFAULT CURRENT_TIMESTAMP,
    version bigint NOT NULL,
    CONSTRAINT coin_pkey PRIMARY KEY (user_id),
    CONSTRAINT coin_user_id_fkey FOREIGN KEY (user_id)
        REFERENCES iuser.user_account (user_id) MATCH SIMPLE
        ON UPDATE NO ACTION
        ON DELETE NO ACTION
)

TABLESPACE pg_default;

COMMENT ON TABLE iuser.coin
    IS 'User Coin Table';

COMMENT ON COLUMN iuser.coin.user_id
    IS 'The user Id.';

COMMENT ON COLUMN iuser.coin.coin_details
    IS 'Coin details of the user as json object.';

COMMENT ON COLUMN iuser.coin.created_by
    IS 'User Id or User Identified of who created the record.';

COMMENT ON COLUMN iuser.coin.created_at
    IS 'Created time of the record.';

COMMENT ON COLUMN iuser.coin.updated_by
    IS 'User Id or User Identified of who updated the record.';

COMMENT ON COLUMN iuser.coin.updated_at
    IS 'Updated time of the record.';

