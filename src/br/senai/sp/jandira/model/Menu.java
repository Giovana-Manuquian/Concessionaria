package br.senai.sp.jandira.model;

import java.util.Scanner;

public class Menu {
    Scanner teclado = new Scanner(System.in);
    Cliente refListCliente = new Cliente();
    Funcionario refListFuncionario = new Funcionario();

    Veiculo refListVeiculo = new Veiculo();

    Venda objVenda = new Venda();
    public void menu(){

        boolean continuar = true;

        while(continuar){

            System.out.println("----------------------------");
            System.out.println("----------   Menu  ---------");
            System.out.println("----------------------------");
            System.out.println("1- Cadastrar Cliente");
            System.out.println("2- Cadastar Veiculo");
            System.out.println("3- Cadastar Funcionario");
            System.out.println("4- Realizar Venda");
            System.out.println("5- Listar Veiculos");
            System.out.println("6- Listar Clientes");
            System.out.println("7- Listar Funcionarios");
            System.out.println("8- Pesquisar Veiculos");
            System.out.println("9- Sair");
            System.out.println("-----------------------------");
            System.out.println("-----------------------------");

            int escolhaUsuario = teclado.nextInt();
            teclado.nextLine();

            switch (escolhaUsuario){

                case 1:
                    Cliente objCliente = new Cliente();
                    objCliente.cadastrarCliente();
                    refListCliente.adicionarCliente(objCliente);
                    break;

                case 2:
                    Veiculo objVeiculo = new Veiculo();
                    objVeiculo.cadastrarVeiculo();
                    refListVeiculo.adicionarVeiculo(objVeiculo);
                    break;

                case 3:
                    Funcionario objFuncionario = new Funcionario();
                    objFuncionario.cadastarFuncionario();
                    refListFuncionario.adicionarFuncionario(objFuncionario);
                    break;

                case 4:

                    refListCliente.listarCliente();
                    System.out.println("Informe o nome do Cliente: ");
                    String nomeComprador = teclado.nextLine();

                    refListVeiculo.listarVeiculo();
                    System.out.println("Informe o modelo do Veiculo: ");
                    String modeloVeiculo = teclado.nextLine();

                    refListFuncionario.listarFuncionario();
                    System.out.println("Informe o nome do Vendedor: ");
                    String nomeVendedor = teclado.nextLine();


                    Cliente objComprador = refListCliente.pesquisarComprador(nomeComprador);

                    Veiculo objVeiculoVenda = refListVeiculo.localizarVeiculoCompra(modeloVeiculo);

                    Funcionario objVendedor = refListFuncionario.pesquisarVendedor(nomeVendedor);

                    boolean formaPagamento = objVenda.avaliarFormaPagamento();

                    boolean validaVenda = false;
                    boolean validaFinanciamento = false;

                    if (formaPagamento) {
                        validaVenda = objVenda.realizarVenda(objVeiculoVenda, objComprador);
                    } else {
                        validaFinanciamento = objVenda.realizarFinanciamento(objComprador, objVeiculoVenda);
                    }

                    if (validaVenda || validaFinanciamento){
                        System.out.println("///// ----- Parabens Pelo seu novo Veiculo ----- //////");

                        if (validaVenda) {
                            objComprador.dinheiroDisponivel -= objVeiculoVenda.preco;
                            System.out.println("O saldo do cliente é: " + objComprador.dinheiroDisponivel);
                        }

                        if (validaFinanciamento){
                            objComprador.dinheiroDisponivel -= objVenda.valorEntrada;
                            System.out.println("O saldo do cliente é: " + objComprador.dinheiroDisponivel);
                        }

                        objVendedor.receberComissao(objVeiculoVenda);
                        System.out.println("O Funcionario recebeu: " + objVendedor.comissao);
                    }
                    break;

                case 5:
                    refListVeiculo.listarVeiculo();
                    break;

                case 6:
                    refListCliente.listarCliente();
                    break;

                case 7:
                    refListFuncionario.listarFuncionario();
                    break;

                case 8:
                    System.out.println("Informe o modelo do veiculo: ");
                    String veiculoPesquisado = teclado.nextLine();
                    boolean validaVeiculo = false;

                    if (veiculoPesquisado != null && veiculoPesquisado != "") {
                        validaVeiculo = refListVeiculo.pesquisarVeiculo(veiculoPesquisado);
                    }

                    if (validaVeiculo){
                        System.out.println("Veiculo Disponivel para Compra !!");
                    } else {
                        System.out.println("Veiculo Indisponivel !!");
                    }
                    break;

                case 9:
                    continuar = false;
                    break;
            }

            if (escolhaUsuario < 1 || escolhaUsuario > 9){
                System.out.println("Escolha uma opção Válida !");
            }

        }
    }

}