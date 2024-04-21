/**
 * A java programme to demonstrate Single Responsibiliy Principle
 * @author Noor Haider Khan; Student ID: 220218
 * @version 1.0
 * @since 21-04-2024 
 */
import java.util.ArrayList;
import java.util.List;

/**
 * Represents a book in the library.
 */
class Book {
    private String title;
    private String author;
    private int yearPublished;

    /**
     * Contructs a new Book object with the given title, author, and year published.
     * @param title The title of the book.
     * @param author The author of the book.
     * @param yearPublished The year the book was published.
     */
    public Book(String title, String author, int yearPublished) {
        this.title = title;
        this.author = author;
        this.yearPublished = yearPublished;
    }

    /**
     * Retrieves the title of the book.
     * @return The title of the book.
     */
    public String getTitle() {
        return title;
    }

    /**
     * Retrieves the author of the book.
     * @return The author of the book.
     */
    public String getAuthor() {
        return author;
    }

    /**
     * Retrieves the year the book was published.
     * @return The year the book was published.
     */
    public int getYearPublished() {
        return yearPublished;
    }
}

/**
 * Manages the books in the library.
 */
class Library {
    private List<Book> books;

    /**
     * Constructs a new Library object.
     */
    public Library() {
        this.books = new ArrayList<>();
    }

    /**
     * Adds a book to the library.
     * @param book The book to add.
     */
    public void addBook(Book book) {
        books.add(book);
    }

    /**
     * Retrieves the list of books in the library.
     * @return The list of books in the library.
     */
    public List<Book> getBooks() {
        return books;
    }
}

/**
 * Prints the details of books in the library.
 */
class LibraryPrinter {
    /**
     * Prints the details of books in the library.
     * @param library The library to print books from.
     */
    public void printBooks(Library library) {
        System.out.println("Library Books:");
        for (Book book : library.getBooks()) {
            System.out.println("Title: " + book.getTitle());
            System.out.println("Author: " + book.getAuthor());
            System.out.println("Year Published: " + book.getYearPublished());
            System.out.println();
        }
    }
}

/**
 * Demonstrates the usage of Library and LibraryPrinter classes.
 */
public class LibraryDemo {
    public static void main(String[] args) {
        // Create a library
        Library library = new Library();

        // Add books to the library
        library.addBook(new Book("C Programming",  "Denis Richie", 1983));
        library.addBook(new Book("Java Programming", "John Doe", 2019));
        library.addBook(new Book("Himu", "Humayun Ahmed", 1993));
        

        // Print library books using LibraryPrinter
        LibraryPrinter printer = new LibraryPrinter();
        printer.printBooks(library);
    }
}
