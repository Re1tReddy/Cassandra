CREATE KEYSPACE dev
WITH replication = {
	'class' : 'SimpleStrategy',
	'replication_factor' : 1
};

CREATE TABLE dev.my_table (
  partition_key TEXT,
  some_timestamp TIMESTAMP,
  PRIMARY KEY (partition_key)
);
INSERT INTO dev.my_table (partition_key, some_timestamp) VALUES ('key', '2015-12-26');
