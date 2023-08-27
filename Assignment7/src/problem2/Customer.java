package problem2;

public class Customer {
    private String name;
    private String address;
    private int number;
    public Customer(String name, String address, int number) {
        if (name == null || address == null || number < 0) {
            if (name == null) {
                this.name = "";
            }
            if (address == null) {
                this.address = "";
            }
            if (number < 0) {
                this.number = 0;
            }

        } else {
            this.name = name;
            this.address = address;
            this.number = number;
        }
    }

    public String getName() {
        return name;
    }

    public void setName(String name) throws IllegalArgumentException{
        if (name == null) {
            this.name = "";
//            throw new IllegalArgumentException("Need Name");
        }
        else{
            this.name = name;
        }
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) throws IllegalArgumentException{
        if (address == null){
            this.address = "";
//            throw new IllegalArgumentException("Need address not null");
        }
        else {
            this.address = address;
        }
    }

    public int getNumber() {
        return number;
    }

    public void setNumber(int number) throws IllegalArgumentException{
        if (number <0){
            this.number = 0;
//            throw new IllegalArgumentException("Number needs to be positive");
        }
        else {
            this.number = number;
        }
    }
    public String mailCheck() {
        System.out.println("Mailing a check to " + this.name + " at " + this.address +" Order number: "+this.number);
        return "Mailing a check to " + this.name + " at " + this.address +" Order number: "+this.number;
    }
}
