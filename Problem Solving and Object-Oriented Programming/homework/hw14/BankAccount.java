public class BankAccount {
    String id;
    int balance;
    
//    static int deposit;
//    static int withdraw;       
    public BankAccount (String id,int balance) {
        this.id = id;
        this.balance = balance;        
    }
    void depositMoney(int deposit) 
        throws NegativeBalanceException {
        if ( (deposit + balance) < 0)
            throw new NegativeBalanceException ("Balance cannot be negative.");
        else
            balance = balance + deposit;
    }
    void withdrawMoney(int withdraw) 
        throws NegativeBalanceException {
        if ((balance - withdraw) < 0)
            throw new NegativeBalanceException ("Balance cannot be negative.");
        else
            balance = balance - withdraw;
    }
   int getBalance() {        
        return balance;
    }
   public static void main (String[] args) {       
       BankAccount a = new BankAccount("3", 200);
       System.out.println(a.getBalance());     
       try {
            a.depositMoney(-100); 
            a.withdrawMoney(100);           
        }
        catch (NegativeBalanceException e) {
            System.out.println (e);           
        }
   }
}
