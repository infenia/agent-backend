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

-- Table: iuser.profession

DROP TABLE IF EXISTS iuser.profession;

CREATE TABLE IF NOT EXISTS iuser.profession
(
    user_id bigint NOT NULL,
    profession_details jsonb NOT NULL,
    created_by text COLLATE pg_catalog."default" NOT NULL,
    created_at timestamp with time zone NOT NULL DEFAULT CURRENT_TIMESTAMP,
    updated_by text COLLATE pg_catalog."default" NOT NULL,
    updated_at timestamp with time zone NOT NULL DEFAULT CURRENT_TIMESTAMP,
    version bigint NOT NULL,
    CONSTRAINT profession_pkey PRIMARY KEY (user_id),
    CONSTRAINT profession_user_id_fkey FOREIGN KEY (user_id)
        REFERENCES iuser.user_account (user_id) MATCH SIMPLE
        ON UPDATE NO ACTION
        ON DELETE NO ACTION
)

TABLESPACE pg_default;

COMMENT ON TABLE iuser.profession
    IS 'User Pofession Details Table';

COMMENT ON COLUMN iuser.profession.user_id
    IS 'The user userId.';

COMMENT ON COLUMN iuser.profession.profession_details
    IS 'Profession details of the users in json format';

COMMENT ON COLUMN iuser.profession.created_by
    IS 'User Id or User Identified of who created the record.';

COMMENT ON COLUMN iuser.profession.created_at
    IS 'Created time of the record.';

COMMENT ON COLUMN iuser.profession.updated_by
    IS 'User Id or User Identified of who updated the record.';

COMMENT ON COLUMN iuser.profession.updated_at
    IS 'Updated time of the record.';
