package br.com.zup;

import java.time.LocalDate;
import java.time.LocalDateTime;

public class Venda {
    private VendedorResponsavel vendedor;
    private Cliente cliente;
    private LocalDate dataDeRegistro;
    private double valorASerPago;


    public Venda() {
    }

    public Venda(double valorASerPago, LocalDate dataDeRegistro) {
        this.valorASerPago = valorASerPago;
        this.dataDeRegistro = dataDeRegistro;
    }

    public Venda(Cliente clientes, VendedorResponsavel vendedor, double valorASerPago, LocalDate dataDeRegistro) {
        this.dataDeRegistro = dataDeRegistro;
        this.valorASerPago = valorASerPago;
        this.cliente = clientes;
        this.vendedor = vendedor;
    }

    public VendedorResponsavel getVendedor() {
        return vendedor;
    }

    public void setVendedor(VendedorResponsavel vendedor) {
        this.vendedor = vendedor;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public double getValorASerPago() {
        return valorASerPago;
    }

    public void setValorASerPago(double valorASerPago) {
        this.valorASerPago = valorASerPago;
    }

    public LocalDate getDataDeRegistro() {
        return dataDeRegistro;
    }

    public void setDataDeRegistro(LocalDate dataDeRegistro) {
        this.dataDeRegistro = dataDeRegistro;
    }

    @Override
    public String toString() {
        StringBuilder retorno = new StringBuilder();
        retorno.append("\n----------------Vendas-Cadastradas-------------");
        retorno.append("\nCliente - ");
        retorno.append("[ " + cliente.getNome() + " | " + cliente.getCpf() + " | "
                + cliente.getEmail() + " ]");
        retorno.append("\nVendedor Responsável - ");
        retorno.append("[ " + vendedor.getNome() + " | " + vendedor.getCpf() + " | "
                + vendedor.getEmail() + " ]");
        retorno.append("\nVenda - ");
        retorno.append("[ Data de Registro: " + dataDeRegistro);
        retorno.append(" | Valor A Ser Pago: R$" + valorASerPago + " ]\n");
        retorno.append("------------------------------------------------");
        return retorno.toString();
    }
}
