package br.com.zup.transacoes.transacao;

import br.com.zup.transacoes.transacao.estabelecimento.Estabelecimento;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.math.BigDecimal;
import java.time.LocalDateTime;

public class TransacaoResponse {

    @JsonProperty
    private String id;
    @JsonProperty
    private BigDecimal valor;
    @JsonProperty
    private LocalDateTime efetivadaEm;
    @JsonProperty
    private Estabelecimento estabelecimento;

    public TransacaoResponse(Transacao transacao) {
        this.id = transacao.getId();
        this.valor = transacao.getValor();
        this.efetivadaEm = transacao.getEfetivadaEm();
        this.estabelecimento = transacao.getEstabelecimento();
    }
}
