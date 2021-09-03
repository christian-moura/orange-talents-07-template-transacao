package br.com.zup.transacoes.kafka;

import br.com.zup.transacoes.kafka.componentes.GsonDeserializer;
import org.apache.kafka.clients.consumer.ConsumerConfig;
import org.apache.kafka.clients.consumer.KafkaConsumer;
import org.apache.kafka.common.serialization.StringDeserializer;

import java.io.Closeable;
import java.time.Duration;
import java.util.Collections;
import java.util.Properties;
import java.util.UUID;

public class KafkaConsumerService<T> implements Closeable {

    private final KafkaConsumer<String, T> consumer;
    private final ConsumerFunction parse;


    public KafkaConsumerService(String groupId , String topico, ConsumerFunction parse,  Class<T> typeClass) {
        this.parse = parse;
        this.consumer = new KafkaConsumer<>(properties(typeClass, groupId));
        consumer.subscribe(Collections.singletonList(topico));
    }

    public void run(){
        while(true){
            var records = consumer.poll(Duration.ofMillis(100));
            if(!records.isEmpty()){
                System.out.println("Foram encontrados "+ records.count()+ " registros");
                for(var record : records){
                    parse.service(record);
                }
            }
        }
    }

    private Properties properties(Class<T> typeClass, String groupId) {
        var properties = new Properties();
        properties.setProperty(ConsumerConfig.BOOTSTRAP_SERVERS_CONFIG, "127.0.0.1:9092");
        properties.setProperty(ConsumerConfig.KEY_DESERIALIZER_CLASS_CONFIG, StringDeserializer.class.getName());
        properties.setProperty(ConsumerConfig.VALUE_DESERIALIZER_CLASS_CONFIG, GsonDeserializer.class.getName());
        properties.setProperty(ConsumerConfig.GROUP_ID_CONFIG, groupId);
        properties.setProperty(ConsumerConfig.CLIENT_ID_CONFIG, UUID.randomUUID().toString());
        properties.setProperty(GsonDeserializer.TYPE_CLASS_CONFIG, typeClass.getName());
        return properties;
    }

    @Override
    public void close() {
        consumer.close();
    }
}
