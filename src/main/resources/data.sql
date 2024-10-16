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
    (nombre, telefono, web, codigo, direccion_id, email)
VALUES
    ('Universidad de Buenos Aires', '011-1234-5678', 'https://www.uba.ar', 'UBA001', 1, 'contacto@uba.ar'),
    ('Universidad Nacional de Cuyo', '0261-123-4567', 'https://www.uncu.edu.ar', 'UNCU002', 2, 'info@uncu.edu.ar'),
    ('Universidad Tecnológica Nacional', '0351-765-4321', 'https://www.utn.edu.ar', 'UTN003', 3, 'soporte@utn.edu.ar'),
    ('Universidad Nacional de La Plata', '0221-987-6543', 'https://www.unlp.edu.ar', 'UNLP004', 4, 'admisiones@unlp.edu.ar'),
    ('Universidad Nacional de Río Negro', '02920-555-666', 'https://www.unrn.edu.ar', 'UNRN005', 5, 'contacto@unrn.edu.ar');