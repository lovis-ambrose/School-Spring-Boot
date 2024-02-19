package com.example.demo.models;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import org.springframework.stereotype.Controller;

@Controller
@Entity
public class BookModel {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long isbn;
    private String tittle;

    private String author;
    private String description;

    public BookModel(Long isbn, String tittle, String author, String description){
        this.isbn = isbn;
        this.author = author;
        this.tittle = tittle;
        this.description = description;
    }

    public BookModel() {

    }

    //getters and setters
    public void setIsbn(Long isbn) {
        this.isbn = isbn;
    }

    public Long getIsbn() {
        return isbn;
    }

    public void setTittle(String tittle) {
        this.tittle = tittle;
    }

    public String getTittle() {
        return tittle;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getAuthor() {
        return author;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getDescription() {
        return description;
    }
}
