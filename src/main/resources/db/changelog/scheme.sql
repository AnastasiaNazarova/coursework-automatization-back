--liquibase formatted sql
--changeset nazarova:1:create_table_staff

CREATE TABLE public."staff" (
                       "id"          INTEGER PRIMARY KEY NOT NULL,
                      "name_staff"       TEXT NOT NULL,
                       "data_created_staff"   DATE NOT NULL
);
CREATE SEQUENCE public."staff_seq";

--changeset nazarova:2:create_table_group

CREATE TABLE public."group" (
                         "id"           INTEGER  PRIMARY KEY NOT NULL,
                         "name_group"          TEXT NOT NULL,
                         "data_created_group"   DATE NOT NULL,
                         "staff_id"     INTEGER NOT NULL,

     CONSTRAINT "fk_staff"
        FOREIGN KEY ("staff_id")
            REFERENCES staff ("id")
);
CREATE SEQUENCE public."group_seq";

--changeset nazarova:3:create_table_member_rso
CREATE TABLE public."member_rso"
(
    "id"   INTEGER PRIMARY KEY NOT NULL,
    "full_name"       TEXT  NOT NULL,
    "data_birth"        DATE NOT NULL,
    "group_id"       INTEGER  NOT NULL,
    "post"             TEXT  NOT NULL,
    "year_set"          INTEGER NOT NULL,

        CONSTRAINT "fk_group"
          FOREIGN KEY ("group_id")
           REFERENCES public."group" ("id")

);
CREATE SEQUENCE public."member_rso_seq";

