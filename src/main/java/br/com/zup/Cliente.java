package br.com.zup;

public class Cliente extends Pessoa {
    private Venda venda;

    public Cliente() {

    }

    public Cliente(String nome, String cpf, String email) {
        super(nome, cpf, email);
    }

    public Venda getVenda() {
        return venda;
    }

    public void setVenda(Venda venda) {
        this.venda = venda;
    }

    @Override
    public String toString() {
        StringBuilder retorno = new StringBuilder();
        retorno.append("--------Lista-de-Clientes-cadastrados:------");
        retorno.append(super.toString() + "\n");
        retorno.append("--------------------------------------------");
        return retorno.toString();
    }
}
