import com.datastax.driver.core.Cluster;
import com.datastax.driver.core.Session;
import com.typesafe.config.Config;
import com.typesafe.config.ConfigFactory;

public interface CassandraProvider {

    Config config = ConfigFactory.load();
    String cassandraKeySpace = config.getString("cassandra.keyspace");
    String cassandraHostName = config.getString("cassandra.contact.points");


    Cluster cluster = new Cluster.Builder().withClusterName("test cluster").addContactPoints(cassandraHostName).build();

    default Session getSession() {

        Session session = cluster.connect();
        session.execute(String.format(
                "CREATE KEYSPACE IF NOT EXISTS  %s WITH REPLICATION = { 'class' : 'SimpleStrategy', 'replication_factor' : 1 }",
                cassandraKeySpace));
        session.execute("USE " + cassandraKeySpace);
        System.out.println("got session");
        return session;
    }

}

