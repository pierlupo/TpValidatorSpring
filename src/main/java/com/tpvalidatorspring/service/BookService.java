package com.tpvalidatorspring.service;


import com.tpvalidatorspring.entity.Book;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;


@Service
public interface BookService {

    Book createBook(Book book);

    Book updateBook(Book book, Integer id);

    Optional<Book> getBookById(Integer id);

    List<Book> getAllBooks();

    void deleteBookById(Integer id);

    }

