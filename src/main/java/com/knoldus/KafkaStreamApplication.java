package com.knoldus;

import java.util.Collections;
import java.util.Map;
import java.util.Properties;
import java.util.logging.Logger;

import demo.Location;
import io.confluent.kafka.schemaregistry.client.CachedSchemaRegistryClient;
import io.confluent.kafka.schemaregistry.client.CachedSchemaRegistryClient;
import io.confluent.kafka.serializers.AbstractKafkaAvroSerDeConfig;
import io.confluent.kafka.serializers.KafkaAvroDeserializerConfig;
import io.confluent.kafka.streams.serdes.avro.SpecificAvroSerde;
import org.apache.avro.generic.GenericRecord;
import org.apache.avro.specific.SpecificRecord;
import org.apache.kafka.common.serialization.Serde;
import org.apache.kafka.common.serialization.Serdes;
import org.apache.kafka.streams.KafkaStreams;
import org.apache.kafka.streams.KeyValue;
import org.apache.kafka.streams.StreamsConfig;
import org.apache.kafka.streams.kstream.KStream;
import org.apache.kafka.streams.kstream.KStreamBuilder;
import org.apache.kafka.streams.kstream.ValueMapper;
import io.confluent.kafka.streams.serdes.avro.GenericAvroSerde;

import static sun.plugin.javascript.navig.JSType.Location;

public class KafkaStreamApplication {

    Logger logger = Logger.getLogger("log");

    Properties getStreamConfiguration() {

        Properties properties = new Properties();
        properties.put(StreamsConfig.APPLICATION_ID_CONFIG, "kafka-streaming-test");
        properties.put(StreamsConfig.BOOTSTRAP_SERVERS_CONFIG, "localhost:9092");
        //     properties.put(StreamsConfig.DEFAULT_KEY_SERDE_CLASS_CONFIG, Serdes.String().getClass().getName());
//        properties.put(StreamsConfig.DEFAULT_VALUE_SERDE_CLASS_CONFIG, SpecificAvroSerde.class);
        //properties.put(StreamsConfig.DEFAULT_VALUE_SERDE_CLASS_CONFIG, GenericAvroSerde.class);
        properties.put(KafkaAvroDeserializerConfig.SPECIFIC_AVRO_READER_CONFIG, true);
        //  properties.put(AbstractKafkaAvroSerDeConfig.SCHEMA_REGISTRY_URL_CONFIG, "http://localhost:8081");
        return properties;
    }

    void transform() {

        Properties streamConfiguration = getStreamConfiguration();
        KStreamBuilder builder = new KStreamBuilder();

        final Map<String, String> serdeConfig = Collections.singletonMap("schema.registry.url",
                "http://localhost:8081");

        /*  final Map<String, String>
                serdeProps =
                Collections.singletonMap("schema.registry.url", "http://localhost:8081");*/

        final CachedSchemaRegistryClient
                schemaRegistry =
                new CachedSchemaRegistryClient("http://localhost:8081", 100);

        final Serde<Location> valueSpecificAvroSerde = new SpecificAvroSerde<>();
        valueSpecificAvroSerde.configure(serdeConfig, false);

        //current  //  KStream<String, Location> kStream = builder.stream(null, valueSpecificAvroSerde, "orders-topic");
        KStream<String, GenericRecord> kStream = builder.stream(null, new MyAvroSerde(schemaRegistry, serdeConfig), "orders-topic");
        //     builder.stream(null, new GenericAvroSerde(schemaRegistry), "");

        // KStream<Long, SpecificRecord> kStream = builder.stream( "orders-topic");

        KStream<String, Location> newStream = kStream.map((k, v) -> new KeyValue<String, Location>(k,
                new Location((String) v.get("created"), (String) v.get("id") + " knoldus")));


        //  newStream.to(null,valueSpecificAvroSerde,"outtopic-3");
        newStream.to("outtopic-3");
        KafkaStreams stream = new KafkaStreams(builder, streamConfiguration);
        stream.start();
    }

    public static void main(String[] args) {
        new KafkaStreamApplication().transform();
    }

}
