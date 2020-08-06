package com.tts.BookStore.Controllers;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestParam;

import com.tts.BookStore.Models.Book;
import com.tts.BookStore.Services.BookService;


@Controller
@ControllerAdvice // This makes the `@ModelAttribute`s of this controller available to all controllers, for the navbar.
public class MainController {
    @Autowired
    BookService bookService;
    
    //public Product(int quantity, float price, String description, 
    //String name, String brand, String category,String image) {
    
    
//   public void addNew() {
//    	 	List<Book> newBooks = new ArrayList<Book>(); 
// 		
////     	newBooks.add(new Book(4, (float) 8.00, "A tale about a young boy wizard.", "Harry Potter and the Socerer's Stone", "JK Rowling", "young adult", "images/apple_mlh32ll_a_15_4_macbook_pro_with_1293726.jpg")); 
////    	
////     	newBooks.add(new Book(3, (float) 8.00, "The sixth book in the popular series.", "Harry Potter and the Half Blood Prince", "JK Rowling", "young adult", "images/C7_ST_Desktop_Front.jpg"));
////     
////     	newBooks.add(new Book(6, (float) 5.00, "Love and heartbreak set during the Civil War.", "Gone With the Wind", "Margaret Mitchell", "romance", "images/iphone8-silver-select-2017.jpg"));
////     	
////     	newBooks.add(new Book(5, (float) 10.00, "A collection of essays detailing Mindy Kaling's adult life.", "Why Not Me?", "Mindy Kaling", "nonfiction", "images/iphonexfrontback-800x573.jpg"));
//     	
//     	List<Book> old = bookService.findAll(); 
//     	for (Book Book : old) {
//     		bookService.deleteById(Book.getId());
//     	}
//     	
//     	for(Book book : newBooks) {
//     		bookService.save(book);
//     	}
//     	
//    }
 
   
    		
    @GetMapping("/")
    public String main() {
//    		addNew(); 
        return "main";
    }
    
    @GetMapping("/result")
    public String result() { 
        return "result";
    }
    
    
    @GetMapping("/list")
    public String showlist() {
    	return "list";
    }

    @ModelAttribute("books")
    public List<Book> books() {
        return bookService.findAll();
    }

    @ModelAttribute("genres")
    public List<String> genres() {
        return bookService.findDistinctGenres();
    }

    @ModelAttribute("authors")
    public List<String> authors() {
        return bookService.findDistinctAuthors();
    }

    @GetMapping("/filter")
    public String filter(@RequestParam(required = false) String genre,
                         @RequestParam(required = false) String author,
                         Model model) {
        List<Book> filtered = bookService.findByAuthorAndOrGenre(author, genre);
        model.addAttribute("books", filtered); // Overrides the @ModelAttribute above.
        return "list";
    }

    @GetMapping("/about")
    public String about() {
        return "about";
    }
}

