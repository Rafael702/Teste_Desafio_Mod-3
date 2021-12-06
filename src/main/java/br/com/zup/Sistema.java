package br.com.zup;

import java.util.Scanner;

public class Sistema {

    public static boolean executar() throws Exception {
        boolean continuarMenu = true;
        while (continuarMenu) {

            menuPrincipal();
            int opcao = capturarDados("Informe a sua opção escolhida:").nextInt();

            if (opcao == 1) {
                cadastrarVendas();
            } else if (opcao == 2) {
                cadastrarClientes();
            } else if (opcao == 3) {
                cadastrarVendedores();
            } else if (opcao == 4) {
                ServicoCliente.exibirListaCliente();
            } else if (opcao == 5) {
                ServicoVendedor.exibirListaVendedor();
            } else if (opcao == 6) {
                ServicoVenda.exibirLista();
            } else if (opcao == 7) {
                pesquisarCliente();
            } else if (opcao == 8) {
                pesquisarVendedor();
            } else if (opcao == 9) {
                System.out.println("Saindo do Menu");
                saindoDoPrograma();
                continuarMenu = false;
            } else {
                System.out.println("Opção Inválida. Digite Uma Opção de Acordo com o Menu.");
            }
        }
        return continuarMenu;
    }

    private static Scanner capturarDados(String mensagem) {
        System.out.println(mensagem);
        return new Scanner(System.in);
    }

    private static void menuPrincipal() {
        System.out.println("Digite 1: Para Cadastrar uma Venda");
        System.out.println("Digite 2: Para Cadastrar um Cliente");
        System.out.println("Digite 3: Para Cadastrar um Vendedor");
        System.out.println("Digite 4: Para Mostrar os Clientes Cadastrados");
        System.out.println("Digite 5: Para Mostrar os Vendedores Cadastrados");
        System.out.println("Digite 6: Para Mostrar as Vendas Cadastradas");
        System.out.println("Digite 7: Para Pesquisar Clientes");
        System.out.println("Digite 8: Para Pesquisar Vendedores");
        System.out.println("Digite 9: Para Sair do Menu");
    }

    private static String informarNome() {
        String nome = capturarDados("Informe o nome: ").nextLine();
        return nome;
    }

    private static String informarEmail() throws Exception {
        String email = capturarDados("Informe o email:").nextLine();
        if (validarEmail(email)) {
            return email;
        } else {
            throw new Exception("Todos os Emails devem conter @. Exemplo: pessoa@pessoa.");
        }
    }

    public static boolean validarEmail(String email) {
        boolean emailTemArroba = false;
        if (email.contains("@")) {
            emailTemArroba = true;
        }
        return emailTemArroba;
    }

    private static String informarCpf() {
        String cpf = capturarDados("Informe o CPF:").nextLine();
        return cpf;
    }

    private static Cliente cadastrarClientes() throws Exception {
        System.out.println("-----------------------Cadastro-de-Clientes----------------------");
        return ServicoCliente.cadastrarClientes(informarNome(), informarCpf(), informarEmail());

    }

    private static VendedorResponsavel cadastrarVendedores() throws Exception {
        System.out.println("-----------------------Cadastro-de-Vendedores---------------------");
        return ServicoVendedor.cadastrarVendedor(informarNome(), informarCpf(), informarEmail());
    }

    private static Venda cadastrarVendas() throws Exception {
        double valorASerPago = capturarDados("Informe o valor a ser pago:").nextDouble();
        String dataDeRegistro = capturarDados("Informe a Data De Registro da Venda: Ex dd/mm/AAAA").nextLine();
        Cliente cliente;
        VendedorResponsavel vendedor;
        cliente = ServicoVenda.cadastrarClientes(informarNome(), informarCpf(), informarEmail());
        vendedor = ServicoVenda.cadastrarVendedor(informarNome(), informarCpf(), informarEmail());

        return ServicoVenda.validacoesDeCadastros(cliente, vendedor,
                ServicoVenda.cadastrarVendas(cliente, vendedor, valorASerPago, dataDeRegistro));

    }

    public static void pesquisarCliente() throws Exception {
        String cpf = informarCpf();
        ServicoVenda.pesquisarVendasParaClientes(cpf);
    }

    public static void pesquisarVendedor() throws Exception {
        String email = informarEmail();
        ServicoVenda.pesquisarVendasDoVendedor(email);
    }

    public static void saindoDoPrograma() throws Exception {
        System.out.println("Saindo do Programa");
        for (int i = 1; i <= 20; i++) {
            System.out.print("-");
            Thread.sleep(500);
            if (i == 10) {
                System.out.print("---COME-IN-BACK---");
            }
        }
    }
}
