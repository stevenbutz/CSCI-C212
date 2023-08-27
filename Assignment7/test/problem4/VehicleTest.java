package problem4;

import org.junit.jupiter.api.Test;
import problem3.Instructor;

import static org.junit.jupiter.api.Assertions.*;

class VehicleTest {

    @Test
    void testToString() {
        Volkswagen vw = new Volkswagen(5, 60, 25);
        Ford ford = new Ford(6, 80, 20);
        Car car = new Car(2, 90, 29);
        ford.setGear(5);
        assertEquals(ford.getGear(),5);
        ford.setMileage(21);
        ford.setSpeed(70);
        assertEquals(ford.getMileage(),21);
        assertEquals(ford.getSpeed(),70);
        assertThrows(IllegalArgumentException.class, () -> new Ford(-1,2,2));
        assertThrows(IllegalArgumentException.class, () -> new Ford(1,-100,2));
        assertThrows(IllegalArgumentException.class, () -> new Ford(1,2,-1));
        assertThrows(IllegalArgumentException.class, () -> new Car(1,2,-1));
        ford.accelerate(1);
        assertEquals(ford.getSpeed(),71);
        ford.brake(1);
        assertEquals(ford.getSpeed(),70);
        assertEquals(car.toString(),"Car [mileage=29, gear=2, speed=90]");
        Vehicle vehicle = new Vehicle(9,9);
        assertEquals(vehicle.toString(),"Vehicle [gear=9, speed=9]");


    }
}