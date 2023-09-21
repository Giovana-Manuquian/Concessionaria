package br.senai.sp.jandira.model;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Cliente {

    /**
     * Declarar Variaveis
     *
     * */

    String nome, email, endereco;
    long telefone, cpf, rg;

    double dinheiroDisponivel;

    List<Cliente> listCliente = new ArrayList<>();

    Scanner teclado = new Scanner(System.in);

    public void cadastrarCliente(){

        System.out.println("-----------------Cadastro Cliente--------------------------");
        System.out.println("Qual é o nome do cliente: ");
        nome = teclado.nextLine();
        System.out.println("Informe o CPF: ");
        cpf = teclado.nextLong();
        System.out.println("Informe o RG: ");
        rg = teclado.nextLong();
        System.out.println("Informe o telefone: ");
        telefone = teclado.nextLong();
        teclado.nextLine();
        System.out.println("Informe o email: ");
        email = teclado.nextLine();
        System.out.println("Informe o endereço: ");
        endereco = teclado.nextLine();
        System.out.println("Informe o valor que pretende gastar: R$ ");
        dinheiroDisponivel = teclado.nextDouble();
        teclado.nextLine();
        System.out.println("-----------------Cadastro Finalizado--------------------------");

    }

    public void adicionarCliente(Cliente objCliente){

        listCliente.add(objCliente);

    }
    public Cliente buscarClientePorNome(String nome) {
        for (Cliente cliente : listCliente) {
            if (cliente.nome.equalsIgnoreCase(nome)) {
                return cliente;
            }
        }
        return null; // Cliente não encontrado
    }
    public void listarCliente(){

        for (Cliente objCliente : listCliente){
            System.out.println(objCliente.nome);
        }

    }
}
