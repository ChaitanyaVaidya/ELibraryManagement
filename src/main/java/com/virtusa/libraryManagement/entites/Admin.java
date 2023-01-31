package com.virtusa.libraryManagement.entites;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import lombok.ToString.Exclude;

@Entity
@Table(name = "admin")
public class Admin {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long adminId;
	@Exclude
	@OneToMany(cascade = CascadeType.ALL)
	private List<Author> author;
	@Exclude
	@OneToMany(cascade = CascadeType.ALL)
	private List<Customer> customer;

	public Admin(Long adminId, List<Author> author, List<Customer> customer) {
		super();
		this.adminId = adminId;
		this.author = author;
		this.customer = customer;
	}

	public Admin() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Long getAdminId() {
		return adminId;
	}

	public void setAdminId(Long adminId) {
		this.adminId = adminId;
	}

	public List<Author> getAuthor() {
		return author;
	}

	public void setAuthor(List<Author> author) {
		this.author = author;
	}

	public List<Customer> getCustomer() {
		return customer;
	}

	public void setCustomer(List<Customer> customer) {
		this.customer = customer;
	}

}
