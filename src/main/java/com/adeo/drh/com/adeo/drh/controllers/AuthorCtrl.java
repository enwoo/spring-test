package com.adeo.drh.com.adeo.drh.controllers;


import com.adeo.drh.models.DogData;
import com.adeo.drh.models.DogDataWrapper;
import com.adeo.drh.repositories.AuthorRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.client.RestTemplate;
import java.util.List;


@Controller
@RequestMapping("/authors")
public class AuthorCtrl {

    private static final Logger LOGGER= LoggerFactory.getLogger(AuthorCtrl.class);
    private AuthorRepository authorRepository;

    public AuthorCtrl(AuthorRepository authorRepository) {
        this.authorRepository = authorRepository;
    }

    @RequestMapping(path = {"/authors"}, method = {RequestMethod.GET})
    public String findAll(Model model){
            model.addAttribute("authors",authorRepository.findAll());
            return "books";
    }

    @Autowired
    private RestTemplate rest;

    @RequestMapping("/")
    public String index(Model model){
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        String name = auth.getName(); //get logged in username
        LOGGER.info("current user is : {} ", name);
        model.addAttribute("authors",authorRepository.findAll());
        return "authors";
    }
}
