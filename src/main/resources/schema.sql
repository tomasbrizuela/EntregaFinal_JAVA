CREATE SCHEMA
IF NOT EXISTS universidad_db;

CREATE TABLE direccion
(
    id BIGINT NOT NULL
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
        id VARCHAR
(36) NOT NULL PRIMARY KEY,
        nombre VARCHAR
(255) NOT NULL,
        telefono VARCHAR
(255) NOT NULL,
        web VARCHAR
(255) NOT NULL,
        codigo VARCHAR
(255) NOT NULL UNIQUE,
        direccion BIGINT,
        email VARCHAR
(255),
        CONSTRAINT fk_direccion FOREIGN KEY (direccion) REFERENCES direccion(id)

    );


