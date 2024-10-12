
CREATE TABLE IF NOT EXISTS autor (
    idautor INT  PRIMARY key AUTO_INCREMENT,
    nombre VARCHAR(100) NOT NULL,
    apellido VARCHAR(100) NOT NULL,
    biografia TEXT
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;


CREATE TABLE IF NOT EXISTS libro (
    idlibro INT  PRIMARY key AUTO_INCREMENT,
    titulo VARCHAR(255) NOT NULL,
    idautor INT,
    genero VARCHAR(100),
    precio DECIMAL(10, 2) NOT NULL,
    stock INT DEFAULT 0,
    FOREIGN KEY (idautor) REFERENCES autor(idautor)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;


CREATE TABLE IF NOT EXISTS cliente (
    idcliente INT  PRIMARY key AUTO_INCREMENT,
    nombre VARCHAR(100) NOT NULL,
    apellido VARCHAR(100) NOT NULL,
    correo VARCHAR(255),
    telefono VARCHAR(20)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;


CREATE TABLE IF NOT EXISTS pedido (
    idpedido INT  PRIMARY key AUTO_INCREMENT,
    idcliente INT,
    fechapedido DATE NOT NULL,
    montototal DECIMAL(10, 2),
    FOREIGN KEY (idcliente) REFERENCES cliente(idcliente)
);


CREATE TABLE IF NOT EXISTS detallepedido (
    iddetallepedido INT  PRIMARY key AUTO_INCREMENT,
    idpedido INT,
    idlibro INT,
    cantidad INT NOT NULL,
    precio DECIMAL(10, 2),
    FOREIGN KEY (idpedido) REFERENCES pedido(idpedido),
    FOREIGN KEY (idlibro) REFERENCES libro(idlibro)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;


CREATE TABLE IF NOT EXISTS usuario (
    idusuario INT PRIMARY key AUTO_INCREMENT,
    codigo VARCHAR(100) NOT NULL,
    email VARCHAR(200) NOT NULL UNIQUE,
    password VARCHAR(300) NOT NULL,
    activo BOOLEAN NOT NULL DEFAULT TRUE
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;


CREATE TABLE IF NOT EXISTS rol (
    idrol INT PRIMARY key AUTO_INCREMENT,
    nomrol VARCHAR(100) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;


INSERT INTO rol (nomrol) VALUES ('COORDINADOR'), ('GESTOR');


INSERT INTO usuario (codigo, email, password, activo) VALUES
('JWT1', 'coordinador@example.com', '$2a$12$ByXLwf9pFuguyPBevuzy4OfL.zo17qoSVcMGWhHJVcJ7r844sFvgi', TRUE),
('JWT2', 'gestor@example.com', '$2a$12$XT0ql.q1KcnHXnoEuOtmOeNdB0yyPRr1iyJ0/JDHTvB9VVPmHUzr2', TRUE);


INSERT INTO usuario_rol (idusuario, idrol) VALUES
(1, 1),
(2, 2);

CREATE TABLE IF NOT EXISTS usuario_rol (
    idusuario INT NOT NULL,
    idrol INT NOT NULL,
    PRIMARY KEY (idusuario, idrol),
    FOREIGN KEY (idusuario) REFERENCES usuario(idusuario),
    FOREIGN KEY (idrol) REFERENCES rol(idrol)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;


INSERT INTO autor (nombre, apellido, biografia) VALUES
('George', 'Orwell', 'Autor de 1984 y Rebelión en la granja'),
('J.K.', 'Rowling', 'Autora de la saga de Harry Potter'),
('Gabriel', 'García Márquez', 'Autor de Cien años de soledad');


INSERT INTO libro (titulo, idautor, genero, precio, stock) VALUES
('1984', 1, 'Distopía', 19.99, 100),
('Harry Potter y la piedra filosofal', 2, 'Fantasía', 24.99, 50),
('Cien años de soledad', 3, 'Realismo mágico', 22.50, 30);


INSERT INTO cliente (nombre, apellido, correo, telefono) VALUES
('Carlos', 'López', 'carlos.lopez@example.com', '555-1234'),
('María', 'González', 'maria.gonzalez@example.com', '555-5678');


INSERT INTO pedido (idcliente, fechapedido, montototal) VALUES
(1, '2024-10-07', 39.98),
(2, '2024-10-07', 24.99);


INSERT INTO detallepedido (idpedido, idlibro, cantidad, precio) VALUES
(1, 1, 2, 19.99),
(2, 2, 1, 24.99);
