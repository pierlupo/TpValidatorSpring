package com.tpvalidatorspring.service;

import com.tpvalidatorspring.entity.Author;
import com.tpvalidatorspring.entity.Book;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public interface AuthorService {

    Author createAuthor(Author author);

    Author updateAuthor(Author author, Integer id);

    Optional<Author> getAuthorById(Integer id);

    List<Author> getAllAuthors();

    void deleteAuthorById(Integer id);
}
