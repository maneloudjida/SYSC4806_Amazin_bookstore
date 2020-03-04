package Amazin.entity;

import javax.persistence.Entity;
import java.util.*;

public class Cart {
    Hashtable<Integer, Book> cart=new Hashtable<Integer, Book>();


    public void Cart(){

     }

     public void addToCart(Book book){
        cart.put(book.getId(), book);
     }

     public void removeFromCart(String bookName){
        cart.remove(bookName);
     }

     public boolean isEmpty(){
        return cart.isEmpty();
     }

     public double getTotal() {
         double runTotal = 0;
         List<Book> iterCart = (List<Book>) cart.values();
         for (Book b : iterCart) {
             runTotal += b.getCost();
         }
         return runTotal;
     }

     public static void main(String[] args){
         Cart cart = new Cart();
         Book b1 = new Book("face", "This book is faceless", "ISBN","picture","Nnamdi","Nnamdi",1,500.00);
         Book b2 = new Book("faceful", "This book is faceful", "ISBN","picture","Nnamdi","Nnamdi",1,550.00);
         Book b3 = new Book("faceless",  "This book is faceless", "ISBN","picture","Nnamdi","Nnamdi",1,500.50);
         Book b4 = new Book("facing",  "This book is facing", "ISBN","picture","Nnamdi","Nnamdi",1,600.50);
         cart.addToCart(b1);
         cart.addToCart(b2);
         cart.addToCart(b3);
         cart.addToCart(b4);

     }


}

