package com.api.app.model;

import java.util.List;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;

@Entity
public class Categorie {
	@Id
	private int code;
	private String des;
	@OneToMany(mappedBy = "categorie")
    private List<Produit> produits;
	public Categorie() {
	}
	public Categorie(int code, String des) {
		super();
		this.code = code;
		this.des = des;
	}
	public int getCode() {
		return code;
	}
	public String getDes() {
		return des;
	}
	public void setCode(int code) {
		this.code = code;
	}
	public void setDes(String des) {
		this.des = des;
	}
	
	@Override
	public String toString() {
		return "Categorie [code=" + code + ", des=" + des + "]";
	}

}

