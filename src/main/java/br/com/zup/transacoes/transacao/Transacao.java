package br.com.zup.transacoes.transacao;

import br.com.zup.transacoes.transacao.cartao.Cartao;
import br.com.zup.transacoes.transacao.estabelecimento.Estabelecimento;

import javax.persistence.*;
import java.math.BigDecimal;
import java.time.LocalDateTime;

@Entity
public class Transacao {

    @Id
    private String id;
    @Column(nullable = false)
    private BigDecimal valor;
    @Column(nullable = false)
    private LocalDateTime efetivadaEm;
    @OneToOne(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    private Estabelecimento estabelecimento;
    @ManyToOne(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    private Cartao cartao;

    @Deprecated
    public Transacao() {
    }

    public Transacao(String id, BigDecimal valor, LocalDateTime efetivadaEm, Estabelecimento estabelecimento, Cartao cartao) {
        this.id = id;
        this.valor = valor;
        this.efetivadaEm = efetivadaEm;
        this.estabelecimento = estabelecimento;
        this.cartao = cartao;
    }
}
