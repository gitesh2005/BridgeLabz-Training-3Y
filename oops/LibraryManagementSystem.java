class Book {
    private String title;
    private String author;
    private final String isbn;

    public Book(String title, String author, String isbn) {
        this.title = title;
        this.author = author;
        this.isbn = isbn;
    }

    public void displayBook() {
        if (this instanceof Book) {
            System.out.println("Title: " + title);
            System.out.println("Author: " + author);
            System.out.println("ISBN: " + isbn);
        }
    }
}

class Library {
    private static int totalBooks = 0;
    private Book[] books;
    private int count;

    public Library(int size) {
        books = new Book[size];
        count = 0;
    }

    public void addBook(Book book) {
        if (count < books.length) {
            books[count++] = book;
            totalBooks++;
            System.out.println("Book added successfully!");
        } else {
            System.out.println("Library is full!");
        }
    }

    public void displayLibrary() {
        System.out.println("\n--- Library Collection ---");
        for (int i = 0; i < count; i++) {
            books[i].displayBook();
            System.out.println("----------------------");
        }
        System.out.println("Total Books in Library: " + totalBooks);
    }
}

public class LibraryManagementSystem {
    public static void main(String[] args) {
        Book b1 = new Book("Java Programming", "James Gosling", "ISBN001");
        Book b2 = new Book("Python Basics", "Guido van Rossum", "ISBN002");

        Library library = new Library(5);
        library.addBook(b1);
        library.addBook(b2);

        library.displayLibrary();
    }
}
