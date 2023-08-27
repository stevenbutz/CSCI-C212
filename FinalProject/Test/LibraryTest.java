import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.HashMap;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class LibraryTest {
    private Library library;

    @BeforeEach
    void setUp() {
        library = new Library("inventory.txt");
    }

    @Test
    void testLend() {
        String isbn = "78350"; // Replace with a valid ISBN from the inventory
        HashMap<String, Integer> inventoryBefore = new HashMap<>(library.getInventory());
        library.lend(isbn);
        assertEquals(inventoryBefore.get(isbn) - 1, library.getInventory().get(isbn));
    }

    @Test
    void testPutBack() {
        String isbn = "78350"; // Replace with a valid ISBN from the inventory
        HashMap<String, Integer> inventoryBefore = new HashMap<>(library.getInventory());
        library.putBack(isbn);
        assertEquals(inventoryBefore.get(isbn) + 1, library.getInventory().get(isbn));
    }

    @Test
    void testSearch() {
        String isbn = "78350"; // Replace with a valid ISBN from the inventory
        Book book = library.search(isbn);
        assertNotNull(book);
        assertEquals(isbn, book.getIsbn());
    }

    @Test
    void testRegisterStudent() {
        Student student = new Student("John Doe", "12345");
        library.registerStudent(student);
        assertTrue(library.getStudents().contains(student));
    }

    @Test
    void testAvailableBooks() {
        int[] stats = library.availableBooks();
        assertNotNull(stats);
        assertEquals(2, stats.length);
    }

    @Test
    void testSort() {
        List<Book> sortedBooks = library.sort(1); // Sort by ISBN
        assertNotNull(sortedBooks);
        for (int i = 1; i < sortedBooks.size(); i++) {
            assertTrue(sortedBooks.get(i - 1).getIsbn().compareTo(sortedBooks.get(i).getIsbn()) <= 0);
        }
    }
}
