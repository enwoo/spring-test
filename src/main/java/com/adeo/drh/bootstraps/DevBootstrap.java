package com.adeo.drh.bootstraps;

import java.util.HashSet;
import java.util.Set;

import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.stereotype.Component;

import com.adeo.drh.models.Author;
import com.adeo.drh.models.Book;
import com.adeo.drh.repositories.AuthorRepository;
import com.adeo.drh.repositories.BookRepository;

@Component
public class DevBootstrap implements ApplicationListener<ContextRefreshedEvent>{

	private AuthorRepository authorRepository;
	private BookRepository bookRepository;

	
	public DevBootstrap(AuthorRepository authorRepository, BookRepository bookRepository) {
		super();
		this.authorRepository = authorRepository;
		this.bookRepository = bookRepository;
	}

	@Override
	public void onApplicationEvent(ContextRefreshedEvent event) {
		Book tartuffe=new Book("1234555NG","tartuffe");
		HashSet<Book> books=new HashSet<>();
		books.add(tartuffe);
		
		Author moliere=new Author("moliere", "jean-baptiste");
		Set<Author> authors=new HashSet<>();
		authors.add(moliere);
		
		// bidirectionnal relationships
		tartuffe.setAuthors(authors);
		moliere.setBooks(books);		
		authorRepository.save(moliere);
		bookRepository.save(tartuffe);
		
	}

}
