package br.senai.sp.jandira.model;

public class Venda {

    public boolean realizarVenda(Veiculo objVeiculo, Cliente objCliente){

        if (objCliente.dinheiroDisponivel >= objVeiculo.preco){
            System.out.println("Olá " + objCliente.nome);
            System.out.println("Você acaba de adquirir um " + objVeiculo.modelo);
            System.out.println("No valor de " + objVeiculo.preco);
            return true;
        } else {
            System.out.println("Escolha um veículo mais compativel com sua realidade");
            return false;
        }

    }
}
