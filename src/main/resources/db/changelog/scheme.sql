--liquibase formatted sql
--changeset nazarova:1:create_table_staff

CREATE TABLE "staff" (
                       "id"          INTEGER PRIMARY KEY NOT NULL,
                      "name_staff"       TEXT NOT NULL,
                       "data_created_staff"   DATE NOT NULL
);
CREATE SEQUENCE "staff_seq";

--changeset nazarova:2:create_table_group

CREATE TABLE "group" (
                         "id"           INTEGER  PRIMARY KEY NOT NULL,
                         "name_group"          TEXT NOT NULL,
                         "data_created_group"   DATE NOT NULL,
                         "staff_id"     INTEGER NOT NULL,

     CONSTRAINT "fk_staff"
        FOREIGN KEY ("staff_id")
            REFERENCES staff ("id")
            ON DELETE CASCADE
            ON UPDATE CASCADE
);
CREATE SEQUENCE "group_seq";

--changeset nazarova:3:create_table_member_rso
CREATE TABLE "member_rso"
(
    "id"   INTEGER PRIMARY KEY NOT NULL,
    "full_name"       TEXT  NOT NULL,
    "data_birth"        DATE NOT NULL,
    "group_id"       INTEGER  NOT NULL,
    "post"             TEXT  NOT NULL,
    "year_set"          INTEGER NOT NULL,

        CONSTRAINT "fk_group"
          FOREIGN KEY ("group_id")
           REFERENCES "group" ("id")
              ON DELETE CASCADE
              ON UPDATE CASCADE
);
CREATE SEQUENCE "member_rso_seq";

