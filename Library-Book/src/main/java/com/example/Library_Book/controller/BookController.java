package com.example.Library_Book.controller;

import com.example.Library_Book.model.Book;
import com.example.Library_Book.service.BookService;
import lombok.Getter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Objects;

@RestController
@RequestMapping("/books")
public class BookController {

    @Autowired
    private BookService bookService;

    @GetMapping
    public ResponseEntity<List<Book>> getAllBooks(){
        return new ResponseEntity<>(bookService.getAllBooks(), HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<String> addBook(@RequestBody Book book){
        bookService.addBook(book);
        return new ResponseEntity<>("Book Added Successfully...", HttpStatus.CREATED);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Book> getBookById(@PathVariable Long id){
        return new ResponseEntity<>(bookService.getBookById(id), HttpStatus.OK);
    }

    @PutMapping("/{id}")
    public ResponseEntity<String> updateBook(@PathVariable Long id, @RequestBody Book book){
        bookService.updateBook(id, book);
        return new ResponseEntity<>("Book Updated Successfully...", HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Object> deleteBookById(@PathVariable Long id){
        bookService.deleteBook(id);
        return new ResponseEntity<>("Book Deleted Successfully...", HttpStatus.OK);
    }
}
