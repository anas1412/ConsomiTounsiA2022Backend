package tn.esprit.Services;

import java.util.List;

import tn.esprit.Entities.panier;
import tn.esprit.Entities.panierProduit;

public interface IPanierService {

	List<panier> retrieveAllPanier();

	panier retrievePanier(Long id);

	void removePanier(Long id);

	panier addToPanier(panier p, Long IdProduitPanier);

	panier addPanier(panier p, Long id);

	void removeFromPanier(panier p, Long IdProduitPanier);

	
}