package com.adeo.drh.repositories;

import org.springframework.data.repository.CrudRepository;

import com.adeo.drh.models.Book;

public interface BookRepository extends CrudRepository<Book, Long> {

}
