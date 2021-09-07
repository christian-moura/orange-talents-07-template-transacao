package br.com.zup.transacoes.transacao.estabelecimento;

public class EstabelecimentoRequest {

    private String nome;
    private String cidade;
    private String endereco;

    @Deprecated
    public EstabelecimentoRequest() {
    }

    public EstabelecimentoRequest(String nome, String cidade, String endereco) {
        this.nome = nome;
        this.cidade = cidade;
        this.endereco = endereco;
    }

    public Estabelecimento toEsbalecimento() {
        return new Estabelecimento(this.nome, this.cidade, this.endereco);
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

    @Override
    public String toString() {
        return "Estabelecimento{" +
                "nome='" + nome + '\'' +
                ", cidade='" + cidade + '\'' +
                ", endereco='" + endereco + '\'' +
                '}';
    }
}