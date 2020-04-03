package com.app.entity;

import static org.junit.jupiter.api.Assertions.*;
public class BookTest

{
    Book book;

    @org.junit.jupiter.api.BeforeEach
    void setUp() {
        this.book= new Book("Hello World", "Fairy Tale", "222", "picture", "Rayhaan", "Ray",3, 50.00);
    }

    @org.junit.jupiter.api.AfterEach
    void tearDown() {
    }

    //@org.junit.jupiter.api.Test

   /* void getId(){    assertEquals(this.book.getId(),"1"); } */

    @org.junit.jupiter.api.Test

    void setId(){
        book.setId(2);
        assertEquals(this.book.getId(),2);
    }
    @org.junit.jupiter.api.Test
    void getName(){

        assertEquals(this.book.getName(),"Hello World");
    }
    @org.junit.jupiter.api.Test
    void setName(){
        book.setName("Meet");
        assertEquals(this.book.getName(),"Meet");
    }
    @org.junit.jupiter.api.Test
    void getDescription(){
        assertEquals(this.book.getDescription(),"Fairy Tale");
    }
    @org.junit.jupiter.api.Test
    void setDescription(){
        book.setDescription("Adityo");
        assertEquals(this.book.getDescription(),"Adityo");
    }
    @org.junit.jupiter.api.Test
    void getAuthor(){
        assertEquals(this.book.getAuthor(),"Rayhaan");
    }
    @org.junit.jupiter.api.Test
    void setAuthor(){
        book.setAuthor("Kyle");
        assertEquals(this.book.getAuthor(),"Kyle");
    }
}
