# Spring-Web-MVC-with-JDBC-Template
#=====================================
Objectives

1) How to integrate Spring(4.3.3) MVC with JDBC Templete  using Maven+ and PosgtreSQL
2) The dependencies which are required to integrate in POM.xml file
3) How to perform CRUD and Search operations on a Spring MVC project with JDBC Templete.
#=====================================
PostgreSQL
DB: CustomerDB
Table: customer

CREATE TABLE customer
(
  customer_id serial NOT NULL,
  firstname character varying(50),
  lastname character varying(50),
  CONSTRAINT customer_pkey PRIMARY KEY (customer_id)
);
