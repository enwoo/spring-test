package com.adeo.drh.bootstraps;

import java.util.Arrays;
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
		initData();
		
	}

	protected void initData() {
		Book tartuffe=new Book("1234555NG","tartuffe");
		Author moliere=new Author("moliere", "jean-baptiste");
		tartuffe.getAuthors().add(moliere);
		moliere.getBooks().add(tartuffe);
		// bidirectionnal relationships
		authorRepository.save(moliere);
		bookRepository.save(tartuffe);
		
		Book germinal=new Book("5566655NG","germinal");
		Author victorHugo=new Author("moliere", "jean-baptiste");
		germinal.getAuthors().add(victorHugo);
		victorHugo.getBooks().add(germinal);
		// bidirectionnal relationships
		authorRepository.saveAll(Arrays.asList(moliere,victorHugo));
		bookRepository.saveAll(Arrays.asList(tartuffe,germinal));
	}

}
