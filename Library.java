import java.util.*;

public class Library {
    private List<Book> books = new ArrayList<>();

    public void addBook(Book book) {
        books.add(book);
        System.out.println("Book added successfully.\n");
    }

    public void viewBooks() {
        if (books.isEmpty()) {
            System.out.println("No books in the library.\n");
            return;
        }
        System.out.println("ID | Title | Author | Status");
        for (Book book : books) {
            System.out.println(book);
        }
        System.out.println();
    }

    public void searchBook(String title) {
        boolean found = false;
        for (Book book : books) {
            if (book.getTitle().equalsIgnoreCase(title)) {
                System.out.println(book + "\n");
                found = true;
            }
        }
        if (!found) {
            System.out.println("Book not found.\n");
        }
    }

    public void issueBook(int id) {
        for (Book book : books) {
            if (book.getId() == id && !book.isIssued()) {
                book.issue();
                System.out.println("Book issued successfully.\n");
                return;
            }
        }
        System.out.println("Book not found or already issued.\n");
    }

    public void returnBook(int id) {
        for (Book book : books) {
            if (book.getId() == id && book.isIssued()) {
                book.returnBook();
                System.out.println("Book returned successfully.\n");
                return;
            }
        }
        System.out.println("Book not found or not issued.\n");
    }
}
