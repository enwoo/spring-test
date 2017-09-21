package com.adeo.drh.services;

import java.util.stream.Collectors;

import javax.transaction.Transactional;

import org.springframework.stereotype.Service;

import com.adeo.drh.models.Book;
import com.adeo.drh.models.Publisher;
import com.adeo.drh.repositories.PublisherRepository;

@Service
public class PublisherSrv {

    private PublisherRepository publisherRepository;

    public PublisherSrv(PublisherRepository publisherRepository) {
        super();
        this.publisherRepository = publisherRepository;
    }

    @Transactional
    public void writeBooks() {
        publisherRepository.findAll().forEach(pub -> {
            pub.getBooks().stream().map(Book::getTitle).collect(Collectors.toSet()).forEach(a->{
                System.out.println(""+a);
            });
        });

    }
}
