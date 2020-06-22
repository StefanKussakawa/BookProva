package com.controller;

import com.model.Author;
import com.repository.AuthorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@RestController
@RequestMapping(value = "/authors")
public class AuthorController {
    @Autowired
    AuthorRepository authorRepository;

    @PostMapping
    public ResponseEntity<Author> salvaUm(@RequestBody Author author) {
        author = authorRepository.save(author);
        return new ResponseEntity<>(author, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public Author listaUm(@PathVariable(value = "id") long id){
        return authorRepository.findById(id);
    }

    @GetMapping
    public List<Author> listaTodos() {
        return authorRepository.findAll();
    }

    @DeleteMapping("/{id}")
    public void deletaUm (@PathVariable(value = "id") long id) {
        authorRepository.deleteById(id);
    }

    @PutMapping("/{id}")
    public Author editaBook(@RequestBody Author author){
        return authorRepository.save(author);
    }

}
