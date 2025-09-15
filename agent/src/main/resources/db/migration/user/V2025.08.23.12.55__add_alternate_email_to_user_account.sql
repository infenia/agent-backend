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

-- Migration: Add alternate_email column to iuser.user_account
-- Author: Ranjima
-- Date: 2025-08-23

ALTER TABLE iuser.user_account
    ADD COLUMN alternate_email VARCHAR(255);

-- Add a unique constraint only for non-null values
CREATE UNIQUE INDEX user_account_alternate_email_uindex
    ON iuser.user_account (alternate_email)
    WHERE alternate_email IS NOT NULL;

COMMENT ON COLUMN iuser.user_account.alternate_email
    IS 'Secondary email address of the user, optional, must be unique if provided.';
