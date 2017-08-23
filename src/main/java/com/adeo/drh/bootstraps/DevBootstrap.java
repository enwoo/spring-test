package com.adeo.drh.bootstraps;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.stereotype.Component;

import com.adeo.drh.models.Author;
import com.adeo.drh.models.Book;
import com.adeo.drh.models.Publisher;
import com.adeo.drh.repositories.AuthorRepository;
import com.adeo.drh.repositories.BookRepository;
import com.adeo.drh.repositories.PublisherRepository;

@Component
public class DevBootstrap implements ApplicationListener<ContextRefreshedEvent>{

	private AuthorRepository authorRepository;
	private BookRepository bookRepository;
	private PublisherRepository publisherRepository;

	@Override
	public void onApplicationEvent(ContextRefreshedEvent event) {
		initData();
		
	}

	protected void initData() {
		Publisher larrousse=new Publisher("Larrousse");
		Publisher hachette=new Publisher("Hachette");
		publisherRepository.saveAll(Arrays.asList(larrousse,hachette));
		
		
		Book tartuffe=new Book("1234555NG","tartuffe",larrousse);
		Author moliere=new Author("moliere", "jean-baptiste");
		tartuffe.getAuthors().add(moliere);
		moliere.getBooks().add(tartuffe);
		// bidirectionnal relationships
		authorRepository.save(moliere);
		bookRepository.save(tartuffe);
		
		Book germinal=new Book("5566655NG","germinal",hachette);
		Author victorHugo=new Author("moliere", "jean-baptiste");
		germinal.getAuthors().add(victorHugo);
		victorHugo.getBooks().add(germinal);
		// bidirectionnal relationships
		authorRepository.saveAll(Arrays.asList(moliere,victorHugo));
		bookRepository.saveAll(Arrays.asList(tartuffe,germinal));
		
		
	}

	public DevBootstrap(AuthorRepository authorRepository, BookRepository bookRepository,
			PublisherRepository publisherRepository) {
		super();
		this.authorRepository = authorRepository;
		this.bookRepository = bookRepository;
		this.publisherRepository = publisherRepository;
	}

}
