package br.senai.sp.jandira.model;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Funcionario {

    String nome, email, endereco;
    long telefone, cpf, rg;
    double comissao;

    List<Funcionario> listFuncionario = new ArrayList<>();
    Scanner teclado = new Scanner(System.in);

    public void cadastarFuncionario(){

        System.out.println("-----------------Cadastro Cliente--------------------------");
        System.out.println("Qual é o nome do funcionário: ");
        nome = teclado.nextLine();
        System.out.println("Informe o CPF: ");
        cpf = teclado.nextLong();
        System.out.println("Informe o RG: ");
        rg = teclado.nextLong();
        teclado.nextLine();
        System.out.println("Informe o telefone: ");
        telefone = teclado.nextLong();
        teclado.nextLine();
        System.out.println("Informe o email: ");
        email = teclado.nextLine();
        System.out.println("Informe o endereço: ");
        endereco = teclado.nextLine();
        System.out.println("-----------------Cadastro Finalizado--------------------------");

    }
    public void receberComissao(Veiculo objVeiculo){

        comissao += objVeiculo.preco * 0.10;

        System.out.println("A comissão do funcionário é: " + comissao);

    }
    public void adicionarFuncionario(Funcionario objFuncionario){

        listFuncionario.add(objFuncionario);

    }
    public void listarFuncionario(){

        for (Funcionario objFuncionario : listFuncionario){
            System.out.println(objFuncionario.nome);
        }

    }

    public Funcionario pesquisarVendedor(String nome){
        for (Funcionario vendedor : listFuncionario){
            if (vendedor.nome.equalsIgnoreCase(nome)){
                return vendedor;
            }
        }
        return null;
    }

}