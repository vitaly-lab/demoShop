INSERT INTO users (id, archive, email, name, password, role, bucket_id)
-- INSERT INTO users (id, archive, email, name, password, role)
VALUES (1, false, 'vitkom@inbox.lv', 'admin', 'pass', 'ADMIN',  null);

ALTER SEQUENCE user_seq RESTART WITH 2;
