package br.com.zup.tdd;

import br.com.zup.*;
import org.junit.Assert;
import org.junit.Test;

import java.time.LocalDate;

public class SistemaTest {

    @Test
    public void testarCadastroDeVendasCaminhoRuim() throws Exception {
        Cliente cliente = new Cliente();
        VendedorResponsavel vendedor = new VendedorResponsavel();

        Assert.assertThrows(Exception.class, () -> ServicoVenda.cadastrarVendas(cliente, vendedor, 250));
    }

    @Test
    public void testarBuscaPorClienteCaminhoBom() throws Exception {
        Cliente cliente = ServicoCliente.cadastrarClientes("Chico", "203.205.143-06", "chicoBento@gmail.com");
        VendedorResponsavel vendedor = new VendedorResponsavel();
        Venda venda = new Venda(cliente, vendedor, 250, LocalDate.now());

        Assert.assertTrue(ServicoVenda.validarCadastrosCliente("203.205.143-06", venda));

    }

    @Test
    public void testarBuscaPorClienteCaminhoRuim() throws Exception {
        Cliente cliente = ServicoCliente.cadastrarClientes("Chico", "203.205.143-06", "chicoBento@gmail.com");
        VendedorResponsavel vendedor = new VendedorResponsavel();
        Venda venda = new Venda(cliente, vendedor, 250, LocalDate.now());

        RuntimeException exception = Assert.assertThrows(RuntimeException.class, () ->
                ServicoVenda.validarCadastrosCliente("103.205.143-06", venda));
        Assert.assertEquals("CPF do Cliente não foi Encontrado. Verifique a lista de Clientes cadastrados na Opção 4", exception.getMessage());

    }

}
