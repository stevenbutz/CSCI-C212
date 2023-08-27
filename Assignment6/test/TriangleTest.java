import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class TriangleTest {

    @Test
    void printShape() {
        Triangle triangle = new Triangle(1);
        assertEquals(triangle.printShape(),"*\n");
        Triangle triangle2 = new Triangle(3);
        assertEquals(triangle2.printShape(),"*\n**\n***\n");
        Triangle triangle3 = new Triangle(8);
        assertEquals(triangle3.printShape(),"*\n**\n***\n****\n*****\n******\n*******\n********\n");
        assertThrows(IllegalArgumentException.class, () -> {
            new Triangle(-1);
        });
    }
}