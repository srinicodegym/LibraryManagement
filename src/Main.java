
import model.Book;
import model.Library;

import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Library library = new Library();

        Book book1 = new Book(1, "The Great Gatsby", "F. Scott Fitzgerald", true);
        Book book2 = new Book(2, "To Kill a Mockingbird", "Harper Lee", true);
        Book book3 = new Book(3, "1984", "George Orwell", true);

        library.addBook(book1);
        library.addBook(book2);
        library.addBook(book3);



        while (true) {
            Scanner scanner = new Scanner(System.in);
            System.out.println("\nLibrary Management System");
            System.out.println("1. Search books");
            System.out.println("2. Lend book");
            System.out.println("3. Return book");
            System.out.println("4. Print all books");
            System.out.println("5. Exit");

            int choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    System.out.println("\nEnter the title to search for:");
                    String title = scanner.next();
                    List<Book> results = library.searchBooks(title);

                    if (results.isEmpty()) {
                        System.out.println("No books found.");
                    } else {
                        System.out.println(results.size() + " books found.");
                        for (Book book : results) {
                            System.out.println(book.getAuthor());// improve code here
                        }
                    }
                    break;

                case 2:
                    System.out.println("\nEnter the the id the book to lend:");
                    int id = scanner.nextInt();

                    if (library.lendBook(id)) {
                        System.out.println("Book with id " + id + " has been successfully borrowed.");

                    } else {
                        System.out.println("Book with id " + id + " is not available for borrowing.");
                    }
                    break;

                case 3:
                    System.out.println("\nEnter the id of the book to return:");
                    int returnId = scanner.nextInt();

                    if (library.returnBook(returnId)) {
                        System.out.println("Book with id " + returnId + " has been successfully returned.");
                    } else {
                        System.out.println("Book with id " + returnId + " is not a valid book id.");
                    }
                    break;

                case 4:
                     library.printBooks();

                    break;

                case 5:
                    System.out.println("Exiting library management system. Goodbye!");
                    System.exit(0);
                    break;

                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }
    }
}

