package com.tpvalidatorspring.service.impl;

import com.tpvalidatorspring.entity.Author;
import com.tpvalidatorspring.entity.Book;
import com.tpvalidatorspring.repository.AuthorRepo;
import com.tpvalidatorspring.service.AuthorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;


@Service
public class IAuthorService implements AuthorService {

    @Autowired
    private AuthorRepo authorRepo;

    @Override
    public Author createAuthor(Author author) {
        return authorRepo.save(author);
    }

    @Override
    public Author updateAuthor(Author author, Integer id) {
         Optional<Author> author1 = authorRepo.findById(id);

        if(author1.isPresent()){
            Author author2 = author1.get();
            author2.setFirstName(author.getFirstName());
            author2.setLastName(author.getLastName());
            author2.setEmail(author.getEmail());
            author2.setBooks(author.getBooks());
            return authorRepo.save(author2);
        }

        return null;
    }

    @Override
    public Optional<Author> getAuthorById(Integer id) {
        return authorRepo.findById(id);
    }

    @Override
    public List<Author> getAllAuthors() {
        return (List<Author>) authorRepo.findAll();
    }

    @Override
    public void deleteAuthorById(Integer id) {
        authorRepo.deleteById(id);
    }
}
