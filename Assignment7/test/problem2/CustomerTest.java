package problem2;

import org.junit.jupiter.api.Test;
import problem1.Driver;

import static org.junit.jupiter.api.Assertions.*;

class CustomerTest {

    @Test
    void mailCheck() {
        Customer customer = new Customer("Jon","1 Lane",23);
        customer.mailCheck();
        assertThrows(IllegalArgumentException.class, () -> customer.setNumber(-1));
        assertThrows(IllegalArgumentException.class, () -> customer.setName(null));
        assertThrows(IllegalArgumentException.class, () -> customer.setAddress(null));
        assertThrows(IllegalArgumentException.class, () -> new Customer(null, null,-1));
    }
}