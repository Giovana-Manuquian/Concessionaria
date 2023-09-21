package br.senai.sp.jandira;

import br.senai.sp.jandira.model.Menu;

public class App {

    public static void main(String[] args) {

        System.out.println("------------------------------------");
        System.out.println("           Seja Bem Vindo(a)        ");
        System.out.println("            Agência Senai           ");
        System.out.println("------------------------------------");

        Menu objMenu = new Menu();
        objMenu.menu();

    }

}
