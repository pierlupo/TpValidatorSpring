package com.tpvalidatorspring.controller;


import com.tpvalidatorspring.entity.Book;
import com.tpvalidatorspring.service.BookService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("api/v1")
public class BookController {

    @Autowired
    private BookService IBookService;

    @PostMapping("/save")
    ResponseEntity<String> createBook(@Valid @RequestBody Book book){

        IBookService.createBook(book);

        return ResponseEntity.ok("Book created");
    }

    @GetMapping("/all")
    public ResponseEntity<List<Book>> getAllBooks(){
        return new ResponseEntity(IBookService.getAllBooks(), HttpStatus.OK);
    }

    @GetMapping("/book/{id}")
    public ResponseEntity<Optional<Book>> getBookById(@PathVariable(name = "id") int id){
        return ResponseEntity.ok(IBookService.getBookById(id));
    }

    @PutMapping("/edit/{id}")
    public ResponseEntity<Book> updateBook(@RequestBody Book book, @PathVariable(name = "id") int id){

        Book bookResponse = IBookService.updateBook(book, id);

        return new ResponseEntity(bookResponse, HttpStatus.OK);
    }


    @DeleteMapping("/delete/{id}")
    public ResponseEntity<String> deleteBook(@PathVariable(name = "id") int id){

        IBookService.deleteBookById(id);

        return new ResponseEntity<>("Book entity deleted successfully.", HttpStatus.OK);
    }

}
