package br.com.zup.transacoes.transacao.cartao;

public class CartaoRequest {

    private String id;
    private String email;

    public Cartao toCartao() {
        return new Cartao(this.id, this.email);
    }

    @Deprecated
    public CartaoRequest() {
    }

    public CartaoRequest(String id, String email) {
        this.id = id;
        this.email = email;
    }

    public String getId() {
        return id;
    }

    public String getEmail() {
        return email;
    }

    @Override
    public String toString() {
        return "Cartao{" +
                "id='" + id + '\'' +
                ", email='" + email + '\'' +
                '}';
    }
}