package com.example.Library_Book.service;

import com.example.Library_Book.model.Book;
import com.example.Library_Book.repository.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BookService {

    @Autowired
    private final BookRepository bookRepository;

    public BookService(BookRepository bookRepository) {
        this.bookRepository = bookRepository;
    }

    public List<Book> getAllBooks(){
        return bookRepository.findAll();
    }

    public Book getBookById(Long id){
        return bookRepository.findById(id).orElseThrow(()-> new RuntimeException("Book Not Found"));
    }

    public void addBook(Book book){
        bookRepository.save(book);
    }

    public void updateBook(Long id, Book bookDetails){
        Book book = bookRepository.findById(id).orElseThrow(()->new RuntimeException("Book Not Found"));

        if(book.getId()!=0){
            book.setTitle(bookDetails.getTitle());
            book.setAuthor(bookDetails.getAuthor());
            book.setPrice(bookDetails.getPrice());
            bookRepository.save(book);
        }

    }

    public void deleteBook(Long id){
        bookRepository.deleteById(id);
    }
}
