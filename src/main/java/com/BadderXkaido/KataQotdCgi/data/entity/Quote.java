package com.BadderXkaido.KataQotdCgi.data.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="QUOTE")
public class Quote {
	
	@Id
	@Column(name="QUOTE_ID")
	@GeneratedValue(strategy=GenerationType.AUTO)
	private long idQuote;
	
	@Column(name="AUTHOR")
	private String author;
	
	@Column(name="NAME")
	private String quoteString;

	// Getters and Setters
	
	public long getIdQuote() {
		return idQuote;
	}

	public void setIdQuote(long idQuote) {
		this.idQuote = idQuote;
	}

	public String getAuthor() {
		return author;
	}

	public void setAuthor(String author) {
		this.author = author;
	}

	public String getQuoteString() {
		return quoteString;
	}

	public void setQuoteString(String quoteString) {
		this.quoteString = quoteString;
	}

	
	
	
	
}
