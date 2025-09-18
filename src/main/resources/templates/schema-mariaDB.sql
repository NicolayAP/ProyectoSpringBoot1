-- Crear tabla editorial (si no existe)
CREATE TABLE IF NOT EXISTS editorial (
    id INT PRIMARY KEY AUTO_INCREMENT,
    nombre VARCHAR(200) NOT NULL UNIQUE,
    sitio_web VARCHAR(500)
);

-- Crear tabla libro (si no existe)
CREATE TABLE IF NOT EXISTS libro (
    id INT PRIMARY KEY AUTO_INCREMENT,
    nombre VARCHAR(200) NOT NULL UNIQUE,
    descripcion VARCHAR(3000),
    imagen_url VARCHAR(500),
    editorial_id INT,
    CONSTRAINT fk_libro_editorial FOREIGN KEY (editorial_id) REFERENCES editorial(id)
);

-- Insertar editoriales
INSERT INTO editorial (id, nombre, sitio_web) VALUES
(1, 'Planeta', 'https://www.planetadelibros.com/'),
(2, 'Mirahadas', 'https://www.mirahadas.com/'),
(3, 'Pre-Textos', 'https://www.pre-textos.com/'),
(4, 'Sexto Piso', 'https://sextopiso.es/'),
(5, 'Nordica', 'https://www.nordicalibros.com/'),
(6, 'Acantilado', 'https://www.acantilado.es/'),
(7, 'La Huerta Grande', 'https://www.lahuertagrande.com/')
ON DUPLICATE KEY UPDATE nombre = VALUES(nombre), sitio_web = VALUES(sitio_web);

-- Insertar libros (evitando duplicados por nombre)
INSERT INTO libro (nombre, descripcion, imagen_url) VALUES
('Derechos colectivos en Colombia', 'Estudio sobre los derechos colectivos en contexto colombiano.', 'https://simehbucket.s3.amazonaws.com/images/415ebe2115322046c17eea718237faf2-medium.jpg'),
('Transporte de fluidos bombas centrífugas', 'Conceptos y aplicaciones de transporte de fluidos con bombas centrífugas.', 'https://simehbucket.s3.amazonaws.com/images/415ebe2115322046c17eea71821248a5-medium.jpg'),
('Introducción al cálculo de probabilidades para estudiantes de ingeniería', 'Guía fundamental para entender cálculo de probabilidades en ingeniería.', 'https://simehbucket.s3.amazonaws.com/images/415ebe2115322046c17eea718237c3c6-medium.jpg'),
('Resistencias y voces de las mujeres', 'Reflexión sobre las resistencias y expresiones de mujeres en distintos ámbitos.', 'https://simehbucket.s3.amazonaws.com/images/415ebe2115322046c17eea7182381e9f-medium.jpg'),
('Manual de prácticas pedagógicas para la formación de maestros', 'Estrategias y prácticas para mejorar la formación docente.', 'https://simehbucket.s3.amazonaws.com/images/415ebe2115322046c17eea7182387cef-medium.jpg'),
('Maestras rurales, indígenas y afrodescendientes en Colombia', 'Historia y experiencias de mujeres docentes en zonas rurales y étnicas.', 'https://simehbucket.s3.amazonaws.com/images/415ebe2115322046c17eea7182391f42-medium.jpg'),
('Intelecto estética y escuela', 'Ensayos críticos sobre estética e intelectualidad en el ámbito educativo.', 'https://simehbucket.s3.amazonaws.com/images/415ebe2115322046c17eea71823edee5-medium.jpg'),
('Antes de que el recuerdo se desvanezca', 'Narrativa poética que explora la memoria y el olvido.', 'https://simehbucket.s3.amazonaws.com/images/9f47c7330e843372986c97ee1f0ad933-medium.jpg'),
('Derecho y comercio electrónico', 'Análisis legal sobre comercio electrónico y su regulación.', 'https://simehbucket.s3.amazonaws.com/images/63d2d1100b1ef210c5a54b51e71a995a-medium.jpg'),
('Factores que influyen la toma de decisiones en las organizaciones', 'Estudio de los distintos factores que afectan la toma de decisiones organizacionales.', 'https://simehbucket.s3.amazonaws.com/images/afc311736cbd376407f1aa7ca0009c07-medium.jpg')
ON DUPLICATE KEY UPDATE descripcion = VALUES(descripcion), imagen_url = VALUES(imagen_url);


-- Actualizar libros con sus editoriales
UPDATE libro SET editorial_id = 1 WHERE id IN (1, 5);
UPDATE libro SET editorial_id = 2 WHERE id = 2;
UPDATE libro SET editorial_id = 3 WHERE id = 3;
UPDATE libro SET editorial_id = 4 WHERE id = 4;
UPDATE libro SET editorial_id = 5 WHERE id = 6;
UPDATE libro SET editorial_id = 6 WHERE id = 7;
UPDATE libro SET editorial_id = 7 WHERE id = 8;
