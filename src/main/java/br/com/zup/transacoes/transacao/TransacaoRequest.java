package br.com.zup.transacoes.transacao;

import br.com.zup.transacoes.transacao.cartao.CartaoRequest;
import br.com.zup.transacoes.transacao.estabelecimento.EstabelecimentoRequest;

import java.math.BigDecimal;
import java.time.LocalDateTime;

public class TransacaoRequest {

    private String id;
    private BigDecimal valor;
    private String efetivadaEm;
    private EstabelecimentoRequest estabelecimento;
    private CartaoRequest cartao;

    public TransacaoRequest(String id, BigDecimal valor, String efetivadaEm, EstabelecimentoRequest estabelecimento, CartaoRequest cartao) {
        this.id = id;
        this.valor = valor;
        this.efetivadaEm = efetivadaEm;
        this.estabelecimento = estabelecimento;
        this.cartao = cartao;
    }

    public Transacao toTransacao(){
        return new Transacao(this.id,this.valor,LocalDateTime.parse(this.efetivadaEm),this.estabelecimento.toEsbalecimento(),this.cartao.toCartao());
    }
}
