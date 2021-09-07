package br.com.zup.transacoes.transacao.estabelecimento;


import br.com.zup.transacoes.transacao.Transacao;

import javax.persistence.*;

@Entity
public class Estabelecimento {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(nullable = false)
    private String nome;
    @Column(nullable = false)
    private String cidade;
    @Column(nullable = false)
    private String endereco;
    @OneToOne(fetch = FetchType.LAZY, mappedBy = "estabelecimento")
    private Transacao transacao;

    @Deprecated
    public Estabelecimento() {
    }

    public Estabelecimento(String nome, String cidade, String endereco) {
        this.nome = nome;
        this.cidade = cidade;
        this.endereco = endereco;
    }

    public Long getId() {
        return id;
    }

    public String getNome() {
        return nome;
    }

    public String getCidade() {
        return cidade;
    }

    public String getEndereco() {
        return endereco;
    }

}
