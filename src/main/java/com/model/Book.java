package com.model;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "Books")
public class Book {
    @Id
    private Long id;
    private String nome;
    private String isbn;

    @ManyToMany
    private List<Author> autores = new ArrayList<>();

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getIsbn() {
        return isbn;
    }

    public void setIsbn(String isbn) {
        this.isbn = isbn;
    }

    public List<Author> getAutores() {
        return autores;
    }

    public void setAutores(List<Author> autores) {
        this.autores = autores;
    }
}
