-- liquibase formatted sql
-- changeset jrembo:1

CREATE INDEX users_students_idx ON students (name);

CREATE INDEX users_faculties_idx ON faculties (color, name);