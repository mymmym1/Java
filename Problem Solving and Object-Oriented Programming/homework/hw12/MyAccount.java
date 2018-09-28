public class MyAccount implements CheckingAccount, SavingAccount {
    public double balance;
    public MyAccount(double balance) {       
        this.balance = balance;      
    }
    public double getCheckingBalance() {
        System.out.println("Checking account contributes %80");
        return balance * 0.8;
    }
    public double getSavingBalance() {     
        System.out.println("Saving account contributes %20");
        return balance * 0.2;
    }
    public static void main(String[] args) {
        MyAccount c = new MyAccount(3000.5);
        System.out.print (c.getSavingBalance());
    }
}
