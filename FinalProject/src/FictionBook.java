public class FictionBook extends Book {
    public FictionBook(String isbn, String name, String author, int pages) {
        super(isbn, name, author, pages);
    }

    @Override
    public String toString() {
        return "FictionBook{" +
                "isbn='" + isbn + '\'' +
                ", name='" + name + '\'' +
                ", author='" + author + '\'' +
                ", pages=" + pages +
                '}';
    }
}
