DROP DATABASE IF EXISTS ventas;
CREATE DATABASE ventas;
USE ventas;


CREATE TABLE cliente (
	clienteid int NOT NULL AUTO_INCREMENT,
    dni int NOT NULL,
    nombre varchar(255) NOT NULL,
    apellido varchar(255),
    PRIMARY KEY (clienteid)
);

CREATE TABLE producto (
	productoid int NOT NULL AUTO_INCREMENT,
    codigo int NOT NULL,
    descripcion varchar(255) NOT NULL,
    cantidad int,
    precio FLOAT(5, 2),
    PRIMARY KEY (productoid)
);

CREATE TABLE comprobante (
    comprobanteid int NOT NULL AUTO_INCREMENT,
    fecha datetime,
    cantidad int,
    total FLOAT(5, 2),
    clienteid int,
    PRIMARY KEY (comprobanteid),
    CONSTRAINT FK_cliente FOREIGN KEY (clienteid)
    REFERENCES cliente(clienteid)
);

CREATE TABLE linea (
    lineaid int NOT NULL AUTO_INCREMENT,
    descripcion varchar(255) NOT NULL,
    cantidad int,
    precio FLOAT(5, 2),
    comprobanteid int NOT NULL,
    productoid int NOT NULL,
    PRIMARY KEY (lineaid),
    CONSTRAINT FK_comprobante FOREIGN KEY (comprobanteid)
    REFERENCES comprobante(comprobanteid),
    CONSTRAINT FK_producto FOREIGN KEY (productoid)
    REFERENCES producto(productoid)
);
