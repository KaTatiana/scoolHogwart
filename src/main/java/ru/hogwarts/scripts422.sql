--человека есть имя, возраст и признак того, что у него есть права (или их нет)
CREATE TABLE human (
    NameHuman CHARACTER(100) NOT NULL,
    Age INTEGER CHECK (Age > 18) NOT NULL,
    DriverLicense BOOLEAN NOT NULL,
    NumAvto CHARACTER(9) NOT NULL
);

--машины есть марка, модель и стоимость.
CREATE TABLE car (
    BrandСar CHARACTER(100) NOT NULL,
    ModelCar CHARACTER(100) NOT NULL,
    PriceCar NUMERIC(9,2) NOT NULL,
    NumAvto CHARACTER(9) NOT NULL PRIMARY KEY
);