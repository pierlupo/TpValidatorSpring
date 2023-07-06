package com.tpvalidatorspring.service.impl;

import com.tpvalidatorspring.entity.Book;
import com.tpvalidatorspring.repository.BookRepo;
import com.tpvalidatorspring.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class IBookService implements BookService {

    @Autowired
    private BookRepo bookRepo;


    @Override
    public Book createBook(Book book) {
        return bookRepo.save(book);
    }

    @Override
    public Book updateBook(Book book, Integer id) {
        Optional<Book> book1 = bookRepo.findById(id);

        if(book1.isPresent()){
            Book book2 = book1.get();
            book2.setTitle(book.getTitle());
            book2.setPublishingYear(book.getPublishingYear());
            book2.setAuthor(book.getAuthor());
            book2.setCategory(book.getCategory());
            return bookRepo.save(book2);
        }

        return null;
    }

    @Override
    public Optional<Book> getBookById(Integer id) {
       return bookRepo.findById(id);
    }

    @Override
    public List<Book> getAllBooks() {
        return (List<Book>) bookRepo.findAll();
    }

    @Override
    public void deleteBookById(Integer id) {
        bookRepo.deleteById(id);
    }
}
