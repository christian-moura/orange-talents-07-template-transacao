package br.com.zup.transacoes.transacao.estabelecimento;

public class EstabelecimentoRequest {

    private String nome;
    private String cidade;
    private String endereco;

    public EstabelecimentoRequest(String nome, String cidade, String endereco) {
        this.nome = nome;
        this.cidade = cidade;
        this.endereco = endereco;
    }

    public Estabelecimento toEsbalecimento() {
        return new Estabelecimento(this.nome, this.cidade, this.endereco);
    }
}