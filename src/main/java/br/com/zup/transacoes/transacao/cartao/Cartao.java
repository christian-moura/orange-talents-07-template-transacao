package br.com.zup.transacoes.transacao.cartao;


import br.com.zup.transacoes.transacao.Transacao;

import javax.persistence.*;
import java.util.List;

@Entity
public class Cartao {
    @Id
    private String id;
    @Column(nullable = false)
    private String email;
    @OneToMany(fetch = FetchType.LAZY, mappedBy = "cartao")
    private List<Transacao> transacao;

    @Deprecated
    public Cartao() {
    }

    public Cartao(String id, String email) {
        this.id = id;
        this.email = email;
    }

    public String getId() {
        return id;
    }

    public String getEmail() {
        return email;
    }

    public List<Transacao> getTransacao() {
        return transacao;
    }
}
