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

-- Table: iuser.user_account

DROP TABLE IF EXISTS iuser.user_account;

CREATE TABLE IF NOT EXISTS iuser.user_account
(
    user_id bigint NOT NULL GENERATED ALWAYS AS IDENTITY ( INCREMENT 1 START 1 MINVALUE 1 MAXVALUE 9223372036854775807 CACHE 1 ),
    idp_user_id text COLLATE pg_catalog."default" NOT NULL,
    first_name text COLLATE pg_catalog."default" NOT NULL,
    middle_name text COLLATE pg_catalog."default",
    last_name text COLLATE pg_catalog."default" NOT NULL,
    mobile text COLLATE pg_catalog."default" NOT NULL,
    mobile_verified boolean NOT NULL DEFAULT false,
    email text COLLATE pg_catalog."default",
    email_verified boolean NOT NULL DEFAULT false,
    whatsapp text COLLATE pg_catalog."default",
    whatsapp_verified boolean NOT NULL DEFAULT false,
    aadhar_verified boolean NOT NULL DEFAULT false,
    agent_verified boolean NOT NULL DEFAULT false,
    is_active boolean NOT NULL DEFAULT true,
    is_subscription_active boolean NOT NULL DEFAULT false,
    created_by text COLLATE pg_catalog."default" NOT NULL,
    created_at timestamp with time zone NOT NULL DEFAULT CURRENT_TIMESTAMP,
    updated_by text COLLATE pg_catalog."default" NOT NULL,
    updated_at timestamp with time zone NOT NULL DEFAULT CURRENT_TIMESTAMP,
    version bigint NOT NULL,
    CONSTRAINT user_pkey PRIMARY KEY (user_id),
    CONSTRAINT user_email_key UNIQUE (email),
    CONSTRAINT user_idp_id_key UNIQUE (idp_user_id),
    CONSTRAINT user_mobile_key UNIQUE (mobile),
    CONSTRAINT user_whatsapp_key UNIQUE (whatsapp)
)

TABLESPACE pg_default;

COMMENT ON TABLE iuser.user_account
    IS 'User Table';

COMMENT ON COLUMN iuser.user_account.user_id
    IS 'The user userId.';

COMMENT ON COLUMN iuser.user_account.first_name
    IS 'First name of the user.';

COMMENT ON COLUMN iuser.user_account.middle_name
    IS 'Middle name of the user.';

COMMENT ON COLUMN iuser.user_account.last_name
    IS 'Last name of the user.';

COMMENT ON COLUMN iuser.user_account.mobile
    IS 'Mobile number of the user.';

COMMENT ON COLUMN iuser.user_account.mobile_verified
    IS 'User have a verified mobile.';

COMMENT ON COLUMN iuser.user_account.email
    IS 'Email of the user.';

COMMENT ON COLUMN iuser.user_account.email_verified
    IS 'User have a verified email.';

COMMENT ON COLUMN iuser.user_account.whatsapp
    IS 'WhatsApp number fo the user.';

COMMENT ON COLUMN iuser.user_account.whatsapp_verified
    IS 'User have a verified whatsapp.';

COMMENT ON COLUMN iuser.user_account.aadhar_verified
    IS 'Is aadhar verfied for the user.';

COMMENT ON COLUMN iuser.user_account.agent_verified
    IS 'True if agent has verified this user.';

COMMENT ON COLUMN iuser.user_account.is_active
    IS 'Is this user an active user. If not, login will not be allowed.';

COMMENT ON COLUMN iuser.user_account.is_subscription_active
    IS 'Is this user subscription active.';

COMMENT ON COLUMN iuser.user_account.created_by
    IS 'User Id or User Identified of who created the record.';

COMMENT ON COLUMN iuser.user_account.created_at
    IS 'Created time of the user record.';

COMMENT ON COLUMN iuser.user_account.updated_by
    IS 'User Id or User Identified of who updated the record.';

COMMENT ON COLUMN iuser.user_account.updated_at
    IS 'Last updated time of the user record';

COMMENT ON CONSTRAINT user_email_key ON iuser.user_account
    IS 'Unique constraint for user email';

COMMENT ON CONSTRAINT user_mobile_key ON iuser.user_account
    IS 'Unique constraint for user mobile number';

COMMENT ON CONSTRAINT user_whatsapp_key ON iuser.user_account
    IS 'Unique constraint for user whatsapp number';
