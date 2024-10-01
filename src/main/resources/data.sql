-- USE universidad_db;

INSERT INTO direccion
    (id, calle, altura, ciudad)
VALUES
    (1, 'Calle Falsa', '123', 'BUENOS_AIRES'),
    (2, 'Avenida Siempre Viva', '742', 'CAPITAL_FEDERAL'),
    (3, 'Ruta Nacional 40', '1000', 'MENDOZA'),
    (4, 'Boulevard San Martín', '456', 'CORDOBA'),
    (5, 'Camino del Viento', '789', 'RIO_NEGRO');

INSERT INTO universidad
    (id, nombre, telefono, web, codigo, direccion, email)
VALUES
    ('u1a2b3c4-5678-90ab-cdef-1234567890ab', 'Universidad de Buenos Aires', '011-1234-5678', 'https://www.uba.ar', 'UBA001', 1, 'contacto@uba.ar'),
    ('u2b3c4d5-6789-0abc-def1-234567890bcd', 'Universidad Nacional de Cuyo', '0261-123-4567', 'https://www.uncu.edu.ar', 'UNCU002', 2, 'info@uncu.edu.ar'),
    ('u3c4d5e6-7890-1bcd-ef12-34567890cdef', 'Universidad Tecnológica Nacional', '0351-765-4321', 'https://www.utn.edu.ar', 'UTN003', 3, 'soporte@utn.edu.ar'),
    ('u4d5e6f7-8901-2cde-f123-4567890def01', 'Universidad Nacional de La Plata', '0221-987-6543', 'https://www.unlp.edu.ar', 'UNLP004', 4, 'admisiones@unlp.edu.ar'),
    ('u5e6f7g8-9012-3def-0123-567890ef0123', 'Universidad Nacional de Río Negro', '02920-555-666', 'https://www.unrn.edu.ar', 'UNRN005', 5, 'contacto@unrn.edu.ar');