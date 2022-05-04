package tn.esprit.Services;

import java.util.List;

import tn.esprit.Entities.Livraison;


public interface ILivraisonService {
	
	List<Livraison> retrieveAllLivraisons();

	Livraison addLivraison (Livraison liv, Long idFacture, Long idLivreur);

	Livraison updateLivraison (Livraison liv, Long idFacture, Long idLivreur);
	
	Livraison retrieveLivraison(Long idLivraison);

}
