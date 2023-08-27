package problem3;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class StudentTest {

    @Test
    void getPerformance() {
        Student student = new Student("barry","A+");
        assertEquals(student.getPerformance(),4);
        assertEquals(student.getName(),"barry");
        student.setGrade("B-");
        assertEquals(student.getPerformance(),2.7);
        assertEquals(student.getGrade(),"B-");
        assertThrows(IllegalArgumentException.class, () -> new Student(null, "A+"));
    }
}