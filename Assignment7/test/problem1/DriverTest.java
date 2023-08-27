package problem1;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class DriverTest {

    @Test
    void getDetails() {
        Driver driver = new Driver("Markus",25);
        assertEquals(driver.getDetails(),"Driver name: Markus\nDriver age: 25\nDriver is licensed: true");
        driver.setAge(22);
        assertEquals(driver.getAge(),22);
        assertTrue(driver.isLicensed());
        assertEquals(driver.getName(),"Markus");
        Driver driver2 = new Driver("mary",10);
        assertFalse(driver2.isLicensed());
        assertThrows(IllegalArgumentException.class, () -> driver.setAge(-1));
        assertThrows(IllegalArgumentException.class, () -> new Driver(null, 25));
    }
}