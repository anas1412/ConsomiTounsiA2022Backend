package tn.esprit.Repository;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import tn.esprit.Entities.User;
import tn.esprit.Entities.paiement;
import tn.esprit.Entities.panierProduit;
import tn.esprit.Entities.produit;

@Repository
public interface PaiementRepository extends CrudRepository<paiement, Long> {
	
	List<paiement> findByUser(User user);

}