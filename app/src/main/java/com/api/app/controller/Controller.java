package com.api.app.controller;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.api.app.metier.metier;
import com.api.app.model.Categorie;
import com.api.app.model.Produit;
@CrossOrigin(origins = {"http://localhost:4200", "http://localhost:8081"}, allowedHeaders = "*")
@RestController
public class Controller {
	 private final metier metier;

	    @Autowired
	    public Controller(metier metier) {
	        this.metier = metier;
	    }
	@GetMapping("/test")
	public String test() {return "test";}
	
//produit crud
	//create
	@PostMapping("/produit")
    public void ajouterProduit(@RequestBody Produit produit) {
         metier.addProduit(produit);      
    }
	//read
	@GetMapping("/produits")
    public List<Produit> listerProduits() {
        return metier.listProduits();
    }
    @GetMapping("/produits/cc/{categorieCode}")
    public List<Produit> produitsParCategorie(@PathVariable("categorieCode") int categorieCode){
		return metier.getProduitsParCategorie(categorieCode);
	}
	@GetMapping("/produits/{keyword}")
    public List<Produit> rechercheProduits(@PathVariable("keyword") String keyword){
		return metier.rechercheProduit(keyword);
	}
	@GetMapping("/produit/{code}")
    public Produit getProduit(@PathVariable("code") int code) {
        return metier.getProduit(code);
    }
	
    @GetMapping("/produits/{minPrix}/{maxPrix}")
    public List<Produit> rechercheProduits(@PathVariable("minPrix") float minPrix,@PathVariable("maxPrix") float maxPrix){
		return metier.rechercheParPrix(minPrix,maxPrix);
	}
	@GetMapping("/isProduit/{code}")
	public boolean isProduit(@PathVariable("code") int code) {
		return metier.isProduit(code);
	}
	//update
	@PutMapping("/produit")
	public void mettreAJourProduit(@RequestBody Produit produit) {
	     metier.editProduit(produit);
	}
	//delet
	@DeleteMapping("/produits/{code}")
	public void supprimerProduit(@PathVariable("code") int code) {
	    metier.deleteProduit(code);
	}
//categorie crud
	//create
    @PostMapping("/categorie")
    public void ajouterCategorie(@RequestBody Categorie categorie) {
         metier.addCategorie(categorie);
        
    }
    //read
    @GetMapping("/categories")
    public List<Categorie> listerCategories() {
        return metier.listCategories();
    }
    @GetMapping("/categories/{keyword}")
    public List<Categorie> rechercheCategories(@PathVariable("keyword") String keyword){
		return metier.rechercheCategorie(keyword);
	}
    @GetMapping("/categorie/pc/{Productcode}")
    public Categorie getCategoriewithProductCode(@PathVariable("Productcode") int Productcode) {
        return metier.getCategorieWithProductCode(Productcode);
    }
    @GetMapping("/categorie/{code}")
    public Categorie getCategorie(@PathVariable("code") int code) {
        return metier.getCategorie(code);
    }
	@GetMapping("/isCategorie/{code}")
	public boolean isCategorie(@PathVariable("code") int code) {
		return metier.isCategorie(code);
	}
    // Update
    @PutMapping("/categorie")
    public void mettreAJourCategorie(@RequestBody Categorie categorie) {
        metier.editCategorie(categorie);
    }
    @DeleteMapping("/categories/{code}")
    public void supprimerCategorie(@PathVariable("code") int code) {
        metier.deleteCategorie(code);
    }
}
