package com.tts.BookStore.Models;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Book {

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Long id; 
	
	private int quantity; 
	private float price; 
	private String description; 
	private String title; 
	private String author; 
	private String genre; 
	private String image;
	
	public Book(int quantity, float price, String description, String title, String author, String genre,
			String image) {
		this.quantity = quantity;
		this.price = price;
		this.description = description;
		this.title = title;
		this.author = author;
		this.genre = genre;
		this.image = image;
	}
	public Book() {

	}
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public int getQuantity() {
		return quantity;
	}
	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}
	public float getPrice() {
		return price;
	}
	public void setPrice(float price) {
		this.price = price;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public String getTitle() {
		return title;
	}
	public void setName(String title) {
		this.title = title;
	}
	public String getAuthor() {
		return author;
	}
	public void setAuthor(String author) {
		this.author = author;
	}
	public String getGenre() {
		return genre;
	}
	public void setGenre(String genre) {
		this.genre = genre;
	}
	public String getImage() {
		return image;
	}
	public void setImage(String image) {
		this.image = image;
	}
	@Override
	public String toString() {
		return "Product [id=" + id + ", quantity=" + quantity + ", price=" + price + ", description=" + description
				+ ", title=" + title + ", author=" + author + ", genre=" + genre + ", image=" + image + "]";
	} 
	
	
	
}

