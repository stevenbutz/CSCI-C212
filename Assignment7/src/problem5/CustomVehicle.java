package problem5;

import problem1.Person;
import problem1.Driver;
import problem1.Passenger;

import java.util.ArrayList;
import java.util.List;

public class CustomVehicle {
    private int gear;
    private int speed;
    private int capacity;
    private List<Person> passengers;

    public CustomVehicle(int gear, int speed, int capacity) {
        this.gear = gear;
        this.speed = speed;
        this.capacity = capacity;
        this.passengers = new ArrayList<>();
    }

    public int getGear() {
        return gear;
    }

    public void setGear(int gear) {
        this.gear = gear;
    }

    public int getSpeed() {
        return speed;
    }

    public void setSpeed(int speed) {
        this.speed = speed;
    }

    public int getCapacity() {
        return capacity;
    }

    public void setCapacity(int capacity) {
        this.capacity = capacity;
    }

    public List<Person> getPassengers() {
        return passengers;
    }

    public void addPassenger(Person person) {
        if (passengers.size() < capacity) {
            passengers.add(person);
        } else {
            System.out.println("The vehicle is at maximum capacity.");
        }
    }

    public void removePassenger(Person person) {
        passengers.remove(person);
    }

    public boolean startVehicle() {
        boolean hasLicensedDriver = false;
        for (Person person : passengers) {
            if (person instanceof Driver) {
                Driver driver = (Driver) person;
                if (driver.isLicensed()) {
                    hasLicensedDriver = true;
                    break;
                }
            }
        }
        return hasLicensedDriver;
    }
}
