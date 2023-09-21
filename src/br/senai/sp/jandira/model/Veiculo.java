package br.senai.sp.jandira.model;


import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Veiculo {
    String modelo, cor, marca, placa, combustivel;
    double preco;
    int ano;

    Scanner teclado = new Scanner(System.in);
    List<Veiculo> listVeiculos = new ArrayList<>();

    public void cadastrarVeiculo(){

        System.out.println("-----------------Cadastro Veiculo--------------------------");
        System.out.println("Informe a marca: ");
        marca = teclado.nextLine();
        System.out.println("Informe a cor: ");
        cor = teclado.nextLine();
        System.out.println("Informe o modelo: ");
        modelo = teclado.nextLine();
        System.out.println("Informe a placa: ");
        placa = teclado.nextLine();
        System.out.println("Informe o tipo de combustível: ");
        combustivel = teclado.nextLine();
        System.out.println("Informe o ano: ");
        ano = teclado.nextInt();
        System.out.println("Informe o preço: R$ ");
        preco = teclado.nextDouble();

        teclado.nextLine();
        System.out.println("-----------------Cadastro Finalizado--------------------------");

    }
    public void adicionarVeiculo(Veiculo objVeiculo){
        listVeiculos.add(objVeiculo);
    }
    public void listarVeiculo(){
        for (Veiculo objVeiculo : listVeiculos){
            System.out.println(objVeiculo.modelo);
        }
    }
    public boolean pesquisarVeiculo(String veiculoPesquisado){
        for (Veiculo objVeiculo : listVeiculos){
            if (objVeiculo.modelo.equalsIgnoreCase(veiculoPesquisado)){
                return true;
            }
        }
        return false;
    }
    public Veiculo localizarVeiculoCompra(String modeloVeiculo){
        for (Veiculo veiculo : listVeiculos){
            if (veiculo.modelo.equalsIgnoreCase(modeloVeiculo)){
                return veiculo;
            }
        }
        return null;
    }

}
