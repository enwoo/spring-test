package com.adeo.drh.models;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Version;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;

@Data
@EqualsAndHashCode(of={"isbn"})
@ToString(exclude={"authors","publisher"})
@Entity
public class Book {
	@Id @GeneratedValue(strategy=GenerationType.AUTO)
	private Long id;
	@Version
	private Integer version;
	@Column(unique=true,updatable=false,nullable=false)
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

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Integer getVersion() {
		return version;
	}

	public void setVersion(Integer version) {
		this.version = version;
	}

	public String getIsbn() {
		return isbn;
	}

	public void setIsbn(String isbn) {
		this.isbn = isbn;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public Publisher getPublisher() {
		return publisher;
	}

	public void setPublisher(Publisher publisher) {
		this.publisher = publisher;
	}

	public Set<Author> getAuthors() {
		return authors;
	}

	public void setAuthors(Set<Author> authors) {
		this.authors = authors;
	}
}
