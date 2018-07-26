# ams-server-example
=======
# ams-application-spring-boot-gradle

>>pre requisite 

Java 8

Gradle 4.9

Cassandra 3.11.2

Python 2.7 


>> Build command

Build application - gradle build

jar at location: \build\libs


>>Cassandra

CREATE KEYSPACE amskeyspace WITH REPLICATION = { 'class' : 'SimpleStrategy', 'replication_factor' : 1 };

CREATE TABLE amskeyspace.employee (eid varint PRIMARY KEY, firstname text, lastname text, emailid text, password text);

CREATE INDEX fistnameindex ON amskeyspace.employee (firstname);

CREATE INDEX lastnameindex ON amskeyspace.employee (lastname);

DROP TABLE amskeyspace.employee;

