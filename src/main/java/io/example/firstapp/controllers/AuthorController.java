package io.example.firstapp.controllers;

import io.example.firstapp.services.AuthorService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class AuthorController {

    private final AuthorService authorService;


    public AuthorController(AuthorService authorService) {
        this.authorService = authorService;
    }

    @RequestMapping("/authors")
    private String getAuthors(Model model){
        System.out.println("sono in getAuthors");
        model.addAttribute("authors",authorService.findAll());
        return "authors";
    }

    @RequestMapping("/firstAuthor")
    private String getFirstAuthor(Model model){
        System.out.println("sono in getFirstAuthor");
        model.addAttribute("author",authorService.getFirstAuthor());
        return "firstAuthor";
    }
}
