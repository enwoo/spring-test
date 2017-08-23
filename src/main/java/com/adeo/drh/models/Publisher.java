package com.adeo.drh.models;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import lombok.Data;

@Data
@Entity
public class Publisher {
	@Id @GeneratedValue(strategy=GenerationType.AUTO)
	private Long id;
	private String name;
	
	// only for ORM
	protected Publisher() {}
	public Publisher(String name) {
		super();
		this.name = name;
	};
}
