


CREATE DATABASE Requerimiento;
use Requerimiento;

CREATE TABLE ejemplar(
	id VARCHAR(10) PRIMARY KEY,
	field_l VARCHAR(45) NOT NULL,
    author VARCHAR(45) NOT NULL,
	descripcion VARCHAR(45) NOT NULL,
	my_numeric_field VARCHAR(45) NOT NULL
);

SELECT * from ejemplar;


INSERT INTO ejemplar(id,field_l,author,descripcion,my_numeric_field)
VALUES("10","foo","Bill Gates","bar","123"),
("11","foo","Steve jobs","bar","123");


USE nuevaBaseDatos;
SELECT * FROM persona;

UPDATE persona SET telefono='351674156' WHERE id>40;

DELETE  FROM persona WHERE id=40;

DELETE  FROM persona WHERE nombre="asa";
