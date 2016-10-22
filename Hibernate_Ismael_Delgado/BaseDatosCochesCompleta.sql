--------------------------------------------------------
-- Archivo creado  - lunes-abril-11-2016   
--------------------------------------------------------
--------------------------------------------------------
--  DDL for Table CLIENTES
--------------------------------------------------------

  CREATE TABLE "LYNCHANIANO"."CLIENTES" 
   (	"DNI" CHAR(15 BYTE), 
	"NOMBRE" VARCHAR2(20 BYTE), 
	"APELLIDO" VARCHAR2(12 BYTE), 
	"CIUDAD" VARCHAR2(12 BYTE)
   )
--------------------------------------------------------
--  DDL for Table COCHES
--------------------------------------------------------

  CREATE TABLE "LYNCHANIANO"."COCHES" 
   (	"CODCOCHE" CHAR(3 BYTE), 
	"NOMBRE" VARCHAR2(15 BYTE), 
	"MODELO" VARCHAR2(10 BYTE)
   )
--------------------------------------------------------
--  DDL for Table CONCESIONARIOS
--------------------------------------------------------

  CREATE TABLE "LYNCHANIANO"."CONCESIONARIOS" 
   (	"CIFC" CHAR(4 BYTE), 
	"NOMBRE" VARCHAR2(15 BYTE), 
	"CIUDAD" VARCHAR2(15 BYTE)
   )
--------------------------------------------------------
--  DDL for Table DISTRIBUCION
--------------------------------------------------------

  CREATE TABLE "LYNCHANIANO"."DISTRIBUCION" 
   (	"CIFC" CHAR(4 BYTE), 
	"CODCOCHE" CHAR(3 BYTE), 
	"CANTIDAD" NUMBER(3,0)
   )
--------------------------------------------------------
--  DDL for Table MARCAS
--------------------------------------------------------

  CREATE TABLE "LYNCHANIANO"."MARCAS" 
   (	"CIFM" CHAR(4 BYTE), 
	"NOMBRE" VARCHAR2(15 BYTE), 
	"CIUDAD" VARCHAR2(15 BYTE)
   )
--------------------------------------------------------
--  DDL for Table MARCO
--------------------------------------------------------

  CREATE TABLE "LYNCHANIANO"."MARCO" 
   (	"CIFM" CHAR(4 BYTE), 
	"CODCOCHE" CHAR(3 BYTE)
   )
--------------------------------------------------------
--  DDL for Table VENTAS
--------------------------------------------------------

  CREATE TABLE "LYNCHANIANO"."VENTAS" 
   (	"CIFC" CHAR(4 BYTE), 
	"DNI" CHAR(15 BYTE), 
	"CODCOCHE" CHAR(3 BYTE), 
	"COLOR" VARCHAR2(10 BYTE)
   )
--------------------------------------------------------
--  DDL for View STOCKS
--------------------------------------------------------

  CREATE OR REPLACE FORCE VIEW "LYNCHANIANO"."STOCKS" ("ID_COCESIONARIO", "NOMBRE_CONCESIONARIO", "CODCOCHE", "NOMBRE_COCHE", "STOCK") AS 
  select con.CIFC ID_COCESIONARIO,
con.NOMBRE NOMBRE_CONCESIONARIO,
coch.CODCOCHE,coch.NOMBRE NOMBRE_COCHE,
dist.CANTIDAD STOCK
from CONCESIONARIOS con,COCHES coch,DISTRIBUCION dist
where dist.CODCOCHE = coch.CODCOCHE and dist.CIFC = con.CIFC
REM INSERTING into LYNCHANIANO.CLIENTES
SET DEFINE OFF;
Insert into LYNCHANIANO.CLIENTES (DNI,NOMBRE,APELLIDO,CIUDAD) values ('0001           ','LUIS','GARCÍA','MADRID');
Insert into LYNCHANIANO.CLIENTES (DNI,NOMBRE,APELLIDO,CIUDAD) values ('0002           ','ANTONIO','LOPEZ','VALENCIA');
Insert into LYNCHANIANO.CLIENTES (DNI,NOMBRE,APELLIDO,CIUDAD) values ('0003           ','JUAN','MARTÍN','MADRID');
Insert into LYNCHANIANO.CLIENTES (DNI,NOMBRE,APELLIDO,CIUDAD) values ('0004           ','MARÍA','GARCÍA','MADRID');
Insert into LYNCHANIANO.CLIENTES (DNI,NOMBRE,APELLIDO,CIUDAD) values ('0005           ','JAVIER','GONZÁLEZ','BARCELONA');
Insert into LYNCHANIANO.CLIENTES (DNI,NOMBRE,APELLIDO,CIUDAD) values ('0006           ','ANA','LÓPEZ','BARCELONA');
REM INSERTING into LYNCHANIANO.COCHES
SET DEFINE OFF;
Insert into LYNCHANIANO.COCHES (CODCOCHE,NOMBRE,MODELO) values ('001','IBIZA','GLXC');
Insert into LYNCHANIANO.COCHES (CODCOCHE,NOMBRE,MODELO) values ('002','IBIZA','GTI');
Insert into LYNCHANIANO.COCHES (CODCOCHE,NOMBRE,MODELO) values ('003','IBIZA','GTDXT');
Insert into LYNCHANIANO.COCHES (CODCOCHE,NOMBRE,MODELO) values ('004','TOLEDO','GTD');
Insert into LYNCHANIANO.COCHES (CODCOCHE,NOMBRE,MODELO) values ('005','CORDOBA','GTI');
Insert into LYNCHANIANO.COCHES (CODCOCHE,NOMBRE,MODELO) values ('006','MEGANEX','1.6.1');
Insert into LYNCHANIANO.COCHES (CODCOCHE,NOMBRE,MODELO) values ('007','MEGANE','GTI');
Insert into LYNCHANIANO.COCHES (CODCOCHE,NOMBRE,MODELO) values ('008','LAGUNA','GTD');
Insert into LYNCHANIANO.COCHES (CODCOCHE,NOMBRE,MODELO) values ('009','LAGUNA','TD');
Insert into LYNCHANIANO.COCHES (CODCOCHE,NOMBRE,MODELO) values ('010','ZX','16V');
Insert into LYNCHANIANO.COCHES (CODCOCHE,NOMBRE,MODELO) values ('011','ZX','TD');
Insert into LYNCHANIANO.COCHES (CODCOCHE,NOMBRE,MODELO) values ('012','XANTIA','GTD');
Insert into LYNCHANIANO.COCHES (CODCOCHE,NOMBRE,MODELO) values ('013','A4','1.8');
Insert into LYNCHANIANO.COCHES (CODCOCHE,NOMBRE,MODELO) values ('014','A4','2.8');
Insert into LYNCHANIANO.COCHES (CODCOCHE,NOMBRE,MODELO) values ('015','ASTRA','CARAVAN');
Insert into LYNCHANIANO.COCHES (CODCOCHE,NOMBRE,MODELO) values ('016','ASTRA','GTI');
Insert into LYNCHANIANO.COCHES (CODCOCHE,NOMBRE,MODELO) values ('017','CORSA','1.4');
Insert into LYNCHANIANO.COCHES (CODCOCHE,NOMBRE,MODELO) values ('018','300','316.i');
Insert into LYNCHANIANO.COCHES (CODCOCHE,NOMBRE,MODELO) values ('019','500','525.i');
Insert into LYNCHANIANO.COCHES (CODCOCHE,NOMBRE,MODELO) values ('021','PRUEBADOS','CWDW');
Insert into LYNCHANIANO.COCHES (CODCOCHE,NOMBRE,MODELO) values ('024','TESTARROSA','T1');
Insert into LYNCHANIANO.COCHES (CODCOCHE,NOMBRE,MODELO) values ('023','DACIA','DUSTER');
REM INSERTING into LYNCHANIANO.CONCESIONARIOS
SET DEFINE OFF;
Insert into LYNCHANIANO.CONCESIONARIOS (CIFC,NOMBRE,CIUDAD) values ('0001','ACAR','MADRID');
Insert into LYNCHANIANO.CONCESIONARIOS (CIFC,NOMBRE,CIUDAD) values ('0002','BCAR','MADRID');
Insert into LYNCHANIANO.CONCESIONARIOS (CIFC,NOMBRE,CIUDAD) values ('0003','CCAR','BARCELONA');
Insert into LYNCHANIANO.CONCESIONARIOS (CIFC,NOMBRE,CIUDAD) values ('0004','DCAR','VALENCIA');
Insert into LYNCHANIANO.CONCESIONARIOS (CIFC,NOMBRE,CIUDAD) values ('0005','ECAR','BILBAO');
REM INSERTING into LYNCHANIANO.DISTRIBUCION
SET DEFINE OFF;
Insert into LYNCHANIANO.DISTRIBUCION (CIFC,CODCOCHE,CANTIDAD) values ('0001','005','3');
Insert into LYNCHANIANO.DISTRIBUCION (CIFC,CODCOCHE,CANTIDAD) values ('0002','001','1');
Insert into LYNCHANIANO.DISTRIBUCION (CIFC,CODCOCHE,CANTIDAD) values ('0001','001','3');
Insert into LYNCHANIANO.DISTRIBUCION (CIFC,CODCOCHE,CANTIDAD) values ('0002','008','10');
Insert into LYNCHANIANO.DISTRIBUCION (CIFC,CODCOCHE,CANTIDAD) values ('0002','009','10');
Insert into LYNCHANIANO.DISTRIBUCION (CIFC,CODCOCHE,CANTIDAD) values ('0004','013','10');
Insert into LYNCHANIANO.DISTRIBUCION (CIFC,CODCOCHE,CANTIDAD) values ('0003','011','3');
Insert into LYNCHANIANO.DISTRIBUCION (CIFC,CODCOCHE,CANTIDAD) values ('0003','012','5');
Insert into LYNCHANIANO.DISTRIBUCION (CIFC,CODCOCHE,CANTIDAD) values ('0004','014','5');
Insert into LYNCHANIANO.DISTRIBUCION (CIFC,CODCOCHE,CANTIDAD) values ('0005','015','10');
Insert into LYNCHANIANO.DISTRIBUCION (CIFC,CODCOCHE,CANTIDAD) values ('0005','016','20');
Insert into LYNCHANIANO.DISTRIBUCION (CIFC,CODCOCHE,CANTIDAD) values ('0005','017','8');
Insert into LYNCHANIANO.DISTRIBUCION (CIFC,CODCOCHE,CANTIDAD) values ('0005','019','3');
Insert into LYNCHANIANO.DISTRIBUCION (CIFC,CODCOCHE,CANTIDAD) values ('0004','005','1');
Insert into LYNCHANIANO.DISTRIBUCION (CIFC,CODCOCHE,CANTIDAD) values ('0003','008','2');
Insert into LYNCHANIANO.DISTRIBUCION (CIFC,CODCOCHE,CANTIDAD) values ('0005','008','34');
Insert into LYNCHANIANO.DISTRIBUCION (CIFC,CODCOCHE,CANTIDAD) values ('0004','021','12');
Insert into LYNCHANIANO.DISTRIBUCION (CIFC,CODCOCHE,CANTIDAD) values ('0001','006','5');
Insert into LYNCHANIANO.DISTRIBUCION (CIFC,CODCOCHE,CANTIDAD) values ('0001','002','12');
Insert into LYNCHANIANO.DISTRIBUCION (CIFC,CODCOCHE,CANTIDAD) values ('0001','004','4');
REM INSERTING into LYNCHANIANO.MARCAS
SET DEFINE OFF;
Insert into LYNCHANIANO.MARCAS (CIFM,NOMBRE,CIUDAD) values ('0001','SEAT','MADRID');
Insert into LYNCHANIANO.MARCAS (CIFM,NOMBRE,CIUDAD) values ('0002','RENAULT','BARCELONA');
Insert into LYNCHANIANO.MARCAS (CIFM,NOMBRE,CIUDAD) values ('0003','CITROEN','VALENCIA');
Insert into LYNCHANIANO.MARCAS (CIFM,NOMBRE,CIUDAD) values ('0004','AUDI','MADRID');
Insert into LYNCHANIANO.MARCAS (CIFM,NOMBRE,CIUDAD) values ('0005','OPEL','BILBAO');
Insert into LYNCHANIANO.MARCAS (CIFM,NOMBRE,CIUDAD) values ('0006','BMW','BARCELONA');
REM INSERTING into LYNCHANIANO.MARCO
SET DEFINE OFF;
Insert into LYNCHANIANO.MARCO (CIFM,CODCOCHE) values ('0001','001');
Insert into LYNCHANIANO.MARCO (CIFM,CODCOCHE) values ('0001','002');
Insert into LYNCHANIANO.MARCO (CIFM,CODCOCHE) values ('0001','003');
Insert into LYNCHANIANO.MARCO (CIFM,CODCOCHE) values ('0001','004');
Insert into LYNCHANIANO.MARCO (CIFM,CODCOCHE) values ('0001','005');
Insert into LYNCHANIANO.MARCO (CIFM,CODCOCHE) values ('0002','006');
Insert into LYNCHANIANO.MARCO (CIFM,CODCOCHE) values ('0002','007');
Insert into LYNCHANIANO.MARCO (CIFM,CODCOCHE) values ('0002','008');
Insert into LYNCHANIANO.MARCO (CIFM,CODCOCHE) values ('0002','009');
Insert into LYNCHANIANO.MARCO (CIFM,CODCOCHE) values ('0003','010');
Insert into LYNCHANIANO.MARCO (CIFM,CODCOCHE) values ('0003','011');
Insert into LYNCHANIANO.MARCO (CIFM,CODCOCHE) values ('0003','012');
Insert into LYNCHANIANO.MARCO (CIFM,CODCOCHE) values ('0004','013');
Insert into LYNCHANIANO.MARCO (CIFM,CODCOCHE) values ('0004','014');
Insert into LYNCHANIANO.MARCO (CIFM,CODCOCHE) values ('0005','015');
Insert into LYNCHANIANO.MARCO (CIFM,CODCOCHE) values ('0005','016');
Insert into LYNCHANIANO.MARCO (CIFM,CODCOCHE) values ('0005','017');
Insert into LYNCHANIANO.MARCO (CIFM,CODCOCHE) values ('0005','018');
Insert into LYNCHANIANO.MARCO (CIFM,CODCOCHE) values ('0005','019');
REM INSERTING into LYNCHANIANO.VENTAS
SET DEFINE OFF;
Insert into LYNCHANIANO.VENTAS (CIFC,DNI,CODCOCHE,COLOR) values ('0001','0001           ','001','BLANCO');
Insert into LYNCHANIANO.VENTAS (CIFC,DNI,CODCOCHE,COLOR) values ('0001','0002           ','005','ROJO');
Insert into LYNCHANIANO.VENTAS (CIFC,DNI,CODCOCHE,COLOR) values ('0002','0003           ','008','BLANCO');
Insert into LYNCHANIANO.VENTAS (CIFC,DNI,CODCOCHE,COLOR) values ('0002','0001           ','006','ROJO');
Insert into LYNCHANIANO.VENTAS (CIFC,DNI,CODCOCHE,COLOR) values ('0003','0004           ','011','ROJO');
Insert into LYNCHANIANO.VENTAS (CIFC,DNI,CODCOCHE,COLOR) values ('0004','0005           ','014','VERDE');
--------------------------------------------------------
--  DDL for Index MARCO_CIFM_CODCOCHE_PK
--------------------------------------------------------

  CREATE UNIQUE INDEX "LYNCHANIANO"."MARCO_CIFM_CODCOCHE_PK" ON "LYNCHANIANO"."MARCO" ("CIFM", "CODCOCHE")
--------------------------------------------------------
--  DDL for Index VENTAS_CIFC_DNI_CODCOCHE_PK
--------------------------------------------------------

  CREATE UNIQUE INDEX "LYNCHANIANO"."VENTAS_CIFC_DNI_CODCOCHE_PK" ON "LYNCHANIANO"."VENTAS" ("CIFC", "DNI", "CODCOCHE")
--------------------------------------------------------
--  DDL for Index MARCAS_CIFM_PK
--------------------------------------------------------

  CREATE UNIQUE INDEX "LYNCHANIANO"."MARCAS_CIFM_PK" ON "LYNCHANIANO"."MARCAS" ("CIFM")
--------------------------------------------------------
--  DDL for Index COCHES_COD_COCHE_PK
--------------------------------------------------------

  CREATE UNIQUE INDEX "LYNCHANIANO"."COCHES_COD_COCHE_PK" ON "LYNCHANIANO"."COCHES" ("CODCOCHE")
--------------------------------------------------------
--  DDL for Index CLIENTES_DNI_PK
--------------------------------------------------------

  CREATE UNIQUE INDEX "LYNCHANIANO"."CLIENTES_DNI_PK" ON "LYNCHANIANO"."CLIENTES" ("DNI")
--------------------------------------------------------
--  DDL for Index CONCESIONARIO_CIFC_PK
--------------------------------------------------------

  CREATE UNIQUE INDEX "LYNCHANIANO"."CONCESIONARIO_CIFC_PK" ON "LYNCHANIANO"."CONCESIONARIOS" ("CIFC")
--------------------------------------------------------
--  DDL for Index DISTRIBUCION_CIF_COD_PK
--------------------------------------------------------

  CREATE UNIQUE INDEX "LYNCHANIANO"."DISTRIBUCION_CIF_COD_PK" ON "LYNCHANIANO"."DISTRIBUCION" ("CIFC", "CODCOCHE")
--------------------------------------------------------
--  Constraints for Table COCHES
--------------------------------------------------------

  ALTER TABLE "LYNCHANIANO"."COCHES" ADD CONSTRAINT "COCHES_COD_COCHE_PK" PRIMARY KEY ("CODCOCHE") ENABLE
 
  ALTER TABLE "LYNCHANIANO"."COCHES" MODIFY ("CODCOCHE" NOT NULL ENABLE)
--------------------------------------------------------
--  Constraints for Table VENTAS
--------------------------------------------------------

  ALTER TABLE "LYNCHANIANO"."VENTAS" MODIFY ("CIFC" NOT NULL ENABLE)
 
  ALTER TABLE "LYNCHANIANO"."VENTAS" MODIFY ("DNI" NOT NULL ENABLE)
 
  ALTER TABLE "LYNCHANIANO"."VENTAS" MODIFY ("CODCOCHE" NOT NULL ENABLE)
 
  ALTER TABLE "LYNCHANIANO"."VENTAS" ADD CONSTRAINT "VENTAS_CIFC_DNI_CODCOCHE_PK" PRIMARY KEY ("CIFC", "DNI", "CODCOCHE") ENABLE
--------------------------------------------------------
--  Constraints for Table CONCESIONARIOS
--------------------------------------------------------

  ALTER TABLE "LYNCHANIANO"."CONCESIONARIOS" ADD CONSTRAINT "CONCESIONARIO_CIFC_PK" PRIMARY KEY ("CIFC") ENABLE
 
  ALTER TABLE "LYNCHANIANO"."CONCESIONARIOS" MODIFY ("CIFC" NOT NULL ENABLE)
--------------------------------------------------------
--  Constraints for Table MARCO
--------------------------------------------------------

  ALTER TABLE "LYNCHANIANO"."MARCO" ADD CONSTRAINT "MARCO_CIFM_CODCOCHE_PK" PRIMARY KEY ("CIFM", "CODCOCHE") ENABLE
 
  ALTER TABLE "LYNCHANIANO"."MARCO" MODIFY ("CIFM" NOT NULL ENABLE)
 
  ALTER TABLE "LYNCHANIANO"."MARCO" MODIFY ("CODCOCHE" NOT NULL ENABLE)
--------------------------------------------------------
--  Constraints for Table CLIENTES
--------------------------------------------------------

  ALTER TABLE "LYNCHANIANO"."CLIENTES" ADD CONSTRAINT "CLIENTES_DNI_PK" PRIMARY KEY ("DNI") ENABLE
 
  ALTER TABLE "LYNCHANIANO"."CLIENTES" MODIFY ("DNI" NOT NULL ENABLE)
--------------------------------------------------------
--  Constraints for Table MARCAS
--------------------------------------------------------

  ALTER TABLE "LYNCHANIANO"."MARCAS" ADD CONSTRAINT "MARCAS_CIFM_PK" PRIMARY KEY ("CIFM") ENABLE
 
  ALTER TABLE "LYNCHANIANO"."MARCAS" MODIFY ("CIFM" NOT NULL ENABLE)
--------------------------------------------------------
--  Constraints for Table DISTRIBUCION
--------------------------------------------------------

  ALTER TABLE "LYNCHANIANO"."DISTRIBUCION" ADD CONSTRAINT "DISTRIBUCION_CIF_COD_PK" PRIMARY KEY ("CIFC", "CODCOCHE") ENABLE
 
  ALTER TABLE "LYNCHANIANO"."DISTRIBUCION" MODIFY ("CIFC" NOT NULL ENABLE)
 
  ALTER TABLE "LYNCHANIANO"."DISTRIBUCION" MODIFY ("CODCOCHE" NOT NULL ENABLE)
--------------------------------------------------------
--  Ref Constraints for Table DISTRIBUCION
--------------------------------------------------------

  ALTER TABLE "LYNCHANIANO"."DISTRIBUCION" ADD CONSTRAINT "DISTRIBUCION_CIFC_FK" FOREIGN KEY ("CIFC")
	  REFERENCES "LYNCHANIANO"."CONCESIONARIOS" ("CIFC") ENABLE
 
  ALTER TABLE "LYNCHANIANO"."DISTRIBUCION" ADD CONSTRAINT "DISTRIBUCION_CODCOCHE_FK" FOREIGN KEY ("CODCOCHE")
	  REFERENCES "LYNCHANIANO"."COCHES" ("CODCOCHE") ENABLE
--------------------------------------------------------
--  Ref Constraints for Table MARCO
--------------------------------------------------------

  ALTER TABLE "LYNCHANIANO"."MARCO" ADD CONSTRAINT "MARCO_CIFM_FK" FOREIGN KEY ("CIFM")
	  REFERENCES "LYNCHANIANO"."MARCAS" ("CIFM") ENABLE
 
  ALTER TABLE "LYNCHANIANO"."MARCO" ADD CONSTRAINT "MARCO_CODCOCHE_FK" FOREIGN KEY ("CODCOCHE")
	  REFERENCES "LYNCHANIANO"."COCHES" ("CODCOCHE") ENABLE
--------------------------------------------------------
--  Ref Constraints for Table VENTAS
--------------------------------------------------------

  ALTER TABLE "LYNCHANIANO"."VENTAS" ADD CONSTRAINT "VENTAS_CIFC_FK" FOREIGN KEY ("CIFC")
	  REFERENCES "LYNCHANIANO"."CONCESIONARIOS" ("CIFC") ENABLE
 
  ALTER TABLE "LYNCHANIANO"."VENTAS" ADD CONSTRAINT "VENTAS_CODCOCHE_FK" FOREIGN KEY ("CODCOCHE")
	  REFERENCES "LYNCHANIANO"."COCHES" ("CODCOCHE") ENABLE
 
  ALTER TABLE "LYNCHANIANO"."VENTAS" ADD CONSTRAINT "VENTAS_DNI_FK" FOREIGN KEY ("DNI")
	  REFERENCES "LYNCHANIANO"."CLIENTES" ("DNI") ENABLE
--------------------------------------------------------
--  DDL for Trigger TRIGGERSTOCKS
--------------------------------------------------------

  CREATE OR REPLACE TRIGGER "LYNCHANIANO"."TRIGGERSTOCKS" 
INSTEAD OF INSERT OR DELETE OR UPDATE ON STOCKS 
declare
 
BEGIN
 
  if inserting then
   insert into DISTRIBUCION (CIFC,CODCOCHE,CANTIDAD)
   values (:new.ID_COCESIONARIO,:new.CODCOCHE,:new.STOCK);
   
   
  elsif deleting then
  
    delete from DISTRIBUCION
    where CODCOCHE=:old.CODCOCHE and CIFC =:old.ID_COCESIONARIO;
   
  else
  
    update DISTRIBUCION
    
    set CANTIDAD=:new.stock
    where CODCOCHE=:new.CODCOCHE and CIFC =:new.ID_COCESIONARIO;
    
   end if;
END;
ALTER TRIGGER "LYNCHANIANO"."TRIGGERSTOCKS" ENABLE
