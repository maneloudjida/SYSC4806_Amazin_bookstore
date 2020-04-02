package Amazin.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.util.*;
@Entity
public class Cart {
    @Id
    @GeneratedValue
    int id;
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

