CREATE TABLE Computer (
    id INT8 PRIMARY KEY,
    serial_number UUID NOT NULL,
    manufacturer VARCHAR NOT NULL,
    price_in_rubles VARCHAR NOT NULL,
    number_of_units INTEGER NOT NULL,
    form_factor VARCHAR NOT NULL
);

CREATE TABLE Laptop (
    id INT8 PRIMARY KEY,
    serial_number UUID NOT NULL,
    manufacturer VARCHAR NOT NULL,
    price_in_rubles VARCHAR NOT NULL,
    number_of_units INTEGER NOT NULL,
    size VARCHAR NOT NULL
);

CREATE TABLE Monitor (
    id INT8 PRIMARY KEY,
    serial_number UUID NOT NULL,
    manufacturer VARCHAR NOT NULL,
    price_in_rubles VARCHAR NOT NULL,
    number_of_units INTEGER NOT NULL,
    diagonal_in_cm INTEGER NOT NULL
);

CREATE TABLE Hard_Drive (
    id INT8 PRIMARY KEY,
    serial_number UUID NOT NULL,
    manufacturer VARCHAR NOT NULL,
    price_in_rubles VARCHAR NOT NULL,
    number_of_units INTEGER NOT NULL,
    volume_in_bits INT8 NOT NULL
);