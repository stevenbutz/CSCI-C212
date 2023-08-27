import java.io.*;
import java.util.*;

public class Library implements LibraryManagementSystem {
    private List<FictionBook> fictionBooks;
    private HashMap<String, Integer> inventory;
    private List<NonfictionBook> nonfictionBooks;
    private List<Student> students;

    public Library(String inventoryPath) {
        fictionBooks = new ArrayList<>();
        nonfictionBooks = new ArrayList<>();
        students = new ArrayList<>();
        inventory = new HashMap<>();
        inventory(inventoryPath);
    }

    public int[] availableBooks() {
        int[] stats = new int[2];
        stats[0] = fictionBooks.stream().mapToInt(book -> inventory.get(book.getIsbn())).sum();
        stats[1] = nonfictionBooks.stream().mapToInt(book -> inventory.get(book.getIsbn())).sum();
        return stats;
    }

    public List<FictionBook> getFictionBooks() {
        return fictionBooks;
    }

    public HashMap<String, Integer> getInventory() {
        return inventory;
    }

    public List<NonfictionBook> getNonfictionBooks() {
        return nonfictionBooks;
    }

    public List<Student> getStudents() {
        return students;
    }

    @Override
    public void lend(String isbn) {
        if (!inventory.containsKey(isbn) || inventory.get(isbn) == 0) {
            throw new RuntimeException("Book is not available for lending.");
        }
        inventory.put(isbn, inventory.get(isbn) - 1);
    }

    @Override
    public void putBack(String isbn) {
        if (!inventory.containsKey(isbn)) {
            throw new RuntimeException("Book not found in the inventory.");
        }
        inventory.put(isbn, inventory.get(isbn) + 1);
    }

    @Override
    public void inventory(String filePath) {
        try (BufferedReader reader = new BufferedReader(new FileReader(filePath))) {
            // Read and ignore the first line (header)
            reader.readLine();

            String line;
            while ((line = reader.readLine()) != null) {
                String[] parts = line.split(",");
                String isbn = parts[0];
                String name = parts[1];
                String author = parts[2];
                int pages = Integer.parseInt(parts[3]);
                int quantity = Integer.parseInt(parts[4]);
                boolean isFiction = parts[5].equalsIgnoreCase("fiction");

                if (isFiction) {
                    FictionBook book = new FictionBook(isbn, name, author, pages);
                    fictionBooks.add(book);
                } else {
                    NonfictionBook book = new NonfictionBook(isbn, name, author, pages);
                    nonfictionBooks.add(book);
                }
                inventory.put(isbn, quantity);
            }
        } catch (IOException e) {
            throw new RuntimeException("Error reading inventory file: " + e.getMessage());
        }
    }

    @Override
    public void registerStudent(Student student) {
        for (Student s : students) {
            if (s.getRegistrationNumber().equals(student.getRegistrationNumber())) {
                throw new RuntimeException("Student is already registered.");
            }
        }
        students.add(student);
    }

    @Override
    public Book search(String isbn) {
        for (FictionBook book : fictionBooks) {
            if (book.getIsbn().equals(isbn)) {
                return book;
            }
        }
        for (NonfictionBook book : nonfictionBooks) {
            if (book.getIsbn().equals(isbn)) {
                return book;
            }
        }
        throw new RuntimeException("Book not found.");
    }

    public void setFictionBooks(List<FictionBook> fictionBooks) {
        this.fictionBooks = fictionBooks;
    }

    public void setInventory(HashMap<String, Integer> inventory) {
        this.inventory = inventory;
    }

    public void setNonfictionBooks(List<NonfictionBook> nonfictionBooks) {
        this.nonfictionBooks = nonfictionBooks;
    }

    public void setStudents(List<Student> students) {
        this.students = students;
    }

    @Override
    public List<Book> sort(int mode) {
        List<Book> sortedBooks = new ArrayList<>();
        sortedBooks.addAll(fictionBooks);
        sortedBooks.addAll(nonfictionBooks);

        switch (mode) {
            case 1: // Sort by ISBN
                sortedBooks.sort(Comparator.comparing(Book::getIsbn));
                break;
            case 2: // Sort by Quantity
                sortedBooks.sort(Comparator.comparing(book -> inventory.get(book.getIsbn())));
                break;
            default:
                throw new IllegalArgumentException("Invalid sorting mode.");
        }

        return sortedBooks;
    }
}
