package com.adeo.drh.model;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;

import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(exclude={"books"})
@Entity
public class Author {
	@Id @GeneratedValue(strategy=GenerationType.AUTO)
	private Long id;
	private String name;
	private String firstname;
	@ManyToMany(mappedBy="authors", cascade=CascadeType.ALL)
	private Set<Book> books=new HashSet<>();
	
	// for orm
	protected Author() {};
	public Author(String name,String firstname) {
		this.firstname=firstname;
		this.name=name;
	}
	
	
	public Author(String name,String firstname, Set<Book> books) {
		this.books=books;
		this.firstname=firstname;
		this.name=name;
	}
}
