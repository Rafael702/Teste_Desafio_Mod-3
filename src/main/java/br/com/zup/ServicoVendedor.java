package br.com.zup;

import java.util.ArrayList;
import java.util.ConcurrentModificationException;
import java.util.List;

public class ServicoVendedor {
    private static List<VendedorResponsavel> vendedores = new ArrayList<>();

    public static List<VendedorResponsavel> getVendedores() {
        return vendedores;
    }

    public static VendedorResponsavel cadastrarVendedor(String nome, String cpf, String email) throws Exception {

        VendedorResponsavel vendedor = new VendedorResponsavel(nome, cpf, email);
        validarCadastroVendedor(cpf, email, vendedor);
        return vendedor;
    }


    public static boolean validarCadastro(String cpf) throws Exception {
        boolean cadastrado = false;
        if (vendedores.isEmpty()) {
            throw new Exception("Nenhum Vendedor Cadastrado.");
        } else {
            for (VendedorResponsavel vendedorResponsavel : vendedores) {
                if (vendedorResponsavel.getCpf().equals(cpf)) {
                    cadastrado = true;
                    return cadastrado;
                }
            }
            throw new Exception("Email do Vendedor não foi Encontrado. Verifique a lista de Vendedores cadastrados na Opção 4");
        }
    }

    public static List<VendedorResponsavel> validarCadastroVendedor(String novoCpf, String novoEmail, VendedorResponsavel vendedor) throws Exception {
        //Corrigir nulos
        try {
            if (vendedores.isEmpty()) {
                adicionarNaLista(vendedor);
                System.out.println("Vendedores cadastrado com Sucesso!");
                System.out.println("");
            } else {
                for (VendedorResponsavel vendedorReferencia : vendedores) {
                    if (!vendedorReferencia.getCpf().equals(novoCpf) & !vendedorReferencia.getEmail().equals(novoEmail)) {
                        System.out.println("Vendedor cadastrado com Sucesso!");
                        adicionarNaLista(vendedor);
                    } else {
                        throw new Exception("CPF ou Email Duplicado. Digite 4 e Confira os Vendedores Cadastrados.");
                    }
                }
            }
        } catch (ConcurrentModificationException cme) {
            System.out.println("");
        }
        return vendedores;
    }

    public static void adicionarNaLista(VendedorResponsavel novoVendedor) {
        vendedores.add(novoVendedor);
    }


    public static void exibirListaVendedor() {
        for (VendedorResponsavel vendedoresReferencia : vendedores) {
            System.out.println(vendedoresReferencia);
        }
    }
}
