CREATE SEQUENCE `sequence_test` INCREMENT BY 50;

CREATE TABLE `user`
(
    id   BIGINT NOT NULL PRIMARY KEY,
    login VARCHAR(255)
);

CREATE TABLE attribute
(
    id   BIGINT NOT NULL PRIMARY KEY,
    name VARCHAR(255),
    user_id BIGINT NOT NULL REFERENCES `user`
);