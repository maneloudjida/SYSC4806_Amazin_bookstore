package entity;

import entity.Book;

import java.util.ArrayList;
import java.util.List;

public class BookStoreOwner extends User{


    private List<Book> books;


    public BookStoreOwner(Long iD, String userId, String fname, String lname, String email, String password, String passconfirm, Role role) {
        super(iD, userId, fname, lname, email, password, passconfirm, role);
        this.books = new ArrayList<>();
        this.setRole(Role.ROLE_BOOKSTOREOWNER);
    }

    public List<Book> getBooks() {
        return books;
    }

    public void setBooks(List<Book> books) {
        this.books = books;
    }

    public void addBooks(Book book) {
        this.books.add(book);
    }

    public boolean removeBooks(Book book) {
        return books.remove(book);
    }



}
