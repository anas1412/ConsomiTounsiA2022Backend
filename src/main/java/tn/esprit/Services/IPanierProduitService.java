package tn.esprit.Services;

import java.util.List;

import tn.esprit.Entities.panierProduit;

public interface IPanierProduitService {

	List<panierProduit> retrieveAllPanierProduit();

	panierProduit updatePanierProduit(panierProduit pp);

	panierProduit retrievePanierProduit(Long id);

	void removePanierProduit(Long id);

	panierProduit addPanierProduit(panierProduit pp, Long idProduit);

	//List<panierProduit> retrieveAllPanierProduit(Long idPanier);
	
}