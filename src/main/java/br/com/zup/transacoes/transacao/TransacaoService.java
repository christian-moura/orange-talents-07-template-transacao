package br.com.zup.transacoes.transacao;

import br.com.zup.transacoes.kafka.KafkaConsumerService;
import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TransacaoService{

    private TransacaoRepository transacaoRepository;
    private KafkaConsumerService kafkaConsumerService;

    @Autowired
    public TransacaoService(TransacaoRepository transacaoRepository) {
        this.transacaoRepository = transacaoRepository;
        this.kafkaConsumerService = new KafkaConsumerService(TransacaoService.class.getSimpleName(),
                "transacoes", this::service, TransacaoRequest.class);
           kafkaConsumerService.run();
    }
    private void service(ConsumerRecord<String, TransacaoRequest> record){
        transacaoRepository.save(record.value().toTransacao());
    }
}
