package com.knoldus;

//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by Fernflower decompiler)
//

import java.util.Map;

import io.confluent.kafka.schemaregistry.client.SchemaRegistryClient;

import java.util.Map;

import io.confluent.kafka.serializers.KafkaAvroDeserializer;
import io.confluent.kafka.serializers.KafkaAvroSerializer;
import io.confluent.kafka.streams.serdes.avro.GenericAvroDeserializer;
import io.confluent.kafka.streams.serdes.avro.GenericAvroSerializer;
import org.apache.avro.generic.GenericRecord;
import org.apache.kafka.common.annotation.InterfaceStability.Unstable;
import org.apache.kafka.common.serialization.Deserializer;
import org.apache.kafka.common.serialization.Serde;
import org.apache.kafka.common.serialization.Serdes;
import org.apache.kafka.common.serialization.Serializer;

@Unstable
public class MyAvroSerde implements Serde<GenericRecord> {
    private final Serde<GenericRecord> inner;

    public MyAvroSerde() {
        this.inner = Serdes.serdeFrom(new GenericAvroSerializer(), new GenericAvroDeserializer());
    }

    MyAvroSerde(SchemaRegistryClient client, Map<String, ?> props) {
        if (client == null) {
            throw new IllegalArgumentException("schema registry client must not be null");
        } else {
            this.inner = Serdes.serdeFrom(new MyGenericAvroSerializer(client, props), new MyGenericAvroDeserializer(client, props));
        }
    }

    public Serializer<GenericRecord> serializer() {
        return this.inner.serializer();
    }

    public Deserializer<GenericRecord> deserializer() {
        return this.inner.deserializer();
    }

    public void configure(Map<String, ?> serdeConfig, boolean isSerdeForRecordKeys) {
        this.inner.serializer().configure(serdeConfig, isSerdeForRecordKeys);
        this.inner.deserializer().configure(serdeConfig, isSerdeForRecordKeys);
    }

    public void close() {
        this.inner.serializer().close();
        this.inner.deserializer().close();
    }
}


 class MyGenericAvroSerializer implements Serializer<GenericRecord> {
    private final KafkaAvroSerializer inner;

    public MyGenericAvroSerializer() {
        this.inner = new KafkaAvroSerializer();
    }

    MyGenericAvroSerializer(SchemaRegistryClient client, Map<String, ?> props) {
        this.inner = new KafkaAvroSerializer(client,props);
    }

    public void configure(Map<String, ?> serializerConfig, boolean isSerializerForRecordKeys) {
        this.inner.configure(serializerConfig, isSerializerForRecordKeys);
    }

    public byte[] serialize(String topic, GenericRecord record) {
        return this.inner.serialize(topic, record);
    }

    public void close() {
        this.inner.close();
    }
}

 class MyGenericAvroDeserializer implements Deserializer<GenericRecord> {
    private final KafkaAvroDeserializer inner;

    public MyGenericAvroDeserializer() {
        this.inner = new KafkaAvroDeserializer();
    }

    MyGenericAvroDeserializer(SchemaRegistryClient client, Map<String, ?> props) {
        this.inner = new KafkaAvroDeserializer(client,props);
    }

    public void configure(Map<String, ?> deserializerConfig, boolean isDeserializerForRecordKeys) {
        this.inner.configure(deserializerConfig, isDeserializerForRecordKeys);
    }

    public GenericRecord deserialize(String topic, byte[] bytes) {
        return (GenericRecord)this.inner.deserialize(topic, bytes);
    }

    public void close() {
        this.inner.close();
    }
}
