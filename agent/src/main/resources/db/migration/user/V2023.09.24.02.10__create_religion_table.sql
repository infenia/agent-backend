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

-- Table: iuser.religion

DROP TABLE IF EXISTS iuser.religion;

CREATE TABLE IF NOT EXISTS iuser.religion
(
    user_id bigint NOT NULL,
    religion text COLLATE pg_catalog."default",
    caste text COLLATE pg_catalog."default",
    sub_caste text COLLATE pg_catalog."default",
    created_by text COLLATE pg_catalog."default" NOT NULL,
    created_at timestamp with time zone NOT NULL DEFAULT CURRENT_TIMESTAMP,
    updated_by text COLLATE pg_catalog."default" NOT NULL,
    updated_at timestamp with time zone NOT NULL DEFAULT CURRENT_TIMESTAMP,
    version bigint NOT NULL,
    CONSTRAINT religion_pkey PRIMARY KEY (user_id),
    CONSTRAINT religion_user_id_fkey FOREIGN KEY (user_id)
        REFERENCES iuser.user_account (user_id) MATCH SIMPLE
        ON UPDATE NO ACTION
        ON DELETE NO ACTION
)

TABLESPACE pg_default;

COMMENT ON TABLE iuser.religion
    IS 'User Religion Details Table';

COMMENT ON COLUMN iuser.religion.user_id
    IS 'The user userId.';

COMMENT ON COLUMN iuser.religion.religion
    IS 'Religion of the user.';

COMMENT ON COLUMN iuser.religion.caste
    IS 'Caste of the user.';

COMMENT ON COLUMN iuser.religion.created_by
    IS 'User Id or User Identified of who created the record.';

COMMENT ON COLUMN iuser.religion.created_at
    IS 'Created time of the record.';

COMMENT ON COLUMN iuser.religion.updated_by
    IS 'User Id or User Identified of who updated the record.';

COMMENT ON COLUMN iuser.religion.updated_at
    IS 'Updated time of the record.';
