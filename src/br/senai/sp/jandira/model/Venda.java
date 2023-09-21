package br.senai.sp.jandira.model;

import java.util.Scanner;

public class Venda {

    Scanner teclado = new Scanner(System.in);

    double valorEntrada;

    public boolean realizarVenda(Veiculo objVeiculo, Cliente objCliente){

        if (objCliente.dinheiroDisponivel >= objVeiculo.preco){

            System.out.println("-------------------- Parabéns -------------------");
            System.out.println("Olá " + objCliente.nome);
            System.out.println("Você acaba de adquirir um " + objVeiculo.modelo);
            System.out.println("No precinho de " + objVeiculo.preco);
            System.out.println("-------------------------------------------------");

            return true;
        } else {

            System.out.println("Escolha um veiculo mais compativel com sua realidade !!");
            return false;

        }
    }

    public boolean avaliarFormaPagamento(){
        System.out.println("///// Informe como deseja pagar /////");
        System.out.println("///// 1 - À vista               /////");
        System.out.println("///// 2 - Financiamento         /////");
        System.out.println("/////////////////////////////////////");

        int formaPagamento = teclado.nextInt();
        teclado.nextLine();

        if (formaPagamento == 1){
            return true;
        } else {
            return false;
        }
    }

    public boolean realizarFinanciamento(Cliente cliente, Veiculo veiculo){

        System.out.println("/// ---- Financiamento  ---- ///");

        System.out.println("Informe o valor da entrada: ");
        valorEntrada = teclado.nextDouble();

        System.out.println("Informe quantas parcelas: ");
        int parcelas = teclado.nextInt();
        teclado.nextLine();

        if (valorEntrada <= cliente.dinheiroDisponivel && valorEntrada > 0){

            double valorFinanciado = veiculo.preco - valorEntrada;
            double valorParcelas = valorFinanciado / parcelas;

            System.out.println("O valor das parcelas será de " + valorParcelas);

            return  true;
        }
        return false;
    }
}