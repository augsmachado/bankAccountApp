package bankaccountapp;

import java.util.Random;
import javax.swing.JOptionPane;

public class BankAccountApp {

    public static void main(String[] args) {
        String name;
        Random number = new Random();
        
        // Criando dados do usuário e da account
        name = JOptionPane.showInputDialog("What's your fullname?");
        int account = 1000 + number.nextInt(8999);
        int password = 1000 + number.nextInt(8999);
        float initialBalance;
        initialBalance = (float) (1 + number.nextInt(9999));
        
        // Mostrando dados do usuário e da account
        JOptionPane.showMessageDialog(null, "\nFullname: " + name 
                +"\nAccount number: " +account
                +"\nPassword: " +password);
        
        // Criando a conta de um cliente
        atmMachine myAccount;
        myAccount = new atmMachine(name,account,password,initialBalance);
        myAccount.start();
    }
}
