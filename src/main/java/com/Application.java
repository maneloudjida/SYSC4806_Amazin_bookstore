package com;

import com.app.entity.Book;
import com.app.entity.Role;
import com.app.entity.User;
import com.app.repository.BookRepository;
import com.app.repository.UserRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class Application {


    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
        // launch browser on localhost
    }

    @Bean
    public CommandLineRunner demo(UserRepository users, BookRepository books) {
        return (args) -> {
            // save a few customers
            User Owner = new User("Kyle","Smith","fake@fake.com","123456", Role.ROLE_BOOKSTOREOWNER);
            User Customer = new User("Rayhaan","Dustagheer","Raymaan@fake.com","123456", Role.ROLE_CUSTOMER);

            users.save(Owner);
            users.save(Customer);

            //save a few books
            Book memeBook = new Book("The Library Book","A book about memes","11100010011","https://images-na.ssl-images-amazon.com/images/I/51pmJwGu0bL._SX340_BO1,204,203,200_.jpg","Kyle","Rayhaan",1,50,"Mystery");
            Book b1 = new Book("face", "This book is faceless", "ISBN","picture","Nnamdi","Nnamdi",1,500.00,"Fiction");
            Book b2 = new Book("faceful", "This book is faceful", "ISBN","picture","Nnamdi","Nnamdi",1,550.00,"Fiction");
            Book b3 = new Book("faceless",  "This book is faceless", "ISBN","picture","Nnamdi","Nnamdi",1,500.50, "Fantasy");
            Book b4 = new Book("facing",  "This book is facing", "ISBN","picture","Nnamdi","Nnamdi",1,600.50,"Romantic");

            books.save(memeBook);
            books.save(b1);
            books.save(b2);
            books.save(b3);
            books.save(b4);

            User demo = new User("Demo","Smith","demo@fake.com","123456", Role.ROLE_CUSTOMER);

        };
    }

}
