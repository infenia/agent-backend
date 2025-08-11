-- Table: iuser.family

ALTER TABLE iuser.family
    ADD COLUMN family_type text COLLATE pg_catalog."default",
    ADD COLUMN family_class text COLLATE pg_catalog."default",
    ADD COLUMN family_values text COLLATE pg_catalog."default";
