package com.api.app.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;

@Entity
public class Produit {
	@Id
	private int code;
	private String des;
	private float prix;
	private int qte;
	@ManyToOne
    @JoinColumn(name = "categorie_code") // Specifies foreign key in Produit table
    private Categorie categorie; // ManyToOne relationship with Categorie
	
	public Produit() {
		super();
	}
	public Produit(int code, String des, float prix, int qte,Categorie categorie) {
		super();
		this.code = code;
		this.des = des;
		this.prix = prix;
		this.qte = qte;
		this.categorie=categorie;
	}
	
	public int getCode() {
		return code;
	}
	public String getDes() {
		return des;
	}
	public float getPrix() {
		return prix;
	}
	public int getQte() {
		return qte;
	}
	public void setCode(int code) {
		this.code = code;
	}
	public void setDes(String des) {
		this.des = des;
	}
	public void setPrix(float prix) {
		this.prix = prix;
	}
	public void setQte(int qte) {
		this.qte = qte;
	}
	
	public Categorie getCategorie() {
		return categorie;
	}
	public void setCategorie(Categorie categorie) {
		this.categorie = categorie;
	}
	@Override
	public String toString() {
		return "Produit [code=" + code + ", des=" + des + ", prix=" + prix + ", qte=" + qte + "]";
	}
	
}
