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

BEGIN;

-- Table: iuser.user_control

DROP TABLE IF EXISTS iuser.user_control;

CREATE TABLE IF NOT EXISTS iuser.user_control
(
    user_id bigint NOT NULL,
    user_control_details jsonb NOT NULL,
    created_by text COLLATE pg_catalog."default" NOT NULL,
    created_at timestamp with time zone NOT NULL DEFAULT CURRENT_TIMESTAMP,
    updated_by text COLLATE pg_catalog."default" NOT NULL,
    updated_at timestamp with time zone NOT NULL DEFAULT CURRENT_TIMESTAMP,
    version bigint NOT NULL,
    CONSTRAINT user_control_pkey PRIMARY KEY (user_id),
    CONSTRAINT user_control_user_id_fkey FOREIGN KEY (user_id)
        REFERENCES iuser.user_account (user_id) MATCH SIMPLE
        ON UPDATE NO ACTION
        ON DELETE NO ACTION
)

TABLESPACE pg_default;

COMMENT ON TABLE iuser.user_control
    IS 'User User Control Table';

COMMENT ON COLUMN iuser.user_control.user_id
    IS 'The user Id.';

COMMENT ON COLUMN iuser.user_control.user_control_details
    IS 'User Control details of the user as json object.';

COMMENT ON COLUMN iuser.user_control.created_by
    IS 'User Id or User Identified of who created the record.';

COMMENT ON COLUMN iuser.user_control.created_at
    IS 'Created time of the record.';

COMMENT ON COLUMN iuser.user_control.updated_by
    IS 'User Id or User Identified of who updated the record.';

COMMENT ON COLUMN iuser.user_control.updated_at
    IS 'Updated time of the record.';
