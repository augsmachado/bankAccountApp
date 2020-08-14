package bankaccountapp;

import javax.swing.JOptionPane;

public class atmMachine {
    private String name;
    private int account, password, withdraws;
    private float balance;
   
    public atmMachine(String name, int account, int password, float initialBalance) {
        this.name = name;
        this.account = account;
        this.password = password;
        balance = initialBalance;
        withdraws = 0;
        
        System.out.print(this.name+"\n"+this.account+"\n"+this.password+"\n"+balance);
    }
    
    public static void start(){
        int option;
        
        do {
            //exibeMenu();
            option = Integer.parseInt(JOptionPane.showInputDialog("Do you want to acess your account?\n1-Yes\n0-No").trim());
            //escolherOpcao(opcao);
        } while(option != 0);
    }
}
