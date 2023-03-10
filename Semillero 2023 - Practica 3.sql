DROP TABLE CLIENTES;
CREATE TABLE CLIENTES(
    DNI_CL NUMBER NOT NULL,
    Nombre_cl VARCHAR2(100),
    Apellido_1 VARCHAR2(100),
    Apellido_2 VARCHAR2(100),
    Clase_via VARCHAR2(100),
    Nombre_via VARCHAR2(100),
    Numero_via NUMBER,
    cod_postal NUMBER,
    Ciudad VARCHAR2(100),
    Telefono VARCHAR2(15),
    Observaciones VARCHAR2(1000),
    
    CONSTRAINT PK_CLIENTES PRIMARY KEY(DNI_CL)
);

CREATE TABLE COMPANIAS(
    nombre_compania VARCHAR2(100) NOT NULL,
    clase_via VARCHAR2(100),
    nombre_via VARCHAR2(100),
    numero_via NUMBER,
    cod_postal NUMBER,
    telefono_contratacion VARCHAR2(15),
    telefono_siniestros VARCHAR2(15),
    notas VARCHAR2(1000),
    
    CONSTRAINT PK_COMPANIAS PRIMARY KEY(nombre_compania)
);


CREATE TABLE PERITOS(
    DNI_perito NUMBER NOT NULL,
    nombre_perito VARCHAR2(100),
    apellido_perito1 VARCHAR2(100),
    apellido_perito2 VARCHAR2(100),
    telefono_contacto VARCHAR2(15),
    telefono_oficina VARCHAR(15),
    Clase_via VARCHAR2(100),
    Nombre_via VARCHAR2(100),
    Numero_via NUMBER,
    cod_postal NUMBER,
    Ciudad VARCHAR2(100),
    
    CONSTRAINT PK_PERITOS PRIMARY KEY(DNI_PERITO)
);

CREATE TABLE SEGUROS(
    numero_poliza NUMBER NOT NULL,
    ramo VARCHAR2(100),
    fecha_inicio DATE,
    fecha_vencimiento DATE,
    condiciones_particulares VARCHAR2(100),
    observaciones VARCHAR2(1000),
    DNI_CL NUMBER NOT NULL,
    
    CONSTRAINT PK_SEGUROS PRIMARY KEY(numero_poliza),
    CONSTRAINT FK_SEGUROS_CLIENTES FOREIGN KEY(DNI_CL) REFERENCES CLIENTES(DNI_CL)
);
commit;
DROP TABLE SINIESTROS;
CREATE TABLE SINIESTROS(
    id_siniestro NUMBER NOT NULL,
    fecha_siniestro DATE,
    causas VARCHAR2(1000),
    aceptado VARCHAR2(1),
    indemnizacion NUMBER(15,2),
    numero_poliza NUMBER NOT NULL,
    DNI_perito NUMBER NOT NULL,
    
    CONSTRAINT PK_SINIESTROS PRIMARY KEY(id_siniestro),
    CONSTRAINT FK_SINIESTROS_SEGUROS FOREIGN KEY(numero_poliza) REFERENCES SEGUROS(numero_poliza),
    CONSTRAINT FK_SINIESTROS_PERITOS FOREIGN KEY(DNI_PERITO) REFERENCES PERITOS(DNI_PERITO)
);

ALTER TABLE SINIESTROS
DROP CONSTRAINT FK_SINIESTROS_SEGUROS;

ALTER TABLE SINIESTROS
ADD CONSTRAINT FK_SINIESTROS_SEGUROS FOREIGN KEY(numero_poliza) REFERENCES SEGUROS(numero_poliza) ON DELETE CASCADE;

CREATE TABLE COMPANIAS_SEGUROS(
    numero_poliza NUMBER NOT NULL,
    nombre_compania VARCHAR2(100),
    id NUMBER NOT NULL,
    
    CONSTRAINT PK_COMPANIAS_SEGUROS PRIMARY KEY(id),
    CONSTRAINT FK_COMP_SEG_COMPANIAS FOREIGN KEY(nombre_compania) REFERENCES COMPANIAS(nombre_compania),
    CONSTRAINT FK_COMP_SEG_SEGUROS FOREIGN KEY(numero_poliza) REFERENCES SEGUROS(numero_poliza)
);

ALTER TABLE COMPANIAS_SEGUROS
DROP CONSTRAINT FK_COMP_SEG_COMPANIAS;

ALTER TABLE COMPANIAS_SEGUROS
ADD CONSTRAINT FK_COMP_SEG_COMPANIAS FOREIGN KEY(nombre_compania) REFERENCES COMPANIAS(nombre_compania) ON DELETE CASCADE;


DROP SEQUENCE SEQ_SEGUROS;
CREATE SEQUENCE SEQ_SEGUROS
START WITH 1
INCREMENT BY 1
NOCACHE
NOCYCLE;

DROP SEQUENCE SEQ_COMP_SEGUROS;
CREATE SEQUENCE SEQ_COMP_SEGUROS
START WITH 1
INCREMENT BY 1
NOCACHE
NOCYCLE;

DROP SEQUENCE SEQ_SINIESTROS;
CREATE SEQUENCE SEQ_SINIESTROS
START WITH 1
INCREMENT BY 1
NOCACHE
NOCYCLE;

SELECT * FROM CLIENTES;
SELECT * FROM SEGUROS;
SELECT * FROM COMPANIAS;
SELECT * FROM COMPANIAS_SEGUROS;
SELECT * FROM PERITOS;
SELECT * FROM SINIESTROS;
commit;

update COMPANIAS set COD_POSTAL = 335 where NOMBRE_COMPANIA LIKE 'Lesch Inc';

DELETE FROM COMPANIAS WHERE COD_POSTAL > 100;