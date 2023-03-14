--Возраст студента не может быть меньше 16 лет
ALTER TABLE students ADD CONSTRAINT age CHECK (age > 16);

-- Имена студентов должны быть уникальными и не равны нулю
ALTER TABLE students ADD CONSTRAINT name varchar UNIQUE;
ALTER TABLE students ALTER COLUMN name SET NOT NULL;

-- Пара “значение названия” - “цвет факультета” должна быть уникальной
ALTER TABLE faculties ADD CONSTRAINT color_name UNIQUE (color, name);

-- При создании студента без возраста ему автоматически должно присваиваться 20 лет
ALTER TABLE students ADD age DEFAULT 20;