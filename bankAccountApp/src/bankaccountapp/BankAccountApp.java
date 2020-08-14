package bankaccountapp;

import java.util.Random;
import javax.swing.JOptionPane;

public class BankAccountApp {

    public static void main(String[] args) {
        String nome;
        Random numero = new Random();
        
        // Criando dados do usuário e da conta
        nome = JOptionPane.showInputDialog("Qual o seu nome completo?");
        int conta = 1 + numero.nextInt(9999);
        int senha = 1 + numero.nextInt(9999);
        
        // Mostrando dados do usuário e da conta
        JOptionPane.showMessageDialog(null, "\nNome: " + nome 
                +"\nNúmero da conta: " +conta
                +"\nSenha: " +senha);
    }
    
}
