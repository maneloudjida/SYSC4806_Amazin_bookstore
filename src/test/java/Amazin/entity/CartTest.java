package Amazin.entity;

import static org.junit.jupiter.api.Assertions.*;

class CartTest {

    @org.junit.jupiter.api.BeforeEach
    void setUp() {
    }

    @org.junit.jupiter.api.AfterEach
    void tearDown() {
    }

    @org.junit.jupiter.api.Test
    void addToCart() {
        Cart cart = new Cart();
        Book b1 = new Book("face", "faceless", "This book is faceless", "ISBN","picture","Nnamdi","Nnamdi",1,500.00);
        Book b2 = new Book("faceful", "faceless", "This book is faceless", "ISBN","picture","Nnamdi","Nnamdi",1,550.00);
        Book b3 = new Book("faceless", "faceless", "This book is faceless", "ISBN","picture","Nnamdi","Nnamdi",1,500.50);
        Book b4 = new Book("facing", "faceless", "This book is faceless", "ISBN","picture","Nnamdi","Nnamdi",1,600.50);
        cart.addToCart(b1);
        cart.addToCart(b2);
        cart.addToCart(b3);
        cart.addToCart(b4);
        assertFalse(cart.isEmpty());

    }

    @org.junit.jupiter.api.Test
    void removeFromCart() {
    }

    @org.junit.jupiter.api.Test
    void isEmpty() {
    }

    @org.junit.jupiter.api.Test
    void getTotal() {
        Cart cart = new Cart();
        Book b1 = new Book("face", "faceless", "This book is faceless", "ISBN","picture","Nnamdi","Nnamdi",1,500.00);
        Book b2 = new Book("faceful", "faceless", "This book is faceless", "ISBN","picture","Nnamdi","Nnamdi",1,550.00);
        Book b3 = new Book("faceless", "faceless", "This book is faceless", "ISBN","picture","Nnamdi","Nnamdi",1,500.50);
        Book b4 = new Book("facing", "faceless", "This book is faceless", "ISBN","picture","Nnamdi","Nnamdi",1,600.50);
        cart.addToCart(b1);
        cart.addToCart(b2);
        cart.addToCart(b3);
        cart.addToCart(b4);
        //assertEquals(2151.00,cart.getTotal());

    }
}