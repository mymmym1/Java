import java.util.*;
public class BankAccount {
    private int accountNumber;
    private String name;
    private double balance;
    private double interestRate;    
    private static int accountCount = 0;    
    public BankAccount (String name) {        
        Random randomGenerator = new Random();
        int randomInt = randomGenerator.nextInt(1000000);        
        this.accountNumber =  randomInt;
        this.name = name;
        this.balance = 0.0;       
        accountCount++;        
        this.interestRate = getInterestRate();
    }    
    public BankAccount (String name, double money) {        
        this(name);
        this.balance = money;
    }      
    public String getName () {  //Accessor Method for the name field.    
        return name;
    }    
    public void setName (String name) {  //Mutator Method for the name field.    
        this.name = name;
    }    
    public double deposit(double money) {        
        if (money >= 0) {
            balance += money;
            return money;
        }
        else return -1;
    }    
    public double withdrawMoney(double money) {        
        if (money  >= 0 && balance >= money) {
            balance -= money;
            return money;
        } 
        else return -1;        
    }    
    public int getAccountNumber() {        
        return accountNumber;
    }    
    public static double getInterestRate() {        
        return 0.3 - 0.02 * (accountCount / 5);
    }    
    public double transfer(BankAccount destinationBankAccount, double amount) {        
        if ( destinationBankAccount == null ) return -1;
        else if (amount >= 0 && this.balance >= amount) {            
            this.balance -= amount;
            destinationBankAccount.deposit(amount);
            return amount;            
        }
        else return -1;        
    }    
    public double transfer(BankAccount[] destinationBankAccount, double amount) {        
        int n = 0;
        if (destinationBankAccount == null) return -1;
        else n = destinationBankAccount.length;        
        if (n == 0) return -1;        
        for (int i = 0; i < n; i++) {
            if ( destinationBankAccount[i] == null ) 
                return -1;
        }
        if (amount >= 0 && this.balance >= amount * n)  {
            for (int i = 0; i < n; i++) {
                this.balance -= amount;
                destinationBankAccount[i].deposit(amount);
            }
            return amount * n;            
        }
        else return -1;     
    }    
    public static void main(String [ ] args) {        
        BankAccount bankAccountOne = new BankAccount("Bob", 1000); 
        BankAccount bankAccountTwo = new BankAccount("Sara");         
        double transfer = bankAccountOne.transfer(bankAccountTwo, 500);
    }    
}
