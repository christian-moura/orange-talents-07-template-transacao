package br.com.zup.transacoes.transacao;


import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

@Component
public class TransacaoService{

    private TransacaoRepository transacaoRepository;

    public TransacaoService(TransacaoRepository transacaoRepository) {
        this.transacaoRepository = transacaoRepository;
    }

    @KafkaListener(topics = "transacoes")
    public void ouvir(TransacaoRequest transacaoRequest) {
        System.out.println(transacaoRequest);
        transacaoRepository.save(transacaoRequest.toTransacao());
    }
}
