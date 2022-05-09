package tn.esprit.Repository;

import java.util.Date;
import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import tn.esprit.Entities.User;
import tn.esprit.Entities.facture;

@Repository
public interface FactureRepository extends CrudRepository<facture, Long> {
	
	//@Query(value = "SELECT * FROM facture WHERE type = ?1", nativeQuery = true)
	facture findByType(String type);
	
	@Query(value = "SELECT * FROM facture WHERE etat_livraison = ?1", nativeQuery = true)
	facture findByetat_livraison(String etat_livraison);
	
	//@Query(value = "SELECT * FROM facture WHERE date = ?1", nativeQuery = true)
	facture findByDate(Date date);
	
	List<facture> findByUser(User user);

}
