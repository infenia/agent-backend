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

-- Table: iuser.culture

DROP TABLE IF EXISTS iuser.culture;

CREATE TABLE IF NOT EXISTS iuser.culture
(
    user_id bigint NOT NULL,
    culture_details jsonb NOT NULL,
    created_by text COLLATE pg_catalog."default" NOT NULL,
    created_at timestamp with time zone NOT NULL DEFAULT CURRENT_TIMESTAMP,
    updated_by text COLLATE pg_catalog."default" NOT NULL,
    updated_at timestamp with time zone NOT NULL DEFAULT CURRENT_TIMESTAMP,
    version bigint NOT NULL,
    CONSTRAINT culture_pkey PRIMARY KEY (user_id),
    CONSTRAINT culture_user_id_fkey FOREIGN KEY (user_id)
        REFERENCES iuser.user_account (user_id) MATCH SIMPLE
        ON UPDATE NO ACTION
        ON DELETE NO ACTION
)

TABLESPACE pg_default;

COMMENT ON TABLE iuser.culture
    IS 'User Culture Table';

COMMENT ON COLUMN iuser.culture.user_id
    IS 'The user Id.';

COMMENT ON COLUMN iuser.culture.culture_details
    IS 'Culture details of the user as json object.';

COMMENT ON COLUMN iuser.culture.created_by
    IS 'User Id or User Identified of who created the record.';

COMMENT ON COLUMN iuser.culture.created_at
    IS 'Created time of the record.';

COMMENT ON COLUMN iuser.culture.updated_by
    IS 'User Id or User Identified of who updated the record.';

COMMENT ON COLUMN iuser.culture.updated_at
    IS 'Updated time of the record.';
