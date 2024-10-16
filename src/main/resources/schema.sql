CREATE SCHEMA
IF NOT EXISTS universidad_db;

CREATE TABLE direccion
(
        id BIGINT
        AUTO_INCREMENT PRIMARY KEY,
calle VARCHAR
        (255) NOT NULL,
altura VARCHAR
        (255) NOT NULL,
ciudad VARCHAR
        (50) NOT NULL
);

        CREATE TABLE universidad
        (
                id BIGINT
                AUTO_INCREMENT PRIMARY KEY,
                nombre VARCHAR
                (255) NOT NULL UNIQUE,
                telefono VARCHAR
                (255) NOT NULL UNIQUE,
                web VARCHAR
                (255) NOT NULL UNIQUE,
                codigo VARCHAR
                (255) NOT NULL UNIQUE,
                direccion_id BIGINT,
                email VARCHAR
                (255),
                CONSTRAINT fk_direccion FOREIGN KEY
                (direccion_id) REFERENCES direccion
                (id)

        );


