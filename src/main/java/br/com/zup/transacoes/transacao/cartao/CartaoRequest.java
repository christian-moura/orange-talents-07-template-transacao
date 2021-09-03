package br.com.zup.transacoes.transacao.cartao;

public class CartaoRequest {

    private String id;
    private String email;

    public Cartao toCartao() {
        return new Cartao(this.id, this.email);
    }

    public CartaoRequest(String id, String email) {
        this.id = id;
        this.email = email;
    }
}