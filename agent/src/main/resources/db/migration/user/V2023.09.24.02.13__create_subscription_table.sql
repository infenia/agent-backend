-- Table: iuser.subscription

DROP TABLE IF EXISTS iuser.subscription;

CREATE TABLE IF NOT EXISTS iuser.subscription
(
    user_id bigint NOT NULL,
    subscription_details jsonb NOT NULL,
    created_by text COLLATE pg_catalog."default" NOT NULL,
    created_at timestamp with time zone NOT NULL DEFAULT CURRENT_TIMESTAMP,
    updated_by text COLLATE pg_catalog."default" NOT NULL,
    updated_at timestamp with time zone NOT NULL DEFAULT CURRENT_TIMESTAMP,
    version bigint NOT NULL,
    CONSTRAINT subscription_pkey PRIMARY KEY (user_id),
    CONSTRAINT subscription_user_id_fkey FOREIGN KEY (user_id)
        REFERENCES iuser.user_account (user_id) MATCH SIMPLE
        ON UPDATE NO ACTION
        ON DELETE NO ACTION
)

TABLESPACE pg_default;

COMMENT ON TABLE iuser.subscription
    IS 'User Subscription Table.';

COMMENT ON COLUMN iuser.subscription.user_id
    IS 'The user userId.';

COMMENT ON COLUMN iuser.subscription.subscription_details
    IS 'Subscription details of the user. It will contain details of both active and inactive subscriptions of the user';

COMMENT ON COLUMN iuser.subscription.created_by
    IS 'User Id or User Identified of who created the record.';

COMMENT ON COLUMN iuser.subscription.created_at
    IS 'Created time of the record.';

COMMENT ON COLUMN iuser.subscription.updated_by
    IS 'User Id or User Identified of who updated the record.';

COMMENT ON COLUMN iuser.subscription.updated_at
    IS 'Subscription is valid until this date.';
