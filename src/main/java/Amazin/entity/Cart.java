package Amazin.entity;

import javax.persistence.Entity;
import java.util.*;

public class Cart {
    Hashtable<String, Book> cart=new Hashtable<String, Book>();


    public void Cart(){

     }

     public void addToCart(Book book){
        cart.put(book.getName(), book);
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


     public String toString(){
         String printout= "";
         //List<Book> iterateCart = (List<Book>) cart.values();
         for (Book b : cart.values()) {
             printout = printout +  b.getName() + " \n";
         }

         return printout;

     }


}

