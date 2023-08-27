import java.util.List;

public interface LibraryManagementSystem {

    // Lends a book to a student
    void lend(String isbn);

    // Puts a book back into the library
    void putBack(String isbn);

    // Populates the inventory of the library from a file
    void inventory(String filePath);

    // Registers a student in the library system
    void registerStudent(Student student);

    // Searches for a book in the library by ISBN
    Book search(String isbn);

    // Sorts the books based on the given mode (e.g. by title, author, or publication date)
    List<Book> sort(int mode);
}