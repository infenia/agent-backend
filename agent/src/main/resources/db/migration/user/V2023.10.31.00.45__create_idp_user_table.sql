/*
 *
 * Copyright (c) 2025 Infenia Technologies Pvt. Ltd.
 *
 * This file is part of the EasyMarry Application.
 *
 * Licensed under the Infenia license; you may not use this file except
 * in compliance with the License. Unauthorized copying of this file,
 * via any medium is strictly prohibited.
 *
 * For more information, contact arun@infenia.com
 *
 */

-- Table: iuser.idp_user

DROP TABLE IF EXISTS iuser.idp_user;

CREATE TABLE IF NOT EXISTS iuser.idp_user
(
    idp_user_id text NOT NULL,
    user_name text COLLATE pg_catalog."default" NOT NULL,
    first_name text COLLATE pg_catalog."default" NOT NULL,
    last_name text COLLATE pg_catalog."default" NOT NULL,
    email text COLLATE pg_catalog."default",
    mobile text COLLATE pg_catalog."default" NOT NULL,
    register_method text COLLATE pg_catalog."default" NOT NULL,
    is_enabled boolean NOT NULL DEFAULT true,
    is_active boolean NOT NULL DEFAULT true,
    created_by text COLLATE pg_catalog."default" NOT NULL,
    created_at timestamp with time zone NOT NULL DEFAULT CURRENT_TIMESTAMP,
    updated_by text COLLATE pg_catalog."default" NOT NULL,
    updated_at timestamp with time zone NOT NULL DEFAULT CURRENT_TIMESTAMP,
    version bigint NOT NULL,
    CONSTRAINT idp_user_pkey PRIMARY KEY (idp_user_id),
    CONSTRAINT idp_user_name_key UNIQUE (user_name),
    CONSTRAINT idp_user_email_key UNIQUE (email),
    CONSTRAINT idp_user_mobile_key UNIQUE (mobile)
)

TABLESPACE pg_default;

COMMENT ON TABLE iuser.idp_user
    IS 'IDP User Table';

COMMENT ON COLUMN iuser.idp_user.idp_user_id
    IS 'The IDP user userId.';

COMMENT ON COLUMN iuser.idp_user.first_name
    IS 'First name of the user.';

COMMENT ON COLUMN iuser.idp_user.last_name
    IS 'Last name of the user.';

COMMENT ON COLUMN iuser.idp_user.email
    IS 'Email of the user.';

COMMENT ON COLUMN iuser.idp_user.mobile
    IS 'Mobile of the user.';

COMMENT ON COLUMN iuser.idp_user.register_method
    IS 'Method used by the user for registration.';

COMMENT ON COLUMN iuser.idp_user.is_enabled
    IS 'Flag to identify the user is enabled in the system.';

COMMENT ON COLUMN iuser.idp_user.is_active
    IS 'Is this user an active user. If not, login will not be allowed.';

COMMENT ON COLUMN iuser.idp_user.created_by
    IS 'User Id or User Identified of who created the record.';

COMMENT ON COLUMN iuser.idp_user.created_at
    IS 'Created time of the user record.';

COMMENT ON COLUMN iuser.idp_user.updated_by
    IS 'User Id or User Identified of who updated the record.';

COMMENT ON COLUMN iuser.idp_user.updated_at
    IS 'Last updated time of the user record';

COMMENT ON CONSTRAINT idp_user_name_key ON iuser.idp_user
    IS 'Unique constraint for idp user name';

COMMENT ON CONSTRAINT idp_user_email_key ON iuser.idp_user
    IS 'Unique constraint for idp user email';

COMMENT ON CONSTRAINT idp_user_mobile_key ON iuser.idp_user
    IS 'Unique constraint for idp user mobile';

