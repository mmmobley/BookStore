package com.tts.BookStore.Controllers;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.tts.BookStore.Models.Book;
import com.tts.BookStore.Services.BookService;


@Controller
public class BookController {
    @Autowired
    BookService bookService;

    @GetMapping("/book/{id}")
    public String show(@PathVariable int id, Model model) {
        Book book = bookService.findById(id);
        System.out.println(book); 
        model.addAttribute(book);
        return "product";
    }

    // TODO: Either implement admin controls or remove these methods.

    @RequestMapping(value = "/book", method = {RequestMethod.POST, RequestMethod.PUT})
    public String createOrUpdate(@Valid Book book) {
        bookService.save(book);
        return "redirect:/book/" + book.getId();
    }
    
    @RequestMapping("/booklist")
    public String viewBookList(Model model) {
        List<Book> listBooks = bookService.findAll();
        model.addAttribute("listBooks", listBooks);
         
        return "booklist";
    }
    
    @RequestMapping("/newbook")
    public String showNewBookPage(Model model) {
        Book book = new Book();
        model.addAttribute("book", book);
         
        return "newbook";
    }
    
    @RequestMapping(value = "/save", method = RequestMethod.POST)
    public String saveBook(@ModelAttribute("book") Book book) {
        bookService.save(book);
         
        return "redirect:/booklist";
    }
    
    @RequestMapping("/edit/{id}")
    public ModelAndView showEditBookPage(@PathVariable(name = "id") long id) {
        ModelAndView mav = new ModelAndView("editbook");
        Book book = bookService.findById(id);
        mav.addObject("book", book);
         
        return mav;
    }
    
    @RequestMapping("/delete/{id}")
    public String deleteProduct(@PathVariable(name = "id") long id) {
        bookService.deleteById(id);
        return "redirect:/";       
    }
}

