package com.virtusa.libraryManagement.entites;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotNull;

import lombok.ToString.Exclude;

@Entity
@Table(name = "author")
public class Author {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long authorId;
	@NotNull
	private String authorName;
	@Email(message="invalid email")
	private String email;
	@Exclude
	@OneToMany(cascade = CascadeType.ALL)
	private List<Book> book;

	// @Exclude
	@ManyToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "adminId")
	private Admin admin;

	public Author(long authorId, String authorName, String email, List<Book> book, Admin admin) {
		super();
		this.authorId = authorId;
		this.authorName = authorName;
		this.email = email;
		this.book = book;
		this.admin = admin;
	}

	public Author() {
		super();
		// TODO Auto-generated constructor stub
	}

	public long getAuthorId() {
		return authorId;
	}

	public void setAuthorId(long authorId) {
		this.authorId = authorId;
	}

	public String getAuthorName() {
		return authorName;
	}

	public void setAuthorName(String authorName) {
		this.authorName = authorName;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public List<Book> getBook() {
		return book;
	}

	public void setBook(List<Book> book) {
		this.book = book;
	}

	public Admin getAdmin() {
		return admin;
	}

	public void setAdmin(Admin admin) {
		this.admin = admin;
	}

	public boolean contains(String lowerCase) {
		// TODO Auto-generated method stub
		return false;
	}

	public List<Book> toLowerCase() {
		// TODO Auto-generated method stub
		return null;
	}

}
