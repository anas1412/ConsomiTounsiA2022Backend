package tn.esprit.Services;

import java.util.Date;
import java.util.List;

import tn.esprit.Entities.Livraison;


public interface ILivraisonService {
	
	List<Livraison> retrieveAllLivraisons();

	Livraison addLivraison (Livraison liv, Long idFacture, Long idLivreur);

	Livraison updateLivraison (Livraison liv);
	
	Livraison retrieveLivraison(Long idLivraison);
	
	void removeLivraison(Long idLivraison);
	
	List<Livraison> FindByIdLivreur(Long idLivreur);
	
	List<Livraison> findByDate(Date  DateLiv);
	
	List<Livraison> orderByDate();
	
	int CountDelivered();
	
	int CountUndelivered();
	
	Livraison deliverLivraison(Long idLivraison);

}
