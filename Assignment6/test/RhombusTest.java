import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class RhombusTest {

    @Test
    void printShape() {
        Rhombus rhombus = new Rhombus(1);
        assertEquals(rhombus.printShape(),"*\n");
        Rhombus rhombus2 = new Rhombus(3);
        assertEquals(rhombus2.printShape()," * \n***\n * \n");
        Rhombus rhombus3 = new Rhombus(7);//constructor3
        assertEquals(rhombus3.printShape(),"   *   \n  ***  \n ***** \n*******\n ***** \n  ***  \n   *   \n");
        assertThrows(IllegalArgumentException.class, () -> {
            new Rhombus(-1);
        });
        assertThrows(IllegalArgumentException.class, () -> {
            new Rhombus(4);
        });
    }
}