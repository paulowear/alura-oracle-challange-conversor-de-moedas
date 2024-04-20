package br.com.paulo.ConversorDeMoedas.main;

import java.util.Locale;

public class Main {
    public static void main(String[] args) {
        // Configura o local padrão para os números serem formatados corretamente
        Locale.setDefault(Locale.US);
        // Cria uma instância do menu e chama o método de seleção para iniciar o programa
        Menu menu = new Menu();
        menu.selection();
    }

}