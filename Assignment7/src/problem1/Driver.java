package problem1;

public class Driver extends Person{
    private String name;
    private int age;
    Boolean isLicensed;

    public Driver(String name,int age){
        if (age < 0) {
            this.age = 0;
        } else {
            this.age = age;
        }
        if (name == null) {
            this.name = "";
        }
        else{
            this.name = name;
            }
        this.isLicensed = (age >= 16);
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) throws IllegalArgumentException{
        if (age < 0) {
            this.age = 0;
//            throw new IllegalArgumentException("Age cannot be negative.");
        } else {
            this.age = age;
            this.isLicensed = (age >= 16);
    }}
    public void setName(String name) throws IllegalArgumentException{
        if (name == null) {
            this.name = "";
//            throw new IllegalArgumentException("Name cannot be null");
        }
        else{
            this.name = name;
        }
    }
    public void setLicensed(Boolean licensed) {
        isLicensed = licensed;
    }

    public String getName() {
        return name;
    }

    public Boolean isLicensed() {
        return isLicensed;
    }

    @Override
    public String getDetails() {
        System.out.println("Driver name: " + name +"\nDriver age: "+ age +"\nDriver is licensed: "+isLicensed);
        return "Driver name: " + name +"\nDriver age: "+ age +"\nDriver is licensed: "+isLicensed;
    }
}
