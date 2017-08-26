package com.adeo.drh.com.adeo.drh.controllers;

import com.adeo.drh.models.Author;
import com.adeo.drh.repositories.AuthorRepository;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.List;

@Controller
public class AuthorCtrl {

    private AuthorRepository authorRepository;

    public AuthorCtrl(AuthorRepository authorRepository) {
        this.authorRepository = authorRepository;
    }

    @RequestMapping(value = "/authors", method = {RequestMethod.GET})
    public String findAll(Model model){
            model.addAttribute("authors",authorRepository.findAll());
            return "books";
    }



}
