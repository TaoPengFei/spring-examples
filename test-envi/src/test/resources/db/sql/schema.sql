DROP TABLE IF EXISTS sys_user;

CREATE TABLE sys_user (
  id   BIGINT NOT NULL,
  name VARCHAR(255),
  PRIMARY KEY (id)
)