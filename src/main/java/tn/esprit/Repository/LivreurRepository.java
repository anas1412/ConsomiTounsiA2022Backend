package tn.esprit.Repository;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import tn.esprit.Entities.Livreur;

@Repository
public interface LivreurRepository extends CrudRepository<Livreur, Long>{
	
	 @Query("SELECT l FROM Livreur l WHERE l.nom like %?1 or l.prenom like %?1")

		List<Livreur> findByName(String Nom);
		
		@Query("SELECT l FROM Livreur l WHERE l.ville like %?1")
		List<Livreur> findByCity(String City);
		
		@Query("SELECT l FROM Livreur l ORDER BY nom ASC")
		List<Livreur> SortUp();
		
		@Query("SELECT l FROM Livreur l Order BY nom DESC")
		List<Livreur> SortDown();
		
		@Query("SELECT l FROM Livreur l WHERE l.statutCompte= false")
		List<Livreur> ShowHired();
		
		@Query("SELECT l FROM Livreur l WHERE l.adresseEmail like %?1")
		Livreur getByEmail(String email);

		
		
	
}
