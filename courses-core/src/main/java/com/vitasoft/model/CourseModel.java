package com.vitasoft.model;

import com.vitasoft.hibernatesearch.bridges.AuthorStringBridge;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import org.hibernate.search.annotations.Field;
import org.hibernate.search.annotations.FieldBridge;
import org.hibernate.search.annotations.Indexed;
import org.hibernate.search.annotations.NumericField;
import org.hibernate.search.annotations.Parameter;
import org.hibernate.search.annotations.TermVector;

@Entity
@Indexed
@Table(name = "course")
public class CourseModel {
	
	@Id
	@Column(name = "id")
	private String id;
	@Column(name = "name")
	@Field(termVector = TermVector.YES)
	private String name;
	@Column(name = "description")
	@Field(termVector = TermVector.YES)
	private String description;
	@Column(name = "price")
	@Field
	@NumericField
	private Double price;
	@Field
	@FieldBridge(impl = AuthorStringBridge.class,
		params = @Parameter(name = "padding", value = "5"))
	@OneToOne
	private AuthorModel author;
	
	public String getId() {
		return id;
	}
	
	public void setId(String id) {
		this.id = id;
	}
	
	public String getName() {
		return name;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	
	public String getDescription() {
		return description;
	}
	
	public void setDescription(String description) {
		this.description = description;
	}
	
	public Double getPrice() {
		return price;
	}
	
	public void setPrice(Double price) {
		this.price = price;
	}
	
	public AuthorModel getAuthor() {
		return author;
	}
	
	public void setAuthor(AuthorModel author) {
		this.author = author;
	}
}
