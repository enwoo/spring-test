package com.adeo.drh.model;

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

import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(exclude={"authors"})
@Entity
public class Book {
	@Id @GeneratedValue(strategy=GenerationType.AUTO)
	private Long id;
	private String isbn;
	private String title;
	@ManyToMany(cascade=CascadeType.ALL)
	@JoinTable(name="author_book",joinColumns={@JoinColumn(name="book_id")},inverseJoinColumns= {@JoinColumn(name="author_id")})
	private Set<Author> authors=new HashSet<>();
	
	protected Book() {};
	
	public Book(String isbn, String title) {
		this.isbn=isbn;
		this.title=title;
	}
	
	public Book(String isbn, String title,Set<Author> authors) {
		this.isbn=isbn;
		this.title=title;
		this.authors=authors;
	}
}
