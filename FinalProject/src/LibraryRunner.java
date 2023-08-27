import java.io.*;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
import java.io.FileWriter;
import java.util.ArrayList;
import java.util.UUID;



public class LibraryRunner {
    private static final String BORROWED_BOOKS_FILE = "borrowed_books.txt";

    public static void main(String[] args) {
        Library library = new Library("inventory.txt");
        HashMap<String, List<String>> borrowedBooks = readFile(BORROWED_BOOKS_FILE);

        while (true) {
            printMenu();
            Scanner scanner = new Scanner(System.in);
            int option = scanner.nextInt();
            handleOption(option, library, borrowedBooks);
        }
    }

    private static void printMenu() {
        System.out.println("Please choose an option:");
        System.out.println("1. Register");
        System.out.println("2. Sort Books");
        System.out.println("3. Search Books");
        System.out.println("4. Borrow Book");
        System.out.println("5. Return Book");
        System.out.println("6. Show Inventory Stats");
        System.out.println("7. Exit");
    }

    private static void handleOption(int option, Library library, HashMap<String, List<String>> borrowedBooks) {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        Scanner scanner = new Scanner(System.in);

        try {
            switch (option) {
                case 1: {
                    System.out.print("Enter the name of the student: ");
                    String name = reader.readLine();
                    // Use registration number as a unique identifier for the student
                    String regNumber = UUID.randomUUID().toString();
                    Student student = new Student(name, regNumber);
                    library.registerStudent(student);
                    System.out.println("Student registered successfully with registration number: " + regNumber);
                    break;
                }
                case 2: {
                    System.out.println("Sort books by:");
                    System.out.println("1. ISBN");
                    int mode = scanner.nextInt();
                    library.sort(mode).forEach(System.out::println);
                    break;
                }
                case 3: {
                    System.out.print("Enter the ISBN: ");
                    String isbn = reader.readLine();
                    Book book = library.search(isbn);
                    System.out.println(book);
                    break;
                }
                case 4: {
                    System.out.print("Enter the student registration number: ");
                    String regNumber = reader.readLine();
                    System.out.print("Enter the ISBN of the book: ");
                    String isbn = reader.readLine();
                    library.lend(isbn);
                    borrowedBooks.computeIfAbsent(regNumber, k -> new ArrayList<>()).add(isbn);
                    writeFile(BORROWED_BOOKS_FILE, borrowedBooks);
                    System.out.println("Book borrowed successfully.");
                    break;
                }
                case 5: {
                    System.out.print("Enter the student registration number: ");
                    String regNumber = reader.readLine();
                    List<String> borrowedIsbns = borrowedBooks.get(regNumber);
                    System.out.println("Borrowed books:");
                    for (String isbn : borrowedIsbns) {
                        System.out.println(library.search(isbn));
                    }
                    System.out.print("Enter the ISBN of the book to return: ");
                    String isbn = reader.readLine();
                    library.putBack(isbn);
                    borrowedBooks.get(regNumber).remove(isbn);
                    writeFile(BORROWED_BOOKS_FILE, borrowedBooks);
                    System.out.println("Book returned successfully.");
                    break;
                }
                case 6: {
                    int[] stats = library.availableBooks();
                    InventoryChart chart = new InventoryChart("Inventory Stats", stats);
                    chart.displayGraph();
                    break;
                }
                case 7: {
                    System.exit(0);
                }
                default: {
                    System.out.println("Invalid option, please choose again.");
                }
            }
        } catch (IOException e) {
            System.out.println("Error reading input: " + e.getMessage());
            handleOption(option, library, borrowedBooks);
        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
            handleOption(option, library, borrowedBooks);
        }
    }

    private static HashMap<String, List<String>> readFile(String filePath) {
        HashMap<String, List<String>> borrowedBooks = new HashMap<>();

        try (BufferedReader bufferedReader = new BufferedReader(new FileReader(filePath))) {

            String line;
            while ((line = bufferedReader.readLine()) != null) {
                String[] parts = line.split(",");
                String regNumber = parts[0];
                String isbn = parts[1];

                borrowedBooks.computeIfAbsent(regNumber, k -> new ArrayList<>()).add(isbn);
            }
        } catch (IOException e) {
            System.out.println("Error reading borrowed books file: " + e.getMessage());
        }

        return borrowedBooks;
    }

    private static void writeFile(String filePath, HashMap<String, List<String>> borrowedBooks) {
        try (BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(filePath))) {
            for (Map.Entry<String, List<String>> entry : borrowedBooks.entrySet()) {
                String regNumber = entry.getKey();
                List<String> isbns = entry.getValue();

                for (String isbn : isbns) {
                    bufferedWriter.write(regNumber + "," + isbn);
                    bufferedWriter.newLine();
                }
            }
        } catch (IOException e) {
            System.out.println("Error writing borrowed books file: " + e.getMessage());
        }
    }
}

