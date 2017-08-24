package com.adeo.drh.models;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;
import javax.persistence.Version;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;

@Data
@EqualsAndHashCode(of={"name","firstname"})
@ToString(exclude={"books"})
@Entity
@Table(uniqueConstraints= @UniqueConstraint(columnNames={"name","firstname"}))
public class Author {
	@Id @GeneratedValue(strategy=GenerationType.AUTO)
	private Long id;
	@Version
	private Integer version;
	@Column(updatable=false,nullable=false)
	private String name;
	@Column(updatable=false,nullable=false)
	private String firstname;
	@ManyToMany(mappedBy="authors")
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
