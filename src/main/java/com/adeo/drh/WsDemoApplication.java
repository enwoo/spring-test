package com.adeo.drh;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.EntityManager;
import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.adeo.drh.model.Author;
import com.adeo.drh.model.Book;

@SpringBootApplication
public class WsDemoApplication implements CommandLineRunner{

	public static void main(String[] args) {
		SpringApplication.run(WsDemoApplication.class, args);
	}

	@Autowired
	private EntityManager em;
	
	
	@Override
	@Transactional
	public void run(String... args) throws Exception {
			Book tartuffe=new Book("1234555NG","tartuffe");
			HashSet<Book> books=new HashSet<>();
			books.add(tartuffe);
			
			Author moliere=new Author("moliere", "jean-baptiste");
			Set<Author> authors=new HashSet<>();
			authors.add(moliere);
			
			// bidi
			tartuffe.setAuthors(authors);
			moliere.setBooks(books);
			
			this.em.persist(tartuffe);
	}
}
