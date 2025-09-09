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

-- Table: iuser.family

ALTER TABLE iuser.family
    ADD COLUMN family_type text COLLATE pg_catalog."default",
    ADD COLUMN family_class text COLLATE pg_catalog."default",
    ADD COLUMN family_values text COLLATE pg_catalog."default";
