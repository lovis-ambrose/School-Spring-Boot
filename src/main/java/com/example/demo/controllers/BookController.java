package com.example.demo.controllers;

import com.example.demo.models.BookModel;
import com.example.demo.repository.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "/books/")
public class BookController {
    @Autowired
    private BookRepository bookRepository;

    @GetMapping("list")
    public String getAllBooks(Model model){
        List<BookModel> books = bookRepository.findAll();
        model.addAttribute("Books", books);
        return "Book/list";
    }

    @GetMapping("create")
    public String createBookForm(Model model){
        model.addAttribute("book", new BookModel());
        return "book/create";
    }

    @PostMapping("create")
    public String crateBook(@ModelAttribute("book") BookModel bookModel){
        bookRepository.save(bookModel);
        return "redirect:/books/list";
    }

    @GetMapping("edit/{isbn}")
    public String editBookForm(@PathVariable Long isbn, Model model){
        BookModel bookModel = bookRepository.findById(isbn).orElseThrow(() -> new IllegalArgumentException("Invalid book ISBN:" + isbn));
        model.addAttribute("book", bookModel);
        return "book/edit";
    }

    @PostMapping("edit/{isbn}")
    public String editBook(@PathVariable Long isbn, @ModelAttribute("book")  BookModel bookModel){
        bookModel.setIsbn(isbn);
        bookRepository.save(bookModel);
        return "redirect:/books/list";
    }

    @GetMapping("delete/{isbn}")
    public String deleteBook(@PathVariable Long isbn) {
        bookRepository.deleteById(isbn);
        return "redirect:/books";
    }
}
