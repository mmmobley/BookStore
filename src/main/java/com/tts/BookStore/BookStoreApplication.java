package com.tts.BookStore;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import com.tts.BookStore.Models.Book;
import com.tts.BookStore.Repositories.BookRepository;

@SpringBootApplication
public class BookStoreApplication {

	public static void main(String[] args) {
		SpringApplication.run(BookStoreApplication.class, args);
	}
	
	@Bean
	CommandLineRunner runner(BookRepository bookRepository) {
		return args -> {
			bookRepository.save(new Book(4, (float) 8.00, "A tale about a young boy wizard.", "Harry Potter and the Socerer's Stone", "JK Rowling", "Young Adult", "images/hp1.jpg"));
            bookRepository.save(new Book(3, (float) 8.00, "The sixth book in the popular series.", "Harry Potter and the Half Blood Prince", "JK Rowling", "Young Adult", "images/hp6.jpg"));
            bookRepository.save(new Book(6, (float) 5.00, "Love and heartbreak set during the Civil War.", "Gone With the Wind", "Margaret Mitchell", "Romance", "images/gw.jpg"));
            bookRepository.save(new Book(5, (float) 10.00, "A collection of essays detailing Mindy Kaling's adult life.", "Why Not Me?", "Mindy Kaling", "Nonfiction", "images/wnm.jpg"));
            bookRepository.save(new Book(6, (float) 5.00, "#1 New York Times Bestseller.", "Becoming", "Michelle Obama", "Nonfiction", "images/becoming-53.jpg"));
           	
            bookRepository.save(new Book(5, (float) 10.00, "Winner of The Newberry Honor.", "Charlotte’s Web", "E.B. White", "Children", "images/charlotte-s-web-2.jpg"));
            bookRepository.save(new Book(5, (float) 20.00, "#1 New York Times Bestseller.", "Wonder", "MR.J. Palacio", "Young Adult", "images/wonder-4.jpg"));
            bookRepository.save(new Book(6, (float) 25.00, "A children’s book classic.", "The Very Hungry Caterpillar", "Eric Carle", "Children", "images/the-very-hungry-caterpillar-1.jpg"));
           	
            bookRepository.save(new Book(5, (float) 10.00, "The Private Life of a Public Woman.", "Jane Fonda", "Patricia Bosworth", "Nonfiction", "images/jane-fonda-2.jpg"));
            bookRepository.save(new Book(6, (float) 5.00, "Interesting approach to adolescent psychology.", "When You Ask Me Where I’m Going", "Jasmine Kaur", "Young Adult", "images/when-you-ask-me-where-i-m-going.jpg"));
           	
            bookRepository.save(new Book(5, (float) 10.00, "A musical masterpiece of the twenty first century", "Hamilton", "Lin Manuel Miranda", "Nonfiction", "images/Hamilton.jpg"));
            bookRepository.save(new Book(6, (float) 5.00, "The Interesting History of Sesame Street", "Jim Henson", "Brian Jay Jones", "Nonfiction", "images/jim-henson.jpg"));
           	
            bookRepository.save(new Book(5, (float) 10.00, "A classic tale.", "Cinderella", "Disney", "Children", "images/Ciderella.jpg"));
            bookRepository.save(new Book(6, (float) 5.00, "Twilight Saga.", "Midnight Sun", "Stephenie Meyer", "Young Adult", "images/midnight-sun-44.jpg"));
           	
            bookRepository.save(new Book(5, (float) 10.00, "Author of the Wicked Deep", "Winterwood", "Shea Ernshaw", "Young Adult", "images/winterwood-8.jpg"));          
            
            bookRepository.findAll().forEach(System.out::println);
		};
	}
	 	
}
