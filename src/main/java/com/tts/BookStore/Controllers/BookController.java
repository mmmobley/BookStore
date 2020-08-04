package com.tts.BookStore.Controllers;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

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
}

