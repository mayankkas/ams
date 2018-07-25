# ams-server-example
=======
# ams-application-spring-boot-gradle

Build application command - gradle build
jar at location: \build\libs

>>Cassandra

CREATE KEYSPACE amskeyspace WITH REPLICATION = { 'class' : 'SimpleStrategy', 'replication_factor' : 1 };

CREATE TABLE amskeyspace.customer (id TimeUUID PRIMARY KEY, firstname text, lastname text);
CREATE INDEX customerfistnameindex ON amskeyspace.customer (firstname);
CREATE INDEX customersecondnameindex ON amskeyspace.customer (lastname);

DROP TABLE amskeyspace.customer;

