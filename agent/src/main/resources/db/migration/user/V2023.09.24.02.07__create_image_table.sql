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

-- Table: iuser.image

DROP TABLE IF EXISTS iuser.image;

CREATE TABLE IF NOT EXISTS iuser.image
(
    user_id bigint NOT NULL,
    image_details jsonb NOT NULL,
    created_by text COLLATE pg_catalog."default" NOT NULL,
    created_at timestamp with time zone NOT NULL DEFAULT CURRENT_TIMESTAMP,
    updated_by text COLLATE pg_catalog."default" NOT NULL,
    updated_at timestamp with time zone NOT NULL DEFAULT CURRENT_TIMESTAMP,
    version bigint NOT NULL,
    CONSTRAINT image_pkey PRIMARY KEY (user_id),
    CONSTRAINT image_user_id_fkey FOREIGN KEY (user_id)
        REFERENCES iuser.user_account (user_id) MATCH SIMPLE
        ON UPDATE NO ACTION
        ON DELETE NO ACTION
)

TABLESPACE pg_default;

COMMENT ON TABLE iuser.image
    IS 'User Image Table';

COMMENT ON COLUMN iuser.image.user_id
    IS 'The user Id.';

COMMENT ON COLUMN iuser.image.image_details
    IS 'Images of the users in json format. All images are stored outside the database and this field only contains links to the images';

COMMENT ON COLUMN iuser.image.created_by
    IS 'User Id or User Identified of who created the record.';

COMMENT ON COLUMN iuser.image.created_at
    IS 'Created time of the record.';

COMMENT ON COLUMN iuser.image.updated_by
    IS 'User Id or User Identified of who updated the record.';

COMMENT ON COLUMN iuser.image.updated_at
    IS 'Updated time of the record.';
