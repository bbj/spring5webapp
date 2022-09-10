package com.bbj.spring5webapp.controllers;

import com.bbj.spring5webapp.repositories.BookRepository;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class BookController {

    private final BookRepository bookRepository;

    public BookController(BookRepository bookRepository) {
        this.bookRepository = bookRepository;
    }

    @RequestMapping("/books")
    public String getBooks(Model model) {

        model.addAttribute("books", bookRepository.findAll());

        return "books/list"; //tell the view to look for a template named "list" under dir "books"
    }
}

/*
    @Controller => Spring managed component => SF will inject an instance of the book repo
    into the controller, when constructor called

    At runtime:
    - /books called
    - controller calls getBooks(Model model)
    - Spring provide the Model object by injecting it
    - then getBooks() add a books attrib to model, set value to all bookd
    - then "books" returned to the view

 */
