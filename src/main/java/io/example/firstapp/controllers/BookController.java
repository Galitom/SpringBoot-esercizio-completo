package io.example.firstapp.controllers;

import io.example.firstapp.services.BookService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class BookController {

    private final BookService bookService;

    public BookController(BookService bookService) {
        this.bookService = bookService;
    }

    @RequestMapping("/books")
    private String getBooks(Model model){
        System.out.println("sono in getBooks");
        model.addAttribute("books",bookService.findAll());
        return "books";
    }
}
