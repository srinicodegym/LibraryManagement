package model;


import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Library {
    private Map<Integer,Book> books;

    public Library() {
        this.books = new HashMap<>();
    }

    public void addBook(Book book) {
        books.put(book.getId(),book);
    }

    public void removeBook(Book book) {
        books.remove(book.getId());
    }

    // write down diff methods to allow your lib system to seach by author, title ,id book page
    // serach top 10 most book read in last 6 month
    public List<Book> searchBooks(String title) {
        List<Book> results = new ArrayList<>();

        for (Book book : books.values()) {
            if (book.getTitle().toLowerCase().contains(title.toLowerCase())) { // improve code here to
                results.add(book);
            }
        }

        return results;
    }

    public boolean lendBook(int id) {

        Book book = books.get(id);
        if (book.isAvailable()) {
            book.setAvailable(false);
            System.out.println("Book with ID " + book.getId() + " has been lent.");
            return true;
        } else {
            System.out.println("Book with ID " + book.getId() + " is not available.");
            return false;
        }
    }

 //   improve ur code here
    public boolean returnBook(Integer id) {
        Book book = books.get(id);
        if (!book.isAvailable()) {
            book.setAvailable(true);
            System.out.println("Book with ID " + book.getId() + " has been returned.");
        } else {
            System.out.println("Book with ID " + book.getId() + " has already been returned.");
        }
        return true;
    }

    public void printBooks() {
        for (Book book : books.values()) {
            //improve code this as well
            System.out.println("ID: " + book.getId() + ", Title: " + book.getTitle() + ", Author: " + book.getAuthor() + ", Available: " + book.isAvailable());
        }
    }

    // you need to develop penalty funtion
    // auto renewable
}
