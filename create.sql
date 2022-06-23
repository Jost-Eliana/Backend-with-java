DROP TABLE IF EXISTS odontologos;
CREATE TABLE odontologos (ID INT AUTO_INCREMENT PRIMARY KEY,
NUMERO_DE_MATRICULA INT,
NOMBRE varchar(100),
APELLIDO varchar(100)
);
INSERT INTO odontologos (numeroDeMatricula, nombre, apellido) VALUES ('Eliana', 'Jost', '123456');
INSERT INTO odontologos (numeroDeMatricula, nombre, apellido) VALUES ('Ana', 'Perez', '123458');
INSERT INTO odontologos (numeroDeMatricula, nombre, apellido) VALUES ('Pedro', 'Lopez', '152468');
