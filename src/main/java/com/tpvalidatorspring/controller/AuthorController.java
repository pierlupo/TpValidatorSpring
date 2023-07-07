package com.tpvalidatorspring.controller;


import com.tpvalidatorspring.entity.Author;
import com.tpvalidatorspring.service.AuthorService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("api/v2")
public class AuthorController {

    @Autowired
    private AuthorService IAuthorService;

    @PostMapping("/save")
    ResponseEntity<String> createAuthor(@Valid @RequestBody Author author){

        IAuthorService.createAuthor(author);

        return ResponseEntity.ok("Author created");
    }

    @GetMapping("/all")
    public ResponseEntity<List<Author>> getAllAuthors(){
        return new ResponseEntity(IAuthorService.getAllAuthors(), HttpStatus.OK);
    }

    @GetMapping("/author/{id}")
    public ResponseEntity<Optional<Author>> getAuthorById(@PathVariable(name = "id") int id){
        return ResponseEntity.ok(IAuthorService.getAuthorById(id));
    }

    @PutMapping("/edit/{id}")
    public ResponseEntity<Author> updateAuthor(@RequestBody Author author, @PathVariable(name = "id") int id){

        Author authorResponse = IAuthorService.updateAuthor(author, id);

        return new ResponseEntity<>(authorResponse, HttpStatus.OK);
    }


    @DeleteMapping("/author/{id}")
    public ResponseEntity<String> deleteAuthor(@PathVariable(name = "id") int id){

        IAuthorService.deleteAuthorById(id);

        return new ResponseEntity<>("Author deleted successfully.", HttpStatus.OK);
    }
}
