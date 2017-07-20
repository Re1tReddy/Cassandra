

import com.datastax.driver.core.Cluster
import com.datastax.driver.core.querybuilder.QueryBuilder
import com.datastax.driver.core.Row
import org.apache.hadoop.hive.conf.HiveConf
import org.apache.hadoop.hive.metastore.HiveMetaStoreClient
import org.apache.hadoop.hive.metastore.api.Partition
import org.apache.hadoop.hive.metastore.api.StorageDescriptor
object Test extends App {

  val hiveConf = new HiveConf(getClass)
  // hiveConf.set("hive.metastore.local", "true");
  hiveConf.setVar(HiveConf.ConfVars.METASTOREURIS, "thrift://127.0.0.1:9083");
  val hiveClient = new HiveMetaStoreClient(hiveConf);

  println(hiveClient.getAllDatabases().size());

  val cluster = Cluster.builder().addContactPoint("127.0.0.1").build()
  val masterSession = cluster.connect("dev")
  //val tidQuery = masterSession.prepare(s"SELECT empid FROM emp")

  val statement = QueryBuilder.select().all().from("dev", "emp")
  val requestQuery = masterSession.execute(statement);

  val itr = requestQuery.all().iterator()

  while (itr.hasNext()) {

    println(itr.next().getInt("empid"))
  }

}