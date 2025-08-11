ALTER TABLE iuser.idp_user
ADD COLUMN em_id bigint;

ALTER TABLE iuser.idp_user
ADD CONSTRAINT idp_user_em_id_fkey
FOREIGN KEY (em_id) REFERENCES iuser.user_account (user_id) MATCH SIMPLE
ON UPDATE NO ACTION
ON DELETE NO ACTION;

COMMENT ON COLUMN iuser.idp_user.em_id
    IS 'The EasyMarry Id of the user.'