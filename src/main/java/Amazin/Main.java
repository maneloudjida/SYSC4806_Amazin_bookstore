package Amazin;

import Amazin.entity.Role;
import Amazin.repository.BookRepository;
import Amazin.repository.UserRepository;
import Amazin.entity.User;
import Amazin.entity.Book;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Bean;


@SpringBootApplication
public class Main {

	private static final Logger log = LoggerFactory.getLogger(Main.class);

	public static void main(String[] args) {
		SpringApplication.run(Main.class, args);
	}

	@Bean
	public CommandLineRunner demo(UserRepository users, BookRepository books) {
		return (args) -> {
			// save a few customers
			User Owner = new User("Kyle","Smith","fake@fake.com","123456", Role.ROLE_BOOKSTOREOWNER);
			User Customer = new User("Rayhaan","Dustagheer","Raymaan@fake.com","123456", Role.ROLE_CUSTOMER);

			users.save(Owner);
			users.save(Customer);

			Book memeBook = new Book("Memes","A book about memes","ISBN","picture","Kyle","Rayhaan",1,50);
			Book b1 = new Book("face", "This book is faceless", "ISBN","picture","Nnamdi","Nnamdi",1,500.00);
			Book b2 = new Book("faceful", "This book is faceful", "ISBN","picture","Nnamdi","Nnamdi",1,550.00);
			Book b3 = new Book("faceless",  "This book is faceless", "ISBN","picture","Nnamdi","Nnamdi",1,500.50);
			Book b4 = new Book("facing",  "This book is facing", "ISBN","picture","Nnamdi","Nnamdi",1,600.50);

			books.save(memeBook);
			books.save(b1);
			books.save(b2);
			books.save(b3);
			books.save(b4);



		};
	}

}

