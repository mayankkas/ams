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

CREATE TABLE amskeyspace.employee (eid varint PRIMARY KEY, emailid text, role text, password text);

# Add more column in employee table

CREATE TABLE amskeyspace.employee (eid int PRIMARY KEY, emailid text, role text, password text, firstname text, lastname text, phonenumber int, mphmanager text, location text, projectcode int);

CREATE INDEX emailidindex ON amskeyspace.employee (emailid);

CREATE INDEX roleindex ON amskeyspace.employee (role);

DROP TABLE amskeyspace.employee;

