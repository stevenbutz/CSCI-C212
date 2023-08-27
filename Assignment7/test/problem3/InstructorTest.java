package problem3;

import org.junit.jupiter.api.Test;
import problem2.Account;

import static org.junit.jupiter.api.Assertions.*;

class InstructorTest {

    @Test
    void getPerformance() {
        Instructor instructor = new Instructor("barry","Excellent");
        assertEquals(instructor.getPerformance(),5);
        instructor.setRating("Bad");
        assertEquals(instructor.getName(),"barry");
        assertEquals(instructor.getPerformance(),2);
        assertEquals(instructor.getRating(),"Bad");
        assertThrows(IllegalArgumentException.class, () -> new Instructor(null, "Worst"));
    }
}