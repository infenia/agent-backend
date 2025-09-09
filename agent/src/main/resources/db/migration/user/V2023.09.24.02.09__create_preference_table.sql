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

-- Table: iuser.preference

DROP TABLE IF EXISTS iuser.preference;

CREATE TABLE IF NOT EXISTS iuser.preference
(
    user_id bigint NOT NULL,
    match_preferences jsonb NOT NULL,
    restriction_preferences jsonb NOT NULL,
    created_by text COLLATE pg_catalog."default" NOT NULL,
    created_at timestamp with time zone NOT NULL DEFAULT CURRENT_TIMESTAMP,
    updated_by text COLLATE pg_catalog."default" NOT NULL,
    updated_at timestamp with time zone NOT NULL DEFAULT CURRENT_TIMESTAMP,
    version bigint NOT NULL,
    CONSTRAINT preference_pkey PRIMARY KEY (user_id),
    CONSTRAINT preference_user_id_fkey FOREIGN KEY (user_id)
        REFERENCES iuser.user_account (user_id) MATCH SIMPLE
        ON UPDATE NO ACTION
        ON DELETE NO ACTION
)

TABLESPACE pg_default;

COMMENT ON TABLE iuser.preference
    IS 'User Preferences Table';

COMMENT ON COLUMN iuser.preference.user_id
    IS 'The user userId.';

COMMENT ON COLUMN iuser.preference.match_preferences
    IS 'User preference for matches in json format.';

COMMENT ON COLUMN iuser.preference.restriction_preferences
    IS 'User preference for restriction on viewing profile in json format.';

COMMENT ON COLUMN iuser.preference.created_by
    IS 'User Id or User Identified of who created the record.';

COMMENT ON COLUMN iuser.preference.created_at
    IS 'Created time of the record.';

COMMENT ON COLUMN iuser.preference.updated_by
    IS 'User Id or User Identified of who updated the record.';

COMMENT ON COLUMN iuser.preference.updated_at
    IS 'Updated time of the record.';
