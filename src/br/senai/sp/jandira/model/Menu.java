package br.senai.sp.jandira.model;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Menu {
    Scanner teclado = new Scanner(System.in);
    Veiculo refListVeiculo = new Veiculo();
    Cliente refListCliente = new Cliente();
    Funcionario refListFuncionario = new Funcionario();
    Venda objVenda = new Venda();

    public void menu(){

        boolean continuar = true;

        while(continuar){

            System.out.println("------------------------------------");
            System.out.println("1 - Cadastrar Cliente");
            System.out.println("2 - Cadastrar Veiculo");
            System.out.println("3 - Cadastrar Funcionário");
            System.out.println("4 - Realizar Venda");
            System.out.println("5 - Listar Veiculos");
            System.out.println("6 - Listar Clientes");
            System.out.println("7 - Listar Funcionarios");
            System.out.println("8 - Pesquisar Veiculos");
            System.out.println("9 - Sair");
            System.out.println("Opção: ");

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
                    System.out.println("Informe o modelo do veículo: ");
                    String modeloVeiculo = teclado.nextLine();

                    Veiculo objVeiculoSelecionado = refListVeiculo.pesquisarVeiculoPorModelo(modeloVeiculo);

                    if (objVeiculoSelecionado != null){
                        System.out.println("Informe o nome do cliente: ");
                        String nomeCliente = teclado.nextLine();

                        // Verificar se o veículo está disponível para venda
                        if (objVeiculoSelecionado.pesquisarVeiculoPorNome(modeloVeiculo)){
                            // Buscar o cliente pelo nome
                            Cliente objClienteSelecionado = refListCliente.buscarClientePorNome(nomeCliente);

                            if (objClienteSelecionado != null){
                                // Realizar a venda
                                boolean validaVenda = objVenda.realizarVenda(objVeiculoSelecionado, objClienteSelecionado);

                                if (validaVenda){
                                    objClienteSelecionado.dinheiroDisponivel -= objVeiculoSelecionado.preco;
                                    System.out.println("O saldo do cliente é: " + objClienteSelecionado.dinheiroDisponivel);
                                }
                            } else {
                                System.out.println("Cliente não encontrado.");
                            }
                        } else {
                            System.out.println("Veículo não disponível para venda.");
                        }
                    } else {
                        System.out.println("Veículo não encontrado.");
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

                    if (veiculoPesquisado != null && veiculoPesquisado != ""){
                        validaVeiculo = refListVeiculo.pesquisarVeiculoPorNome(veiculoPesquisado);
                    }

                    if (validaVeiculo){
                        System.out.println("Veiculo disponivel para compra");
                    } else {
                        System.out.println("Veiculo indisponivel");
                    }
                    break;

                case 9:
                    continuar = false;
                    break;
            }

            if (escolhaUsuario < 0 || escolhaUsuario > 9){
                System.out.println("Escolha uma opção válida");
            }

        }
    }

}
