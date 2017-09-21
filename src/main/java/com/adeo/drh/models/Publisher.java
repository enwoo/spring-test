package com.adeo.drh.models;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Version;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;

@Data
@EqualsAndHashCode(of= {"name"})
@ToString(exclude= {"books"})
@Entity
public class Publisher {
	@Id @GeneratedValue(strategy=GenerationType.AUTO)
	private Long id;
	@Version
	private Integer version;
	@Column(unique=true,updatable=false,nullable=false)
	private String name;
	private String address;
	@OneToMany(mappedBy="publisher")
	private Set<Book> books=new HashSet<>();
	
	// only for ORM
	protected Publisher() {}
	public Publisher(String name,String address) {
		super();
		this.name = name;
		this.address=address;
	};

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

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public Set<Book> getBooks() {
		return books;
	}

	public void setBooks(Set<Book> books) {
		this.books = books;
	}
}
