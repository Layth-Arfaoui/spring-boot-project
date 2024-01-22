package com.api.app.Reposetory;

import java.util.List;

import org.hibernate.annotations.Cascade;
import org.hibernate.annotations.CascadeType;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.api.app.model.Categorie;
@Repository
public interface CategorieReposetorie extends JpaRepository<Categorie, Integer> {
	@Query("SELECT c FROM Categorie c WHERE c.des LIKE %:keyword%")
    List<Categorie> findByKeyword(@Param("keyword") String keyword);
	@Query("SELECT p.categorie FROM Produit p WHERE p.code = :productCode")
	Categorie getByProduct(@Param("productCode") int productCode);
	 @Modifying
	    @Query("DELETE FROM Categorie c WHERE c.id = :id")
	    @Cascade(CascadeType.ALL)  // Add this annotation for cascading deletion
	    void deleteByIdWithCascade(@Param("id") Integer id);
}