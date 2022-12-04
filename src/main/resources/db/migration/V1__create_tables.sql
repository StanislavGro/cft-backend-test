CREATE TABLE Computer (
    id BIGINT PRIMARY KEY,
    serial_number BIGINT NOT NULL,
    manufacturer VARCHAR NOT NULL,
    price VARCHAR NOT NULL,
    number_of_units INTEGER NOT NULL,
    form_factor VARCHAR NOT NULL
);

CREATE TABLE Laptop (
    id BIGINT PRIMARY KEY,
    serial_number BIGINT NOT NULL,
    manufacturer VARCHAR NOT NULL,
    price VARCHAR NOT NULL,
    number_of_units INTEGER NOT NULL,
    size VARCHAR NOT NULL
);

CREATE TABLE Monitor (
    id BIGINT PRIMARY KEY,
    serial_number BIGINT NOT NULL,
    manufacturer VARCHAR NOT NULL,
    price VARCHAR NOT NULL,
    number_of_units INTEGER NOT NULL,
    diagonal INTEGER NOT NULL
);

CREATE TABLE Hard_Drive (
    id BIGINT PRIMARY KEY,
    serial_number BIGINT NOT NULL,
    manufacturer VARCHAR NOT NULL,
    price VARCHAR NOT NULL,
    number_of_units INTEGER NOT NULL,
    volume_in_bits INTEGER NOT NULL
);