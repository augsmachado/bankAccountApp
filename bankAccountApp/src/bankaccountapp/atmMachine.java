package bankaccountapp;

import javax.swing.JOptionPane;

public class atmMachine {
    private final String name;
    private static int account, password;
    private float balance;
    private int withdraws;
    
    private static final int TRUE = 1, FALSE = 0;
   
    public atmMachine(String name, int account, int password, float initialBalance) {
        this.name = name;
        atmMachine.account = account;
        atmMachine.password = password;
        balance = initialBalance;
        withdraws = 0;
    }
    
    public void start(){
        int option;
      
        do {
            option = Integer.parseInt(JOptionPane.showInputDialog("Do you want to access your account?"
                    + "\n1- Yes"
                    + "\n0- No").trim());
            
            // If the client wants to access the account
            if(option == TRUE) {
                option = isValid(account, password);
                
                // If account and password is valid, show the menu with options available
                if(option == TRUE) {
                    
                    // Show menu with options while user performs operations
                    do {
                        option = showMenu();
                        chooseOption(option);
                    } while(option != 0)  ;
                }
            }
        } while(option != 0);
    }
    
    // Account and password validation
    public int isValid(int account, int password) {
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
    
    public int showMenu() {
        return Integer.parseInt(JOptionPane.showInputDialog("\tChoose a option"
            + "\n1- See extract"
            + "\n2- Withdraw"
            + "\n3- Deposit"
            + "\n0- Exit"));
    }
    
    public void chooseOption(int option) {

        float value;
        
        switch(option) {
            case 1:
                extract();
                break;
            case 2:
                if (withdraws < 3) {
                    value = Float.parseFloat(JOptionPane.showInputDialog("Value"
                        + " of the withdraw: "));
                    withdraw(value);
                } else {
                    JOptionPane.showMessageDialog(null, "Daily withdrawal limit"
                    + " reached.");
                }
                break;
            case 3:
                value = Float.parseFloat(JOptionPane.showInputDialog("Value"
                    + " of the deposit: "));
                deposit(value);
                break;
            case 0:
                JOptionPane.showMessageDialog(null, "System shutdown");
                break;
            default:
                JOptionPane.showMessageDialog(null, "Option invalid."
                    + "\nTry again.");
        }
    }
    
    public void extract() {      
        JOptionPane.showMessageDialog(null, "\tEXTRACT"
            + "\nName: " +name
            +"\nAccount number: " +account
            +"\nBalance: " +balance
            +"\nWithdrawals made today: " +withdraws);
    }
    
    public void withdraw(float value) {

        if (balance >= value) {
            balance -= value;
            withdraws++;
            
            JOptionPane.showMessageDialog(null, "Amount withdraw: " +value
                +"\nNew balance: " +balance);
        } else {
            JOptionPane.showMessageDialog(null, "Insufficient funds."
                    + "\nMake a deposit!");

        }
    }
    
    public void deposit(float value) {
        // Is it value zero or negative? Loop until value to be positive
        while(value <= 0)
            value = Float.parseFloat(JOptionPane.showInputDialog("Value invalid."
                + "\nPut a new value."));
        
        balance += value; 
        
        JOptionPane.showMessageDialog(null, "Amount withdraw: " +value
            +"\nNew balance: " +balance);
    }
}
