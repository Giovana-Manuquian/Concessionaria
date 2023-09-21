package br.senai.sp.jandira.model;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Cliente {

    /**
     * Declarar Variaveis
     *
     * */

    public String nome, email, endereco;
    public long telefone, cpf, rg;

    public double dinheiroDisponivel;

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

    public void listarCliente(){

        for (Cliente objCliente : listCliente){
            System.out.println(objCliente.nome);
        }

    }

    public Cliente pesquisarComprador(String nome){
        for (Cliente cliente : listCliente){
            if (cliente.nome.equalsIgnoreCase(nome)){
                return cliente;
            }
        }
        return null;
    }
}


