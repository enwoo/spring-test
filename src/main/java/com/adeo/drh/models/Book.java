package com.adeo.drh.models;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;

@Data
@EqualsAndHashCode(exclude={"authors","publisher"})
@ToString(exclude={"authors","publisher"})
@Entity
public class Book {
	@Id @GeneratedValue(strategy=GenerationType.AUTO)
	private Long id;
	private String isbn;
	private String title;
	@ManyToOne
	private Publisher publisher;
	
	@ManyToMany
	@JoinTable(name="author_book",joinColumns={@JoinColumn(name="book_id")},inverseJoinColumns= {@JoinColumn(name="author_id")})
	private Set<Author> authors=new HashSet<>();
	
	protected Book() {};
	
	public Book(String isbn, String title, Publisher publisher) {
		this.isbn=isbn;
		this.title=title;
		this.publisher=publisher;
	}
	
	public Book(String isbn, String title, Publisher publisher, Set<Author> authors) {
		this.isbn=isbn;
		this.title=title;
		this.authors=authors;
		this.publisher=publisher;
	}
}
