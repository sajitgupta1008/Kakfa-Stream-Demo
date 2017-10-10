/*
import com.datastax.driver.core.ResultSet;
import com.datastax.driver.core.Row;
import com.datastax.driver.core.Session;
import com.typesafe.config.ConfigException;
import org.apache.kafka.clients.producer.KafkaProducer;
import org.apache.kafka.clients.producer.ProducerRecord;

import java.util.List;
import java.util.Properties;

public class KafkaJavaProducer implements CassandraProvider {

    Properties props = configureProducer();
    String topic = "test-topic";
    KafkaProducer<ConfigException.Null, String> producer = new KafkaProducer<>(props);

    Session session = getSession();

    private Properties configureProducer() {
        Properties props = new Properties();
        props.put("bootstrap.servers", "localhost:9082");
        props.put("client.id", "ScalaProducerExample");
        props.put("key.serializer", "org.apache.kafka.common.serialization.StringSerializer");
        props.put("value.serializer", "org.apache.kafka.common.serialization.StringSerializer");
        props.put("acks", "all");
        props.put("retries", "0");
        props.put("batch.size", "16384");
        props.put("linger.ms", "1");
        props.put("buffer.memory", "33554432");
        System.out.println("got props");
        return props;
    }

    void getData() throws InterruptedException {

        while (true) {
            session.execute("CREATE TABLE IF NOT EXISTS kafka (id int PRIMARY KEY, username text)");

            ResultSet resultSet = session.execute("SELECT * from kafka;");
            List<Row> list = resultSet.all();
            for (Row row : list) {
                String data = row.getInt(0) + " , " + row.getString(1);
                ProducerRecord<ConfigException.Null, String> record = new ProducerRecord<ConfigException.Null, String>(topic, data);
                producer.send(record);
            }
            System.out.println("sent data");
            Thread.sleep(3000);
        }
    }

    public static void main(String[] args) throws InterruptedException {
        new KafkaJavaProducer().getData();
        System.out.println("done");
    }

}
*/
