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

-- Table: iuser.horoscope

DROP TABLE IF EXISTS iuser.horoscope;

CREATE TABLE IF NOT EXISTS iuser.horoscope
(
    user_id bigint NOT NULL,
    horoscope_details jsonb NOT NULL,
    created_by text COLLATE pg_catalog."default" NOT NULL,
    created_at timestamp with time zone NOT NULL DEFAULT CURRENT_TIMESTAMP,
    updated_by text COLLATE pg_catalog."default" NOT NULL,
    updated_at timestamp with time zone NOT NULL DEFAULT CURRENT_TIMESTAMP,
    version bigint NOT NULL,
    CONSTRAINT horoscope_pkey PRIMARY KEY (user_id),
    CONSTRAINT horoscope_user_id_fkey FOREIGN KEY (user_id)
        REFERENCES iuser.user_account (user_id) MATCH SIMPLE
        ON UPDATE NO ACTION
        ON DELETE NO ACTION
        NOT VALID
)

TABLESPACE pg_default;

COMMENT ON TABLE iuser.horoscope
    IS 'User Horoscope Details Table';

COMMENT ON COLUMN iuser.horoscope.user_id
    IS 'The User Id.';

COMMENT ON COLUMN iuser.horoscope.horoscope_details
    IS 'Horoscope details of the Users in json format. All horoscope documents are stored outside the database and this field only contains links to the images';

COMMENT ON COLUMN iuser.horoscope.created_by
    IS 'User Id or User Identified of who created the record.';

COMMENT ON COLUMN iuser.horoscope.created_at
    IS 'Created time of the record.';

COMMENT ON COLUMN iuser.horoscope.updated_by
    IS 'User Id or User Identified of who updated the record.';

COMMENT ON COLUMN iuser.horoscope.updated_at
    IS 'Updated time of the record.';
