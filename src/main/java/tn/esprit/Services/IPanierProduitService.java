package tn.esprit.Services;

import java.util.List;

import tn.esprit.Entities.User;
import tn.esprit.Entities.panierProduit;

public interface IPanierProduitService {
	
	
	
	//panierProduit updateQte(Long idProduit, int quantity, Long id);

	panierProduit addProduit(Long idProduit, int quantity, Long id);

	List<panierProduit> detailPanier(Long user_id);

	void removeProduit(User user, Long idProduit);

	//panierProduit updateQte(panierProduit pp, int quantity);

	panierProduit updateQte(panierProduit pp);
	
}