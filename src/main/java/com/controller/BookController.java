package com.controller;

import com.model.Book;
import com.repository.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@RestController
@RequestMapping(value = "/books")
public class BookController {
    @Autowired
    BookRepository bookRepository;

    @PostMapping
    public ResponseEntity<Book> salvaUm(@RequestBody Book book) {
    book = bookRepository.save(book);
        return new ResponseEntity<>(book, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public Book listaUm(@PathVariable(value = "id") long id){
        return bookRepository.findById(id);
    }

    @GetMapping
    public List<Book> listaTodos() {
        return bookRepository.findAll();
    }

    @DeleteMapping("/{id}")
    public void deletaUm (@PathVariable(value = "id") long id) {
        bookRepository.deleteById(id);
    }

    @PutMapping("/{id}")
    public Book editaBook(@RequestBody Book book){
        return bookRepository.save(book);
    }

}
