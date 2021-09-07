package br.com.zup.transacoes.transacao;


import br.com.zup.transacoes.transacao.cartao.CartaoRequest;
import br.com.zup.transacoes.transacao.estabelecimento.EstabelecimentoRequest;

import java.math.BigDecimal;
import java.time.LocalDateTime;

public class TransacaoRequest {

    private String id;
    private BigDecimal valor;
    private LocalDateTime efetivadaEm;
    private EstabelecimentoRequest estabelecimento;
    private CartaoRequest cartao;

    @Deprecated
    public TransacaoRequest() {
    }

    public TransacaoRequest(String id, BigDecimal valor, LocalDateTime  efetivadaEm, EstabelecimentoRequest estabelecimento, CartaoRequest cartao) {
        this.id = id;
        this.valor = valor;
        this.efetivadaEm = efetivadaEm;
        this.estabelecimento = estabelecimento;
        this.cartao = cartao;
    }

    public String getId() {
        return id;
    }

    public BigDecimal getValor() {
        return valor;
    }

    public LocalDateTime getEfetivadaEm() {
        return efetivadaEm;
    }

    public EstabelecimentoRequest getEstabelecimento() {
        return estabelecimento;
    }

    public CartaoRequest getCartao() {
        return cartao;
    }

    public Transacao toTransacao(){
        return new Transacao(this.id, this.valor, this.efetivadaEm,this.estabelecimento.toEsbalecimento(),this.cartao.toCartao());
    }

    @Override
    public String toString() {
        return "Transacao{" +
                "id='" + id + '\'' +
                ", valor=" + valor +
                ", efetivadaEm=" + efetivadaEm +
                ", estabelecimento=" + estabelecimento +
                ", cartao=" + cartao +
                '}';
    }
}
