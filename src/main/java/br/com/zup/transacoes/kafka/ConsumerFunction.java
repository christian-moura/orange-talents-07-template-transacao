package br.com.zup.transacoes.kafka;

import org.apache.kafka.clients.consumer.ConsumerRecord;

public interface ConsumerFunction<T> {
    void service(ConsumerRecord<String,T> record);
}
