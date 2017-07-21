# Cassandra Java and Scala Examples

This repo shows examples using Apache Cassandra and Datastax Java Driver for Apache Cassandra                          
Connecting to Cassandra Using Java and Scala programming languages.                                                           
Connecting to cassandra in a secured way .                                       


Creating Cassandra Keyspace and Table :                             
---------------------------------------                             
create keyspace dev  with replication = {'class':'SimpleStrategy','replication_factor':1};                
 use dev;                           
create table emp (empid int primary key,emp_first varchar, emp_last varchar, emp_dept varchar);                    

insert into emp (empid, emp_first, emp_last, emp_dept) values (1,'rev','kumar','eng');                            
insert into emp (empid, emp_first, emp_last, emp_dept) values (2,'smith','reddy','eng');                                 
insert into emp (empid, emp_first, emp_last, emp_dept) values (3,'shyam','sunder','CA');                                    
