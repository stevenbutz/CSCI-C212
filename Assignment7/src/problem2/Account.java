package problem2;

public class Account extends Customer{
    private long accountNumber;

    public Account(String name, String address, int number, long accountNumber){
        super(name, address, number);
        if (accountNumber < 0) {
            this.accountNumber = 0;

        } else {
            this.accountNumber = accountNumber;
        }
    }

    public long getAccountNumber() {
        return accountNumber;
    }

    public void setAccountNumber(long accountNumber) throws IllegalArgumentException{
        if (accountNumber<0){
            this.accountNumber = 0;
//            throw new IllegalArgumentException("Account number cannot be less than 0");
        }
        else {
            this.accountNumber = accountNumber;
        }
    }

    @Override
    public String mailCheck() {
        System.out.println("Mailing a check to " + getName() + " Order number: "+ getNumber() +" at " + getAddress() +  this.accountNumber);
        return "Mailing a check to " + getName() + " Order number: "+ getNumber() +" at " + getAddress() +  this.accountNumber;
    }
}
