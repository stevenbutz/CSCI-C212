import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class RectangleTest {

    @Test
    void printShape() {
        Rectangle rectangle = new Rectangle(1,1);
        assertEquals(rectangle.printShape(),"*\n");
        Rectangle rectangle2 = new Rectangle(2,3);
        assertEquals(rectangle2.printShape(),"**\n**\n**\n");
        Rectangle rectangle3 = new Rectangle(2,8);
        assertEquals(rectangle3.printShape(),"**\n**\n**\n**\n**\n**\n**\n**\n");
        assertThrows(IllegalArgumentException.class, () -> {
            new Rectangle(-1, -1);
        });
    }
}