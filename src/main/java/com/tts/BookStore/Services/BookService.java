package com.tts.BookStore.Services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tts.BookStore.Models.Book;
import com.tts.BookStore.Repositories.BookRepository;


@Service
public class BookService {
    @Autowired
    private BookRepository bookRepository;

    public List<Book> findAll() {
        return bookRepository.findAll();
    }

    public Book findById(long id) {
        return bookRepository.findById(id);
    }

    public List<String> findDistinctAuthors() {
        return bookRepository.findDistinctAuthors();
    }

    public List<String> findDistinctGenres() {
        return bookRepository.findDistinctGenres();
    }

    public void save(Book book) {
        bookRepository.save(book);
    }

    public void deleteById(long id) {
        bookRepository.deleteById(id);
    }

    public List<Book> findByAuthorAndOrGenre(String author, String genre) {
        if(genre == null && author == null)
            return bookRepository.findAll();
        else if(genre == null)
            return bookRepository.findByAuthor(author);
        else if(author == null)
            return  bookRepository.findByGenre(genre);
        else
            return bookRepository.findByAuthorAndGenre(author, genre);
    }
}
