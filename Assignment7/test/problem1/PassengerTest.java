package problem1;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
class PassengerTest {

    @Test
    void getName() {
        Passenger passenger = new Passenger("Markus",25);
        assertEquals(passenger.getName(),"Markus");
        assertThrows(IllegalArgumentException.class, () -> new Passenger(null, 25));
    }

    @Test
    void getAge() {
        Passenger passenger = new Passenger("Markus",25);
        assertEquals(passenger.getAge(),25);
        assertThrows(IllegalArgumentException.class, () -> new Passenger("mark", -100));
    }
    @Test
    void setAge() {
        Passenger passenger = new Passenger("Markus",25);
        passenger.setAge(26);
        assertEquals(passenger.getAge(),26);
        assertThrows(IllegalArgumentException.class, () -> passenger.setAge(-1));

    }

    @Test
    void getDetails() {
        Passenger passenger = new Passenger("Markus",25);
        assertEquals(passenger.getDetails(),"Passenger name: Markus\nPassenger age: 25");
    }
}