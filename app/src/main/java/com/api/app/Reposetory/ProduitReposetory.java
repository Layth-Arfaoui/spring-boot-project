package com.api.app.Reposetory;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.api.app.model.Produit;
@Repository
public interface ProduitReposetory extends JpaRepository<Produit, Integer> {
	@Query("SELECT p FROM Produit p WHERE p.des LIKE %:keyword% OR p.categorie.des LIKE %:keyword%")
    List<Produit> findByKeyword(@Param("keyword") String keyword);
	@Query("SELECT p FROM Produit p WHERE p.prix BETWEEN :minPrice AND :maxPrice")
	List<Produit> findByPrice(@Param("minPrice") float minPrice, @Param("maxPrice") float maxPrice);
	@Query("SELECT p FROM Produit p WHERE p.categorie.code= :categorieCode")
	List<Produit> findByCategorie(@Param("categorieCode") int categorieCode);



}
