package bankaccountapp;

import javax.swing.JOptionPane;

public class atmMachine {
    private final String name;
    private static int account, password;
    private int withdraws;
    private float balance;
    
    private static final int TRUE = 1, FALSE = 0;
   
    public atmMachine(String name, int account, int password, float initialBalance) {
        this.name = name;
        atmMachine.account = account;
        atmMachine.password = password;
        balance = initialBalance;
        withdraws = 0;
    }
    
    public static void start(){
        int option;
      
        do {
            option = Integer.parseInt(JOptionPane.showInputDialog("Do you want to access your account?"
                    + "\n1- Yes"
                    + "\n0- No").trim());
            
            // If the client wants to access the account
            if(option == TRUE) {
                option = isValid(account, password);
                
                if(option == TRUE) {
                    JOptionPane.showMessageDialog(null, "Congrats");
                    showMenu();
                }
            }
            
        } while(option != 0);
    }
    
    // Account and password validation
    public static int isValid(int account, int password) {
        int confirmAccount, confirmPassword;
        
        for(int i = 0; i <3; i++) {
            confirmAccount = Integer.parseInt(JOptionPane.showInputDialog("Enter your account"));
            if(confirmAccount == account) {
                confirmPassword = Integer.parseInt(JOptionPane.showInputDialog("Enter your password"));

                // When account and password are same, return true
                if (confirmPassword == password) {
                    return TRUE;
                }
            }
            JOptionPane.showMessageDialog(null, "Account or password are wrong :/");
        }
        
        JOptionPane.showMessageDialog(null, "You lost the access for this account."
                + "\nTalk with your Bank Manager!");
        return FALSE;
    }
    
    public static void showMenu() {
        
    }
}
