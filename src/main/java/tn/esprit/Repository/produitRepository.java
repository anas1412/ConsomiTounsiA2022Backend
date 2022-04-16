package tn.esprit.Repository;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import tn.esprit.Entities.produit;

@Repository
public interface produitRepository extends CrudRepository<produit, Long> {
	
	@Query("SELECT p FROM produit p WHERE CONCAT(p.codeProduit, ' ', p.libelleProduit, ' ', p.prix) LIKE %?1%")
	public List<produit> search(String keyword);

}