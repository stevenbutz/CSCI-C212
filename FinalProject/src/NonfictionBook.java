public class NonfictionBook extends Book {
    public NonfictionBook(String isbn, String name, String author, int pages) {
        super(isbn, name, author, pages);
    }

    @Override
    public String toString() {
        return "NonfictionBook{" +
                "isbn='" + isbn + '\'' +
                ", name='" + name + '\'' +
                ", author='" + author + '\'' +
                ", pages=" + pages +
                '}';
    }
}
