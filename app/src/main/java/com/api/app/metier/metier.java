package com.api.app.metier;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.api.app.Reposetory.CategorieReposetorie;
import com.api.app.Reposetory.ProduitReposetory;
import com.api.app.model.Categorie;
import com.api.app.model.Produit;


@Service
public class metier {
	// Produit
	@Autowired
	private ProduitReposetory prodRep;
	
	public  void addProduit(Produit produit) {
		prodRep.save(produit);
	}

	public  List<Produit> listProduits() {
		return prodRep.findAll();
	}
	
	public  List<Produit> rechercheProduit(String keyword){
		return prodRep.findByKeyword(keyword);
	}
    
	public  List<Produit> getProduitsParCategorie(int categorieCode){
		return prodRep.findByCategorie(categorieCode);
	}
	
	public  Produit getProduit(int code) {
        return prodRep.findById(code).get();
    }
	
	public List<Produit> rechercheParPrix(float minPrice,float maxPrice){
		return prodRep.findByPrice(minPrice, maxPrice);
	}
	
	public  boolean isProduit(int code) {
		return prodRep.findById(code).isPresent();
	}
	
    public  void editProduit(Produit produit) {
        if(isProduit(produit.getCode())) {prodRep.save(produit);}
    }

    public  void deleteProduit(int code) {
        prodRep.deleteById(code);
    }


    // Categorie
    @Autowired
    private  CategorieReposetorie catRep;

    public  void addCategorie(Categorie categorie) {
    	catRep.save(categorie);
    }

    public  List<Categorie> listCategories() {
    	return catRep.findAll();
    }

    public  List<Categorie> rechercheCategorie(String keyword) {
    	return catRep.findByKeyword(keyword);
    }
    
    public  Categorie getCategorie(int code) {
        return catRep.findById(code).get();
    }    
    
    public Categorie getCategorieWithProductCode(int ProductCode){
    	return catRep.getByProduct(ProductCode);
    }
    
    public  boolean isCategorie(int code) {
    	return catRep.findById(code).isPresent();
    }
    
    public  void editCategorie(Categorie categorie) {
    	if(isCategorie(categorie.getCode())) {catRep.save(categorie);}
    }

    public  void deleteCategorie(int code) {
        catRep.deleteById(code);
    }

}
