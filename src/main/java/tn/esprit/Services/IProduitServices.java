package tn.esprit.Services;

import java.util.List;

import tn.esprit.Entities.produit;

public interface IProduitServices {

	List<produit> retrieveAllProduits();
	
	produit addProduit (produit p, Long idCategorieProduit, Long idStock, Long idUser);

	produit updateProduit (produit p);
	
	produit retrieveProduit(Long id);
	
	void deleteProduit (Long id);

	List<produit> listAll(String keyword);
}