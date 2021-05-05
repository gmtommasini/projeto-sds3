package com.devsuperior.dsvendas.entities;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "tb_sellers") //name of the table (also in the sql script)
public class Seller {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY) //auto increment
	private long id;
	private String name;
	
	@OneToMany(mappedBy = "seller")
	private List<Sale> sales = new ArrayList<>();
	
	//constructors
	public Seller() {	}
	public Seller(long id, String name) {
		this.id = id;
		this.name = name;
	}
	
	//getters and setters
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	
	public List<Sale> getSales() {
		return sales;
	}
	
	
	
}
