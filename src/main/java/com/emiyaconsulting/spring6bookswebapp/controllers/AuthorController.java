package com.emiyaconsulting.spring6bookswebapp.controllers;

import com.emiyaconsulting.spring6bookswebapp.services.AuthorService;
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
    public String getAuthors(Model m) {
        m.addAttribute("authors", authorService.findAll());
        return "authors";
    }
}
