package tn.esprit.Services;

import java.util.List;

import tn.esprit.Entities.panier;
import tn.esprit.Entities.panierProduit;

public interface IPanierService {

	List<panier> retrieveAllPanier();

	panier addPanier(panier p);

	panier updatePanier(panier p);

	panier retrievePanier(Long id);

	void removePanier(Long id);

	panier addPanier(panier p, Long id);
	
}