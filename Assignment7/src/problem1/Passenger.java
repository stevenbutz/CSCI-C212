package problem1;

public class Passenger extends Person{
    private String name;
    private int age;

    public Passenger(String name,int age) {
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
    }

    public void setAge(int age) throws IllegalArgumentException{
        if (age < 0) {
            this.age = 0;
//            throw new IllegalArgumentException("Age cannot be negative.");
        } else {
            this.age = age;
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
    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    @Override
    public String getDetails() {
        System.out.println("Passenger name: "+name+"\nPassenger age: "+age);
        return "Passenger name: "+name+"\nPassenger age: "+age;
    }
}
