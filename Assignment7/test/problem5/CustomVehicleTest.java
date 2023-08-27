package problem5;

import org.junit.jupiter.api.Test;
import problem1.Passenger;
import problem1.Person;
import problem1.Driver;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class CustomVehicleTest {

    @Test
    void getGear() {
        CustomVehicle vehicle = new CustomVehicle(1,2,2);
        assertEquals(vehicle.getGear(),1);
    }

    @Test
    void getSpeed() {
        CustomVehicle vehicle = new CustomVehicle(1,2,2);
        assertEquals(vehicle.getSpeed(),2);
    }

    @Test
    void getCapacity() {
        CustomVehicle vehicle = new CustomVehicle(1,2,2);
        assertEquals(vehicle.getCapacity(),2);
    }

    @Test
    void getaddPassengers() {
        CustomVehicle vehicle = new CustomVehicle(1,2,3);
        Person Passenger = new Passenger("john",23);
        vehicle.addPassenger(Passenger);
        assertEquals(Passenger.getDetails(),"Passenger name: john\nPassenger age: 23");
        vehicle.removePassenger(Passenger);


    }


    @Test
    void startVehicle() {
        CustomVehicle vehicle = new CustomVehicle(1,2,3);
        Person Passenger = new Passenger("john",23);
        vehicle.addPassenger(Passenger);
        Person Driver = new Driver("Mike",23);
        vehicle.addPassenger(Driver);
        assertTrue(vehicle.startVehicle());

    }
}